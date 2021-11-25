package be.jochenhansoul.petstore.service;

import be.jochenhansoul.petstore.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetValidator {
    public boolean validate(Pet pet) {
        return pet.getCategory() != null
                && pet.getName() != null
                && pet.getName().length() > 0
                && pet.getStatus() != null;
    }
}
