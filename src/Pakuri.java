public class Pakuri
{
    // declare and initialize variables
    private String species;
    private int attack, defense, speed;

    // this method should be the only constructor for this class
    // there isn't a default constructor
    public Pakuri(String species)
    {
        // attack, defense, and speed levels have these as the inital values when first created
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }

    // returns the species of this critter
    public String getSpecies()
    {
        return this.species;
    }

    // returns the attack value for this critter
    public int getAttack()
    {
        return this.attack;
    }

    // returns the defense value for this critter
    public int getDefense()
    {
        return this.defense;
    }

    // returns the speed of this critter
    public int getSpeed()
    {
        return this.speed;
    }

    // changes the attack value for this critter to newAttack
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }

    // will evolve the critter as follows: double the attack, quadruple the defense, and triple the speed
    public void evolve()
    {
        this.attack *= 2;
        this.defense *= 4;
        this.speed *= 3;
    }
}
