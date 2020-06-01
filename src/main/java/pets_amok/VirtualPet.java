package pets_amok;

public abstract class VirtualPet {

    protected  String name;
    protected  String description;
    protected int health;
    protected int happiness;
    protected int boredom;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VirtualPet(String name, String description, int health, int happiness, int boredom) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.happiness = happiness;
        this.boredom = boredom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void actionPlayWithAnAnimal(){
        boredom -= 10;
        happiness += 10;
    }

    public void tick(){
        happiness -= 1;
        health -= 1;
        boredom -= 1;
    }

    public abstract String retrieveStatus();
}
