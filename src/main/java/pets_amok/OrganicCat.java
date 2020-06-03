package pets_amok;

public class OrganicCat extends Cat implements OrganicDetails {

    private int hunger;
    private int thirst;

    public OrganicCat(String name, String description) {
        super(name, description);
    }

    public OrganicCat(String name, String description, int health, int happiness, int boredom, int hunger, int thirst) {
        super(name, description, health, happiness, boredom);
        this.hunger = hunger;
        this.thirst = thirst;
    }


    @Override
    public void feed() {
        hunger -= 5;
        thirst += 3;
    }

    @Override
    public void giveWater() {
        thirst -= 5;
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public int getThirst() {
        return thirst;
    }

    @Override
    public String retrieveStatus() {
        return name + "\t" + "|" + health + "\t\t" + "|" + happiness + "\t\t\t" + "|" + boredom + "\t\t\t" + "|" +
                hunger + "\t\t" + "|" + thirst + "\t\t" + "|" + "N/A" + "\t\t\t\t" + "|" + "N/A" + "\t\t\t" + "|" + "N/A";
    }

    @Override
    public void tick() {
        happiness -= 1;
        health -= 1;
        boredom += 1;
        thirst -= 1;
        hunger -= 1;
    }
}

