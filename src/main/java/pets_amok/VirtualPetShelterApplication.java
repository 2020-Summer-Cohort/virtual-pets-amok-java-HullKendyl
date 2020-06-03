package pets_amok;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApplication {

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

        welcomeStatement(od1, rd1, oc1, rc1);

        gameLoop(petShelter);
    }

    private static void gameLoop(VirtualPetShelter petShelter) {
        while (true) {


            currentStats(petShelter);

            playerMenu();

            Scanner scanner = new Scanner(System.in);
            int optionSelection = scanner.nextInt();
            scanner.nextLine();

            if (optionSelection == 1) {
                feedAllPets(petShelter);
            } else if (optionSelection == 2) {
                waterAllPets(petShelter);
            } else if (optionSelection == 3) {
                cleanOrganicDogCages(petShelter);
            } else if (optionSelection == 4) {
                oilRoboticAnimals(petShelter);
            } else if (optionSelection == 5) {
                if (playWithAChosenPet(petShelter, scanner)) break;
            } else if (optionSelection == 6) {
                walkAllDogs(petShelter);
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
                admitAPet(petShelter, optionSelection, admittedAnimalName, admittedAnimalDescription);

            } else if (optionSelection == 9) {
                quit();
                break;
            } else {
                continue;
            }

            petShelter.tickAll();
        }
    }

    private static void quit() {
        System.out.println("Thank you for playing. See you later!");
        return;
    }

    private static void admitAPet(VirtualPetShelter petShelter, int optionSelection, String admittedAnimalName, String admittedAnimalDescription) {
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
    }

    private static void walkAllDogs(VirtualPetShelter petShelter) {
        for (VirtualPet virtualPet : petShelter.petMap.values())
            if (virtualPet instanceof Dog) {
                ((Dog) virtualPet).actionWalkDogs();
            }
        System.out.println("Those are some happy and exhausted dogs! Hope the walk was fun.");
    }

    private static boolean playWithAChosenPet(VirtualPetShelter petShelter, Scanner scanner) {
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
            return true;
        }
        return false;
    }

    private static void oilRoboticAnimals(VirtualPetShelter petShelter) {
        for (VirtualPet virtualPet : petShelter.petMap.values()) {
            if (virtualPet instanceof RobotDetails) {
                ((RobotDetails) virtualPet).oilRobot();
            }
        }
        System.out.println("More oil did the trick!");
    }

    private static void cleanOrganicDogCages(VirtualPetShelter petShelter) {
        for (VirtualPet virtualPet : petShelter.petMap.values()) {
            if (virtualPet instanceof OrganicDog) {
                ((OrganicDog) virtualPet).actionCleanCage();
            }
        }
        System.out.println("Way to go! The cages are spotless and the non-robotic dogs are very comfortable.");
    }

    private static void waterAllPets(VirtualPetShelter petShelter) {
        for (VirtualPet virtualPet : petShelter.petMap.values()) {
            if (virtualPet instanceof OrganicDetails) {
                ((OrganicDetails) virtualPet).giveWater();
            }
        }
        System.out.println("A nice drink of cold water is exactly what those pets needed!");
    }

    private static void feedAllPets(VirtualPetShelter petShelter) {
        for (VirtualPet virtualPet : petShelter.petMap.values()) {
        if (virtualPet instanceof OrganicDetails) {
            ((OrganicDetails) virtualPet).feed();
        }
    }
        System.out.println("Great job feeding the non-robotic animals!");
    }

    private static void playerMenu() {
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
    }

    private static void currentStats(VirtualPetShelter petShelter) {
        System.out.println("\n" + " - Current Stats - " + "\n");
        System.out.println("Name\t|Health\t|Happiness\t|Boredom\t|Hunger\t|Thirst\t|Cage Cleanliness\t|Need to Potty\t|Oil Amount");
        System.out.println("----\t|------\t|---------\t|-------\t|------\t|------\t|---- -----------\t|---- -- -----\t|--- ------");
        for (VirtualPet petToDisplay : petShelter.retrieveAllVirtualPets()) {
            System.out.println(petToDisplay.retrieveStatus());
        }
    }

    private static void welcomeStatement(OrganicDog od1, RobotDog rd1, OrganicCat oc1, RobotCat rc1) {
        System.out.println("Welcome to DAS: The Domesticated Animal Shelter!" + "\n");
        System.out.println("As this is your first day volunteering, " + "\n" +
                "we would like to familiarize you with our animal residents and " + "\n" +
                "your responsibilities." + "\n");
        System.out.println("Meet " + od1.getName() + ", " + rd1.getName() + ", " + oc1.getName() + ", and "+ rc1.getName() + "." + "\n");
        System.out.println(od1.getName() + " is a " + od1.getDescription() + "\n");
        System.out.println(rd1.getName() + " is a " + rd1.getDescription() + "\n");
        System.out.println(oc1.getName() + " is a " + oc1.getDescription() + "\n");
        System.out.println(rc1.getName() + " is a " + rc1.getDescription() + "\n");
        System.out.println("Let's check out the statuses of their current needs.");
    }
}