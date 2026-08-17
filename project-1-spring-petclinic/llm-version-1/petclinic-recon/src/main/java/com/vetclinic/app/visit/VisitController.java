package com.vetclinic.app.visit;

import com.vetclinic.app.owner.Owner;
import com.vetclinic.app.owner.OwnerRepository;
import com.vetclinic.app.owner.Pet;
import com.vetclinic.app.owner.PetRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for recording a veterinary visit against a specific
 * pet, and for displaying visit history.
 */
@Controller
public class VisitController {

    private final PetRepository pets;
    private final OwnerRepository owners;
    private final VisitRepository visits;

    public VisitController(PetRepository pets, OwnerRepository owners, VisitRepository visits) {
        this.pets = pets;
        this.owners = owners;
        this.visits = visits;
    }

    private Pet findPet(Integer petId) {
        return pets.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Integer ownerId, @PathVariable Integer petId, Model model) {
        Owner owner = owners.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId));
        Pet pet = findPet(petId);
        Visit visit = new Visit();
        pet.addVisit(visit);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        model.addAttribute("visit", visit);
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@PathVariable Integer ownerId, @PathVariable Integer petId,
                                       @Valid Visit visit, BindingResult result, Model model) {
        Pet pet = findPet(petId);

        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            model.addAttribute("visit", visit);
            return "pets/createOrUpdateVisitForm";
        }

        visit.setPet(pet);
        visits.save(visit);
        return "redirect:/owners/" + ownerId;
    }
}
