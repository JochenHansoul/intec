package be.jochenhansoul.petstore.controller;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pet/")
public class PetController {
    private final PetService PET_SERVICE;

    public PetController(PetService petService) {
        this.PET_SERVICE = petService;
    }

    @PostMapping
    public ResponseEntity addPet(@RequestBody Pet pet) {
        Optional<Pet> optionalPet = PET_SERVICE.save(pet);
        return (optionalPet.isPresent()) ? ResponseEntity.ok("found") : ResponseEntity.status(405).build();
    }

    @GetMapping("{petId}")
    public ResponseEntity getPet(@PathVariable String petId) {
        Long id = null;
        try {
            id = Long.parseLong(petId);
        } catch (NumberFormatException ignored) {
        }
        if (id == null) {
            return ResponseEntity.status(400).body("id is not of type number");
        } else if (id <= 0) {
            return ResponseEntity.status(400).body("id may not be lower then zero");
        } else {
            Optional<Pet> optionalPet = PET_SERVICE.getPet(id);
            return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                    : ResponseEntity.status(404).body("No pet found with id " + id);
        }
    }

    @DeleteMapping("{petId}")
    public ResponseEntity deletePet(@PathVariable String petId) {
        Long id = null;
        try {
            id = Long.parseLong(petId);
        } catch (NumberFormatException ignored) {
        }
        return (id == null) ? ResponseEntity.status(400).body("id is not of type number") :
                (id <= 0) ? ResponseEntity.status(400).body("id may not be lower then zero") :
                        (PET_SERVICE.delete(id)) ? ResponseEntity.ok(200)
                                : ResponseEntity.status(404).body("No pet found with id " + id);
    }
}
