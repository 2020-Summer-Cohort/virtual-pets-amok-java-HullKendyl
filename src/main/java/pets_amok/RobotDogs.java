package pets_amok;

public class RobotDogs extends VirtualPet{

    //create fields
    private int oilMaintenanceLevel;

    //create constructor
    public RobotDogs(String name, String description, int boredom, int health, int happiness) {
        super(name, description, boredom, health, happiness);
    }

    //create getter method
    public int getOilMaintenanceLevel() {
        return oilMaintenanceLevel;
    }

    //create additional methods
}
