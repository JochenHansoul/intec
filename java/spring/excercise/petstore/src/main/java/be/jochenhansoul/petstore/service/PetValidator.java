package be.jochenhansoul.petstore.service;

import be.jochenhansoul.petstore.model.Pet;

public class PetValidator {
    public static boolean validate(Pet pet) {
        return pet.getId() == 0
                && pet.getCategory() != null
                && pet.getName() != null
                && pet.getName().length() > 0
                && pet.getStatus() != null;
    }
}
