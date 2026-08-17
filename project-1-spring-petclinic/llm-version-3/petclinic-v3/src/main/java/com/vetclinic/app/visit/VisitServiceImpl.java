package com.vetclinic.app.visit;

import com.vetclinic.app.owner.Owner;
import com.vetclinic.app.owner.OwnerService;
import com.vetclinic.app.owner.Pet;
import com.vetclinic.app.owner.PetRepository;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link VisitService}.
 *
 * Version 3 change: renamed from {@code VisitService} (Version 2), and
 * now depends on the {@link OwnerService} abstraction instead of the
 * concrete {@code OwnerService} class that Version 2 depended on.
 * Behavior is unchanged from Version 2.
 */
@Service
public class VisitServiceImpl implements VisitService {

    private final PetRepository pets;
    private final OwnerService ownerService;
    private final VisitRepository visits;

    public VisitServiceImpl(PetRepository pets, OwnerService ownerService, VisitRepository visits) {
        this.pets = pets;
        this.ownerService = ownerService;
        this.visits = visits;
    }

    @Override
    public Owner findOwnerOrThrow(Integer ownerId) {
        return ownerService.findByIdOrThrow(ownerId);
    }

    @Override
    public Pet findPetOrThrow(Integer petId) {
        return pets.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
    }

    @Override
    public Visit recordVisit(Pet pet, Visit visit) {
        visit.setPet(pet);
        return visits.save(visit);
    }
}
