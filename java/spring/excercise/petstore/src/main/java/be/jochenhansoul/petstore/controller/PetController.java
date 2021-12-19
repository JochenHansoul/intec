package be.jochenhansoul.petstore.controller;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import be.jochenhansoul.petstore.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

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
        return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                : ResponseEntity.status(405).body("invalid input");
    }

    @PutMapping
    public ResponseEntity updatePet(@RequestBody Pet pet) {
        Optional<Pet> optionalPet = PET_SERVICE.update(pet);
        return (optionalPet.isPresent()) ? ResponseEntity.ok("updated")
                : ResponseEntity.status(405).body("validation exception");
    }

    @GetMapping("findByStatus")
    public ResponseEntity findByStatus(@RequestParam(name = "status") String[] statuses) {
        Set<PetStatus> statusSet = new TreeSet<>();
        for (String status : statuses) {
            statusSet.add(PetStatus.valueOf(status));
        }
        return ResponseEntity.ok(PET_SERVICE.findByStatus(statusSet));
    }

    @GetMapping("{id}")
    public ResponseEntity getPet(@PathVariable Long id) {
        Optional<Pet> optionalPet = PET_SERVICE.getPet(id);
        return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                : ResponseEntity.status(404).body("No pet found with id " + id);
    }

    @PostMapping("{id}")
    public ResponseEntity updatePet(@PathVariable Long id, @RequestParam(name = "name") String name) {
        try {
            Optional<Pet> optionalPet = this.PET_SERVICE.update(id, name);
            return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                    : ResponseEntity.status(404).body("Error: not found");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(405).body(e.getMessage());
        }
    }

    @PostMapping("{id}")
    public ResponseEntity updatePet(@PathVariable Long id, @RequestParam(name = "status") PetStatus status) {
        try {
            Optional<Pet> optionalPet = this.PET_SERVICE.update(id, status);
            return (optionalPet.isPresent()) ? ResponseEntity.ok(optionalPet.get())
                    : ResponseEntity.status(404).body("Error: not found");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(405).body(e.getMessage());
        }
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
