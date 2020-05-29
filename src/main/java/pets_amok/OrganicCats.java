package pets_amok;

public class OrganicCats extends VirtualPet{

    //create fields

    int litterBoxCleanliness;
    private int hunger;
    private int thirst;

    //create constructor

    public OrganicCats(String name, String description, int boredom, int health, int happiness) {
        super(name, description, boredom, health, happiness);
    }

    //create getter methods

    public int getLitterBoxCleanliness() {
        return litterBoxCleanliness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    //create additional methods
}
