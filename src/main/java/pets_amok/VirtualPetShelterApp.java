package pets_amok;

public class VirtualPetShelterApp {

    public static void main(String[] args) {

        //Create Objects

        OrganicDogs organicDog1 = new OrganicDogs("Finn",
                "Labradoodle. He is hyperactive and loves to play.", 50, 50, 50);
        OrganicCats organicCat1 = new OrganicCats("Mr. Fuzzers",
                "Tabby Cat. He is quite lazy and really enjoys his heat lamp.", 50, 50, 50);
        RobotDogs robotDog1 = new RobotDogs("Frodo",
                "Robot Corgi. He is a silly robot dog that cannot control the booty wiggles.", 50, 50, 50);
        RobotCats robotCat1 = new RobotCats("Sam",
                "Robot Blue Russian Cat. He is timid but loves cuddles.", 50, 50, 50);

        //Create shelterAnimals (petMap) to interact with all pets at one time.

        VirtualPetShelter shelterAnimals = new VirtualPetShelter();
        shelterAnimals.addAnimal(organicDog1);
        shelterAnimals.addAnimal(organicCat1);
        shelterAnimals.addAnimal(robotDog1);
        shelterAnimals.addAnimal(robotCat1);

        // Game Introduction

        welcomeStatement(organicDog1, organicCat1, robotDog1, robotCat1);
        gameLoop(shelterAnimals);

    }

    private static void welcomeStatement(OrganicDogs organicDog1, OrganicCats organicCat1, RobotDogs robotDog1, RobotCats robotCat1) {
        System.out.println("Welcome to The VirtualPet Animal Shelter!\n");
        System.out.println("As this is your first day volunteering, " + "\n" +
                "we would like to familiarize you with our animal residents and " + "\n" +
                "your responsibilities." + "\n");
        System.out.println("Meet " + organicDog1.getName() + ", " + organicCat1.getName() + ", " + robotDog1.getName() + ", " + robotCat1.getName() + ".");
        System.out.println("-\t" + organicDog1.getName() + " is a " + organicDog1.getDescription() + "\n");
        System.out.println("-\t" + organicCat1.getName() + " is a " + organicCat1.getDescription() + "\n");
        System.out.println("-\t" + robotDog1.getName() + " is a " + robotDog1.getDescription() + "\n");
        System.out.println("-\t" + robotCat1.getName() + " is a " + robotCat1.getDescription() + "\n");
        System.out.println("Let's check out the status of their current needs.");
    }

    private static void gameLoop(VirtualPetShelter shelter) {
        while (true) {
            showAnimalCurrentNeedsStatus(shelter);
        }
    }

    private static void showAnimalCurrentNeedsStatus(VirtualPetShelter shelter) {
        System.out.println("\n" + " - Current Stats - " + "\n");
        System.out.println("Name\t|Boredom\t|Health\t|Happiness\t|Hunger\t|Thirst\t|Cage Cleanliness\t|Oil/Maintenance Level");
        System.out.println("----\t|-------\t|------\t|---------\t|------\t|------\t|----------------\t|---------------------");
        for (VirtualPet petToDisplay : shelter.retrieveAllPets()) {
            System.out.println(petToDisplay.retrieveStatus());
        }
    }
}
// Begin Game Loop
//
//        while (winConditions(shelterAnimals)) {
//
//            // Current Stats
//
//            showAnimalCurrentNeedsStatus(shelterAnimals);
//
//            // Player Selection
//
//            playerOptions();
//
//            //use scanner to read player responses
//
//            Scanner scanner = new Scanner(System.in);
//
//            //user int playerSelection to create a spot for user input
//
//            int playerSelection = scanner.nextInt();
//            scanner.nextLine();
//
//            //if statements to recognize playerSelection & direct game on what to do based on their selection
//
//            if (playerSelection == 1) {
//                System.out.println("You give food to all of the animals.");
//                shelterAnimals.actionFeedOrganicAnimals();
//            } else if (playerSelection == 2) {
//                System.out.println("You give water to each of the animals.");
//                shelterAnimals.actionGiveWaterToOrganicAnimals();
//            } else if (playerSelection == 3) {
//                System.out.println("Which animal would you like to play with?");
//                for (VirtualPet pet:shelterAnimals.retrieveAllPets()) {
//                    System.out.println(pet.getName() + " - " + pet.getDescription());
//                }
//                String playerPlayChoice = scanner.nextLine();
//                // returns true if animal is in shelter
//                if (shelterAnimals.retrievePetNames().contains(playerPlayChoice)){
//                    shelterAnimals.actionPlayWithPet(playerPlayChoice);
//                    System.out.println("You picked " + playerPlayChoice + ".");
//                } else {
//                    System.out.println("Sorry that animal does not exist.");
//                    continue;
//                }
//            }else if (playerSelection == 4) {
//                shelterAnimals.adopt();
//            }else if (playerSelection == 5) {
//                System.out.println("In order to admit an animal, please provide the following information as it is requested:");
//                System.out.println("Animal Name:");
//                String admittedAnimalName = scanner.nextLine();
//                System.out.println("Animal Description: (species & characteristics)");
//                String admittedAnimalDescription = scanner.nextLine();
//                System.out.println("Thank you. " + admittedAnimalName + " is now under the care of DAS.");
//                Random randomNumber = new Random();
//                shelterAnimals.addAnimal(new VirtualPet(admittedAnimalName, admittedAnimalDescription, randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50)));
//            } else if (playerSelection == 9){
//                System.out.println("Thank you for playing. See you later!");
//                break;
//            } else {
//                continue;
//            }
//
//            // call to tick method in VirtualPetShelter
//            shelterAnimals.tickAll();

//        }
//    }
/*
//    private static boolean winConditions(VirtualPetShelter shelter) {
//
//        for (VirtualPet pet:shelter.petMap.values()) {
//            if (pet.getBoredom() <= 0 || pet.getHunger() <= 0 || pet.getThirst() <= 0) {
//                System.out.println(pet.getName() + " has died! You lose.");
//                return false;}
//            if (pet.getBoredom() >= 100 || pet.getHunger() >= 100 || pet.getThirst() >= 100){
//                System.out.println(pet.getName() + " current needs have been met. Congratulations! You Win!");
//                return false;}
//        }
//        return true;
//    }
//

//    }
//
//    private static void playerOptions() {
//        System.out.println("\n" + "What would you like to do?");
//        System.out.println("1. Feed the animals");
//        System.out.println("2. Give the animals water");
//        System.out.println("3. Play with an animal");
//        System.out.println("4. Adopt an animal");
//        System.out.println("5. Admit an animal");
//        System.out.println("6. Walk all dogs");
//        System.out.println("7. Clean dog cages");
//        System.out.println("8. Oil all robotic animals");
//        System.out.println("9: Quit");
////    }
//
//}

 */