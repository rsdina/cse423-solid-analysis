package com.vetclinic.app.visit;

import com.vetclinic.app.owner.Owner;
import com.vetclinic.app.owner.Pet;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for recording a veterinary visit against a specific
 * pet, and for displaying the visit form. Delegates lookups and
 * persistence to {@link VisitService}.
 *
 * Version 2 change: this controller previously depended directly on
 * {@link com.vetclinic.app.owner.PetRepository}, {@link
 * com.vetclinic.app.owner.OwnerRepository} and {@link VisitRepository}
 * and re-implemented the same "not found" lookup pattern used elsewhere.
 * It now depends only on VisitService.
 */
@Controller
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Integer ownerId, @PathVariable Integer petId, Model model) {
        Owner owner = visitService.findOwnerOrThrow(ownerId);
        Pet pet = visitService.findPetOrThrow(petId);
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
        Pet pet = visitService.findPetOrThrow(petId);

        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            model.addAttribute("visit", visit);
            return "pets/createOrUpdateVisitForm";
        }

        visitService.recordVisit(pet, visit);
        return "redirect:/owners/" + ownerId;
    }
}
