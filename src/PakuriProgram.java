import java.util.InputMismatchException;
import java.util.Scanner;

public class PakuriProgram
{
    // pakuri program class (driver/program)
    public static void main(String[] args)
    {
        // declare and initialize variables
        Scanner scan = new Scanner(System.in);
        int capacity;
        int menu;
        String name;

        // display a welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        // prompts for/read pakudex capacity and confirm

        while(true)
        {
            System.out.print("Enter max capacity of the Pakudex: ");

            // try statement to check if capacity input is valid
            try
            {
                // scans in the user input
                capacity = scan.nextInt();

                if(capacity < 0)
                {
                    System.out.println("Please enter a valid size.");
                    continue;
                }
                break;
            }
            // catch statement to check if capacity input is valid
            catch(Exception e)
            {
                System.out.println("Please enter a valid size.");
                scan.next();
            }
        }

        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");
        Pakudex list = new Pakudex(capacity);
        // declare and initialize variable
        int[] adding;

        // while loop to go through the program until int menu == 6
        while(true)
        {
            // display the menu
            System.out.println();
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println();
            // prompt for input
            System.out.print("What would you like to do? ");

            // try statement to check if user input is valid
            try
            {
                menu = scan.nextInt();

                // if statement when user inputs int menu = 1
                if(menu == 1)
                {
                    // if statement when SpeciesArray == null
                    if(list.getSpeciesArray() == null)
                    {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }
                    // else statement to go through the array
                    else
                    {
                        String[] print = list.getSpeciesArray();
                        System.out.println("Pakuri In Pakudex:");

                        // for loop to print out the pakuri in the array
                        for(int i = 0; i < list.getSize(); i++)
                        {
                            System.out.println(i + 1 + ". " + print[i]);
                        }
                    }
                }
                // else if statement when user inputs int menu = 2
                else if(menu == 2)
                {
                    System.out.print("Enter the name of the species to display: ");
                    name = scan.next();
                    adding = list.getStats(name);

                    // if statement when the pakuri is not found
                    if(adding == null)
                    {
                        System.out.println("Error: No such Pakuri!");
                    }
                    // else statement to print out the attack, defense, and speed
                    else
                    {
                        System.out.println();
                        System.out.println("Species: " + name);
                        System.out.println("Attack: " + adding[0]);
                        System.out.println("Defense: " + adding[1]);
                        System.out.println("Speed: " + adding[2]);
                    }
                }
                // else if statement when user inputs int menu = 3
                else if(menu == 3)
                {
                    // if statement when array is full
                    if(list.getSize() == list.getCapacity())
                    {
                        System.out.println("Error: Pakudex is full!");
                        continue;
                    }

                    System.out.print("Enter the name of the species to add: ");
                    name = scan.next();

                    // if statement when the array is not full and the pakuri has not been added
                    if(list.addPakuri(name))
                    {
                        System.out.println("Pakuri species " + name + " successfully added!");
                    }
                    // else statement when the array is not full and the pakuri has been added
                    else
                    {
                        System.out.println("Error: Pakudex already contains this species!");
                    }
                }
                // else if statement when user inputs int menu = 4
                else if(menu == 4)
                {
                    System.out.print("Enter the name of the species to evolve: ");
                    name = scan.next();

                    // if statement to evolve the species
                    if(list.evolveSpecies(name))
                    {
                        System.out.println(name + " has evolved!");
                    }
                    // else statement if the species is not found in pakuri
                    else
                    {
                        System.out.println("Error: No such Pakuri!");
                    }
                }
                // else if statement when user inputs int menu = 5
                else if(menu == 5)
                {
                    list.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                }
                // else if statement when user inputs int menu = 6
                else if(menu == 6)
                {
                    System.out.println("Thanks for using Pakudex! Bye!");
                    break;
                }
                // else statement when user input isn't valid
                else
                {
                    System.out.println("Unrecognized menu selection!");
                }
            }
            // catch statement to check if user input is valid
            catch(InputMismatchException e)
            {
                System.out.println("Unrecognized menu selection!");
                scan.next();
            }
        }
    }
}
