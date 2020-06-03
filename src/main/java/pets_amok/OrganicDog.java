package pets_amok;

public class OrganicDog extends Dog implements OrganicDetails {

    private int hunger;
    private int thirst;
    private int cageCleanliness;
    private int needToEliminateWaste;

    public OrganicDog(String name, String description) {
        super(name, description);
    }

    public OrganicDog(String name, String description, int health, int happiness, int boredom, int hunger, int thirst, int cageCleanliness, int needToEliminateWaste) {
        super(name, description, health, happiness, boredom);
        this.hunger = hunger;
        this.thirst = thirst;
        this.cageCleanliness = cageCleanliness;
        this.needToEliminateWaste = needToEliminateWaste;
    }

    public void setNeedToEliminateWaste(int needToEliminateWaste) {
        this.needToEliminateWaste = needToEliminateWaste;
    }

    public void actionCleanCage() {
        cageCleanliness += 20;

    }

    @Override
    public void actionWalkDogs() {
        health += 5;
        happiness += 5;
        boredom -= 5;
        thirst -= 3;
        hunger -= 3;
        setNeedToEliminateWaste(50);
    }

    @Override
    public void actionPlayWithAnAnimal() {
        boredom -= 15;
        happiness += 10;
        hunger += 5;
        thirst += 5;
        health += 2;
    }

    @Override
    public void feed() {
        hunger -= 5;
        thirst += 3;
        needToEliminateWaste += 5;

    }

    @Override
    public void giveWater() {
        thirst -= 5;
        needToEliminateWaste += 5;

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
                hunger + "\t\t" + "|" + thirst + "\t\t" + "|" + cageCleanliness + "\t\t\t\t\t" + "|" + needToEliminateWaste + "\t\t\t\t" + "|" + "N/A";
    }

    @Override
    public void tick() {
        boredom += 1;
        thirst += 1;
        hunger += 1;
        cageCleanliness -= 1;
        needToEliminateWaste += 3;

        if (cageCleanliness >= 40 || hunger <= 40 || thirst <= 40 || boredom <= 40) {
            int currentHealthStatus = super.getHealth();
            super.setHealth(currentHealthStatus + 5);
            int currentHappiness = super.getHappiness();
            super.setHappiness(currentHappiness + 5);
        }

        if (cageCleanliness <= 49) {
            int currentHealthStatus = super.getHealth();
            super.setHealth(currentHealthStatus - 1);
            int currentHappiness = super.getHappiness();
            super.setHappiness(currentHappiness - 1);
        }
    }
}
