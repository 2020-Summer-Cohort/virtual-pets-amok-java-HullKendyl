package pets_amok;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApplication {

// TDD: While getting the project done is always more important than getting it done the "right way", we'd like you to write
// tests for this application. Contact one of us if you want a hand getting started with them

// Clean Code: Your main method is pretty long and and dense. If this were an enterprise application and we added more and more
// code, eventually it would be very difficult to work with. Move functionality like feeding all animals into the VirtualPetShelter,
// and then call those methods from within your main method. You can also split chunks like your System.out.println blocks into their own
// methods in VirtualPetShelterApplication to clean up the main method.

// OOP: Notice how much is of the contents of the OrganicCat and OrganicDog classes are common between them. When we see code duplicated
// like that, another super class is useful. It's tricky to figure out where to use an interface and where to use a super class at first.
// We're here if you want to talk it through

    public static void main(String[] args) {

        OrganicDog od1 = new OrganicDog("Buddy", "Border Collie. He is highly energetic and loves to play,",
                50, 50, 50, 50, 50, 50, 50);
        RobotDog rd1 = new RobotDog("Charlie", "small robot dog. He enjoys his lazy days.", 50, 50, 50, 50);
        OrganicCat oc1 = new OrganicCat("Wilma", "Calico Cat. Scared of strangers.", 50, 50, 50, 50, 50);
        RobotCat rc1 = new RobotCat("Chester", "Robot cat that analyzes territory before mousing.", 50, 50, 50, 50);

        VirtualPetShelter petShelter = new VirtualPetShelter();

        petShelter.addVirtualPet(od1);
        petShelter.addVirtualPet(rd1);
        petShelter.addVirtualPet(oc1);
        petShelter.addVirtualPet(rc1);

        while (true) {

            petShelter.tickAll();

            System.out.println("\n" + " - Current Stats - " + "\n");
            System.out.println("Name\t|Health\t|Happiness\t|Boredom\t|Hunger\t|Thirst\t|Cage Cleanliness\t|Need to Potty\t|Oil Amount");
            System.out.println("----\t|------\t|---------\t|-------\t|------\t|------\t|---- -----------\t|---- -- -----\t|--- ------");
            for (VirtualPet petToDisplay : petShelter.retrieveAllVirtualPets()) {
                System.out.println(petToDisplay.retrieveStatus());
            }

            System.out.println("\n What would you like to do next? \n *Enter a number (1-9) to make your selection* \n-----");
            System.out.println("1. Feed animals.");
            System.out.println("2. Give water to animals.");
            System.out.println("3. Clean dog cages.");
            System.out.println("4. Oil robotic animals.");
            System.out.println("5. Play with an animal.");
            System.out.println("6. Walk all dogs.");
            System.out.println("7. Adopt an animal.");
            System.out.println("8. Admit an animal.");
            System.out.println("9. Quit.");

            Scanner scanner = new Scanner(System.in);
            int optionSelection = scanner.nextInt();
            scanner.nextLine();

            if (optionSelection == 1) {
                for (VirtualPet virtualPet : petShelter.petMap.values()) {
                    if (virtualPet instanceof OrganicDetails) {
                        ((OrganicDetails) virtualPet).feed();
                    }
                }
                System.out.println("Great job feeding the non-robotic animals!");
            } else if (optionSelection == 2) {
                for (VirtualPet virtualPet : petShelter.petMap.values()) {
                    if (virtualPet instanceof OrganicDetails) {
                        ((OrganicDetails) virtualPet).giveWater();
                    }
                }
                System.out.println("A nice drink of cold water is exactly what those pets needed!");
            } else if (optionSelection == 3) {
                for (VirtualPet virtualPet : petShelter.petMap.values()) {
                    if (virtualPet instanceof OrganicDog) {
                        ((OrganicDog) virtualPet).actionCleanCage();
                    }
                }
                System.out.println("Way to go! The cages are spotless and the non-robotic dogs are very comfortable.");
            } else if (optionSelection == 4) {
                for (VirtualPet virtualPet : petShelter.petMap.values()) {
                    if (virtualPet instanceof RobotDetails) {
                        ((RobotDetails) virtualPet).oilRobot();
                    }
                }
                System.out.println("More oil did the trick!");
            } else if (optionSelection == 5) {
                System.out.println("Which animal would you like to play with?");
                for (VirtualPet pet : petShelter.retrieveAllVirtualPets()) {
                    System.out.println(pet.getName() + " - " + pet.getDescription());
                }
                String playerPlayChoice = scanner.nextLine();
                if (petShelter.retrievePetNames().contains(playerPlayChoice)) {
                    petShelter.actionPlayWithPet(playerPlayChoice);
                    System.out.println("You picked " + playerPlayChoice + ".");
                    System.out.println(playerPlayChoice + " loved playing with you and looks forward to next time.");
                } else {
                    System.out.println("Sorry that animal does not exist.");
                    break;
                }
                continue;
            } else if (optionSelection == 6) {
                for (VirtualPet virtualPet : petShelter.petMap.values())
                    if (virtualPet instanceof Dog) {
                        ((Dog) virtualPet).actionWalkDogs();
                    }
                System.out.println("Those are some happy and exhausted dogs! Hope the walk was fun.");
            } else if (optionSelection == 7) {
                petShelter.adopt();
            } else if (optionSelection == 8) {
                System.out.println("In order to admit an animal, please provide the following information as it is requested:");
                System.out.println("Animal Name:");
                String admittedAnimalName = scanner.nextLine();
                System.out.println("Animal Description: (breed & characteristics)");
                String admittedAnimalDescription = scanner.nextLine();
                System.out.println("Enter the number below that corresponds with the type pf animal you are admitting.");
                System.out.println("1. Organic Dog");
                System.out.println("2. Organic Cat");
                System.out.println("3. Robotic Dog");
                System.out.println("4. Robotic Cat");
                optionSelection = scanner.nextInt();
                if (optionSelection == 1) {
                    Random randomNumber = new Random();
                    OrganicDog admittedPet = new OrganicDog(admittedAnimalName, admittedAnimalDescription,
                            randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50),
                            randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50),
                            randomNumber.nextInt(50));
                    petShelter.addVirtualPet(admittedPet);
                }
                if (optionSelection == 2) {
                    Random randomNumber = new Random();
                    OrganicCat admittedPet = new OrganicCat(admittedAnimalName, admittedAnimalDescription,
                            randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50),
                            randomNumber.nextInt(50), randomNumber.nextInt(50));
                    petShelter.addVirtualPet(admittedPet);
                }
                if (optionSelection == 3) {
                    Random randomNumber = new Random();
                    RobotDog admittedPet = new RobotDog(admittedAnimalName, admittedAnimalDescription,
                            randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50),
                            randomNumber.nextInt(50));
                    petShelter.addVirtualPet(admittedPet);
                }
                if (optionSelection == 4) {
                    Random randomNumber = new Random();
                    RobotCat admittedPet = new RobotCat(admittedAnimalName, admittedAnimalDescription,
                            randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50),
                            randomNumber.nextInt(50));
                    petShelter.addVirtualPet(admittedPet);
                }
                System.out.println("Thank you. " + admittedAnimalName + " is now under the care of DAS.");

            } else if (optionSelection == 9) {
                System.out.println("Thank you for playing. See you later!");
                break;
            } else {
                continue;
            }
        }
    }
}