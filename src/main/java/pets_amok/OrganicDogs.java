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

   @Override
//           System.out.println("Name\t|Boredom\t|Health\t|Happiness\t|Hunger\t|Thirst\t|Cage Cleanliness\t|Oil/Maintenance Level");
   public String retrieveStatus() {
      return name + "\t" + "|" + boredom + "\t" + "|"
              + health + "\t" + "|" + happiness + "\t" + "|" + hunger + "\t" + "|" + thirst + "\t" + "|" + cageCleanliness + "\t" + "|" + "N/A";
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


