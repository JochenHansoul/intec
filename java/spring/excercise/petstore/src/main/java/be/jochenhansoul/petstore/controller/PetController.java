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

    @GetMapping("{id}")
    public ResponseEntity getPet(@PathVariable Long id) {
        Optional<Pet> optionalPet = PET_SERVICE.getPet(id);
        return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                : ResponseEntity.status(404).body("No pet found with id " + id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePet(@PathVariable Long id) {
        return (PET_SERVICE.delete(id)) ? ResponseEntity.ok().build()
                : ResponseEntity.status(404).body("No pet found with id " + id);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormatException() {
        return ResponseEntity.status(400).body("id is not of type number");
    }
}
