package com.vetclinic.app.owner;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default implementation of {@link PetService}.
 *
 * Version 3 change: renamed from {@code PetService} (Version 2), and now
 * depends on the {@link OwnerService} abstraction instead of the concrete
 * {@code OwnerService} class that Version 2 depended on. Behavior is
 * unchanged from Version 2.
 */
@Service
public class PetServiceImpl implements PetService {

    private final OwnerService ownerService;
    private final PetTypeRepository petTypes;

    public PetServiceImpl(OwnerService ownerService, PetTypeRepository petTypes) {
        this.ownerService = ownerService;
        this.petTypes = petTypes;
    }

    @Override
    public Owner findOwnerOrThrow(Integer ownerId) {
        return ownerService.findByIdOrThrow(ownerId);
    }

    @Override
    public Pet findPetOrThrow(Owner owner, Integer petId) {
        return owner.getPets().stream()
                .filter(pet -> pet.getId().equals(petId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
    }

    @Override
    public List<PetType> findAvailablePetTypes() {
        return petTypes.findAllByOrderByNameAsc();
    }

    @Override
    public boolean isDuplicateName(Owner owner, Pet pet) {
        return pet.getName() != null && owner.getPet(pet.getName()) != null;
    }

    @Override
    public void registerNewPet(Owner owner, Pet pet) {
        owner.addPet(pet);
        ownerService.save(owner);
    }

    @Override
    public void updateExistingPet(Owner owner, Pet pet, Integer petId) {
        pet.setId(petId);
        pet.setOwner(owner);
        owner.getPets().removeIf(existing -> existing.getId() != null && existing.getId().equals(petId));
        owner.addPet(pet);
        ownerService.save(owner);
    }
}
