package pets_amok;

public class RobotDog extends Dog implements RobotDetails{

    private int oilAmount;

    public RobotDog(String name, String description) {
        super(name, description);
    }

    public RobotDog(String name, String description, int health, int happiness, int boredom, int oilAmount) {
        super(name, description, health, happiness, boredom);
        this.oilAmount = oilAmount;
    }


    @Override
    public void actionWalkDogs() {
        happiness += 5;
        boredom -= 5;
       oilAmount -= 5;
    }

    @Override
    public void oilRobot() {
        health += 5;
        oilAmount += 5;
        happiness += 5;
    }

    @Override
    public int getOilAmount() {
        return oilAmount;
    }

    @Override
    public void actionPlayWithAnAnimal(){
        boredom -= 10;
        happiness += 10;
        health += 2;
        oilAmount -= 4;
    }

    @Override
    public String retrieveStatus(){
        return name + "\t" + "|" + health + "\t\t" + "|" + happiness + "\t\t\t" + "|" + boredom  + "\t\t\t" + "|" +
                "N/A" + "\t" + "|" + "N/A" + "\t" + "|" + "N/A" + "\t\t\t\t" + "|" + "N/A" + "\t\t\t" + "|" + oilAmount;
    }

    @Override
    public void tick() {
        happiness -= 1;
        health -= 1;
        boredom += 1;
        oilAmount -= 1;
    }
}
