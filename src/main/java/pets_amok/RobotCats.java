package pets_amok;

public class RobotCats extends VirtualPet{

    //create fields
    private int oilMaintenanceLevel;

    //create constructor
    public RobotCats(String name, String description, int boredom, int health, int happiness) {
        super(name, description, boredom, health, happiness);
    }

    //create getter methods
    public int getOilMaintenanceLevel() {
        return oilMaintenanceLevel;
    }

    //create additional methods
}
