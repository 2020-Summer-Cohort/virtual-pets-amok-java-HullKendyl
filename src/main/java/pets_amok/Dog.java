package pets_amok;

public abstract class Dog extends VirtualPet{


    public Dog(String name, String description) {
        super(name, description);
    }

    public Dog(String name, String description, int health, int happiness, int boredom) {
        super(name, description, health, happiness, boredom);
    }

    public abstract void actionWalkDogs();
}
