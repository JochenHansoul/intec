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

    @GetMapping
    public ResponseEntity getPet(@RequestBody Long id) {
        if (id <= 0) {
            return ResponseEntity.status(400).build();
        } else {
            Optional<Pet> optionalPet = PET_SERVICE.getPet(id);
            return (optionalPet.isPresent())
                    ? ResponseEntity.ok(optionalPet.get())
                    : ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletePet(@RequestBody Long id) {
        return (id <= 0) ? ResponseEntity.status(400).build() :
                (PET_SERVICE.delete(id)) ? ResponseEntity.ok(200)
                        : ResponseEntity.status(404).build();
    }
}
