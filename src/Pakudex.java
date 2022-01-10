public class Pakudex
{
    // declare and initialize variables
    private Pakuri[] pakuriArray;
    private String[] speciesArray;
    private int[] stats;

    // default constructor, if called, the default size for the pakudex should be 20
    public Pakudex()
    {
        pakuriArray = new Pakuri[20];
    }

    // initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity)
    {
        pakuriArray = new Pakuri[capacity];
    }

    // returns the number of critters that the pakudex has the capacity to hold at most
    public int getSize()
    {
        // declare and initialize variable
        int size = 0;

        // for loops through the pakuriArray
        for(int i = 0; i < pakuriArray.length; i++)
        {
            // checks if pakuriArray[i] doesn't equal null, then add one to size
            if(pakuriArray[i] != null)
            {
                size++;
            }
        }
        return size;
    }

    // returns the number of critters currently being stored in the pakudex has the capacity to hold at most
    public int getCapacity()
    {
        return pakuriArray.length;
    }

    // returns a string array containing the species of the critters as ordered in the pakudex
    public String[] getSpeciesArray()
    {
        // if i equals 0, then return null
        if(getSize() == 0)
        {
            return null;
        }

        // declare and initialize variable
        speciesArray = new String[this.getSize()];

        // for loops and assigns pakuriArray[i] to speciesArray[i]
        for(int i = 0; i < speciesArray.length; i++)
        {
            speciesArray[i] = pakuriArray[i].getSpecies();
        }
        return speciesArray;
    }

    // returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, amd 2 respectively
    public int[] getStats(String species)
    {
        stats = new int[3];
        // for loops through the pakuriArray
        for(int i = 0; i < getSize(); i++)
        {
            // checks if pakuriArray[i] is equal to species
            if(pakuriArray[i].getSpecies().equals(species))
            {
                stats[0] = pakuriArray[i].getAttack();
                stats[1] = pakuriArray[i].getDefense();
                stats[2] = pakuriArray[i].getSpeed();
                return stats;
            }
        }

        // if species is not in the pakudex, return null
        return null;
    }

    // sorts the pakuri objects in this pakudex according to java standard lexicographical ordering of species name
    public void sortPakuri()
    {
        Pakuri temp;

        for(int i = 0; i < getSize() - 1; i++)
        {
            for(int j = i + 1; j < getSize(); j++)
            {
                if(pakuriArray[i].getSpecies().compareTo(pakuriArray[j].getSpecies()) > 0)
                {
                    temp = pakuriArray[i];
                    pakuriArray[i] = pakuriArray[j];
                    pakuriArray[j] = temp;
                }
            }
        }
    }

    // adds species to the pakudex
    public boolean addPakuri(String species)
    {
        // if successful, return true, and false otherwise
        for(int i = 0; i < getSize(); i++)
        {
            if(pakuriArray[i].getSpecies().equals(species))
            {
                return false;
            }
        }

        Pakuri add = new Pakuri(species);
        pakuriArray[this.getSize()] = add;
        return true;
    }

    // attempts to evolve species within the pakudex
    public boolean evolveSpecies(String species)
    {
        // if successful, return true, and false otherwise
        for(int i = 0; i < getSize(); i++)
        {
            if(pakuriArray[i].getSpecies().equals(species))
            {
                pakuriArray[i].evolve();
                return true;
            }
        }
        return false;
    }
}
