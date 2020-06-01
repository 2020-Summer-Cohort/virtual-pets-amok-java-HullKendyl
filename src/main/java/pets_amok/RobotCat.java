package pets_amok;

public class RobotCat extends Cat implements RobotDetails {

    private int oilAmount;

    public RobotCat(String name, String description) {
        super(name, description);
    }

    public RobotCat(String name, String description, int health, int happiness, int boredom, int oilAmount) {
        super(name, description, health, happiness, boredom);
        this.oilAmount = oilAmount;
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
    public String retrieveStatus() {
        return name + "\t" + "|" + health + "\t\t" + "|" + happiness + "\t\t\t" + "|" + boredom + "\t\t\t" + "|" +
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
