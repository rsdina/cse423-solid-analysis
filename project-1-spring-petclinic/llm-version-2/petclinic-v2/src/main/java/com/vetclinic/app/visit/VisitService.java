package com.vetclinic.app.visit;

import com.vetclinic.app.owner.Owner;
import com.vetclinic.app.owner.OwnerService;
import com.vetclinic.app.owner.Pet;
import com.vetclinic.app.owner.PetRepository;
import org.springframework.stereotype.Service;

/**
 * Business/service layer for recording veterinary visits. Introduced in
 * Version 2 so {@link VisitController} no longer talks to
 * {@link PetRepository} / {@link OwnerService} directly for lookups and
 * persistence, keeping the controller focused on HTTP coordination.
 */
@Service
public class VisitService {

    private final PetRepository pets;
    private final OwnerService ownerService;
    private final VisitRepository visits;

    public VisitService(PetRepository pets, OwnerService ownerService, VisitRepository visits) {
        this.pets = pets;
        this.ownerService = ownerService;
        this.visits = visits;
    }

    public Owner findOwnerOrThrow(Integer ownerId) {
        return ownerService.findByIdOrThrow(ownerId);
    }

    public Pet findPetOrThrow(Integer petId) {
        return pets.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
    }

    public Visit recordVisit(Pet pet, Visit visit) {
        visit.setPet(pet);
        return visits.save(visit);
    }
}
