package pets_amok;

public abstract class Cat extends VirtualPet {

    public Cat(String name, String description) {
        super(name, description);
    }

    public Cat(String name, String description, int health, int happiness, int boredom) {
        super(name, description, health, happiness, boredom);
    }
}
