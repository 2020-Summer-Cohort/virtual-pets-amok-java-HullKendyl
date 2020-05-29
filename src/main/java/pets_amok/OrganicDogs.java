package pets_amok;

public class OrganicDogs extends VirtualPet{

   //create fields
   private int cageCleanliness;
   private int hunger;
   private int thirst;

   //create constructor
   public OrganicDogs(String name, String description, int boredom, int health, int happiness) {
      super(name, description, boredom, health, happiness);
   }

   //create getter methods
   public int getHunger() {
      return hunger;
   }

   public int getCageCleanliness() {
      return cageCleanliness;
   }

   public int getThirst() {
      return thirst;
   }

   //create additional methods
}


