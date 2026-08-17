package com.vetclinic.app.owner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for registering and updating pets that belong to a
 * specific owner.
 */
@Controller
public class PetController {

    private final OwnerRepository owners;
    private final PetTypeRepository petTypes;

    public PetController(OwnerRepository owners, PetTypeRepository petTypes) {
        this.owners = owners;
        this.petTypes = petTypes;
    }

    private Owner findOwner(Integer ownerId) {
        return owners.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId));
    }

    @GetMapping("/owners/{ownerId}/pets/new")
    public String initCreationForm(@PathVariable Integer ownerId, Model model) {
        Owner owner = findOwner(ownerId);
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        model.addAttribute("types", petTypes.findAllByOrderByNameAsc());
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/owners/{ownerId}/pets/new")
    public String processCreationForm(@PathVariable Integer ownerId, @Valid Pet pet,
                                       BindingResult result, Model model) {
        Owner owner = findOwner(ownerId);

        if (pet.getName() != null && owner.getPet(pet.getName()) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            model.addAttribute("types", petTypes.findAllByOrderByNameAsc());
            return "pets/createOrUpdatePetForm";
        }

        owner.addPet(pet);
        owners.save(owner);
        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Integer ownerId, @PathVariable Integer petId, Model model) {
        Owner owner = findOwner(ownerId);
        Pet pet = owner.getPets().stream()
                .filter(p -> p.getId().equals(petId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        model.addAttribute("types", petTypes.findAllByOrderByNameAsc());
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/edit")
    public String processUpdateForm(@PathVariable Integer ownerId, @PathVariable Integer petId,
                                     @Valid Pet pet, BindingResult result, Model model) {
        Owner owner = findOwner(ownerId);

        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            model.addAttribute("types", petTypes.findAllByOrderByNameAsc());
            return "pets/createOrUpdatePetForm";
        }

        pet.setId(petId);
        pet.setOwner(owner);
        owner.getPets().removeIf(p -> p.getId() != null && p.getId().equals(petId));
        owner.addPet(pet);
        owners.save(owner);
        return "redirect:/owners/" + ownerId;
    }
}
