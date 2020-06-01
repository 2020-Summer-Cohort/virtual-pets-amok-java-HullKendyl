package pets_amok;

import java.util.*;

public class VirtualPetShelter {

    Map<String, VirtualPet> petMap = new HashMap<>();

    public void addVirtualPet(VirtualPet pet) {
        petMap.put(pet.getName(), pet);
    }

    public Collection<VirtualPet> retrieveAllVirtualPets() {
        return  petMap.values();
    }

    public Set<String> retrievePetNames(){
        return petMap.keySet();
    }

    public void actionPlayWithPet(String petName) {
        petMap.get(petName).actionPlayWithAnAnimal();
    }

    public void adopt() {
        System.out.println("Which animal would you like to adopt?");
        for (VirtualPet pet:retrieveAllVirtualPets()) {
            System.out.println(pet.getName() + " - " + pet.getDescription());
        }
        Scanner scanner = new Scanner(System.in);
        String adoptedAnimalName = scanner.nextLine();
        if (petMap.containsKey(adoptedAnimalName)) {
            petMap.remove(adoptedAnimalName);
            System.out.println("Yay! Congratulations on finding " + adoptedAnimalName + " a new home.");
        } else {
            System.out.println("Sorry that animal does not exist. Note: User input is case sensitive.");
        }

    }

    public void tickAll() {
        for (VirtualPet petToTick: petMap.values()){
            petToTick.tick();
        }
    }
}

