package pets_amok;


public class VirtualPet {

    // declare variables

    private String name;
    private String description;
    private int boredom;
    private int health;
    private int happiness;

    // create constructor with name & description

    public VirtualPet(String name, String description){
        this.name = name;
        this.description = description;
    }

    public VirtualPet(String name, String description, int boredom, int health, int happiness) {
        this.name = name;
        this.description = description;
        this.boredom = boredom;
        this.health = health;
        this.happiness = happiness;

    }

    //generate getter methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getHealth() {return health;}

    public int getHappiness() {return happiness;}

    //methods to update game stats based on playerSelection

    public void actionFeedOrganicAnimals(){
//        hunger += 10;
//        thirst -= 2;
    }

    public void actionGiveWaterToOrganicAnimals(){
//        thirst += 10;
    }

    public void actionPlayWithAnAnimal(){
        boredom += 10;
//        hunger -= 2;
//        thirst -= 2;
    }

    void tick() {
        boredom = boredom -= 5;
//        hunger = hunger -= 5;
//        thirst = thirst -= 5;

    }
}
