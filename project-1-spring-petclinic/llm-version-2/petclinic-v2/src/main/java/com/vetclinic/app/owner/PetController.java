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
 * specific owner. Delegates lookups, duplicate-name validation and
 * owner/pet aggregate updates to {@link PetService}.
 *
 * Version 2 change: this controller previously performed the duplicate
 * pet-name check and the owner/pet collection replacement logic itself.
 * That business logic has moved into PetService; the controller now only
 * coordinates the HTTP request/response and form binding.
 */
@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/owners/{ownerId}/pets/new")
    public String initCreationForm(@PathVariable Integer ownerId, Model model) {
        Owner owner = petService.findOwnerOrThrow(ownerId);
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        model.addAttribute("types", petService.findAvailablePetTypes());
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/owners/{ownerId}/pets/new")
    public String processCreationForm(@PathVariable Integer ownerId, @Valid Pet pet,
                                       BindingResult result, Model model) {
        Owner owner = petService.findOwnerOrThrow(ownerId);

        if (petService.isDuplicateName(owner, pet)) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            model.addAttribute("types", petService.findAvailablePetTypes());
            return "pets/createOrUpdatePetForm";
        }

        petService.registerNewPet(owner, pet);
        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Integer ownerId, @PathVariable Integer petId, Model model) {
        Owner owner = petService.findOwnerOrThrow(ownerId);
        Pet pet = petService.findPetOrThrow(owner, petId);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        model.addAttribute("types", petService.findAvailablePetTypes());
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/edit")
    public String processUpdateForm(@PathVariable Integer ownerId, @PathVariable Integer petId,
                                     @Valid Pet pet, BindingResult result, Model model) {
        Owner owner = petService.findOwnerOrThrow(ownerId);

        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            model.addAttribute("types", petService.findAvailablePetTypes());
            return "pets/createOrUpdatePetForm";
        }

        petService.updateExistingPet(owner, pet, petId);
        return "redirect:/owners/" + ownerId;
    }
}
