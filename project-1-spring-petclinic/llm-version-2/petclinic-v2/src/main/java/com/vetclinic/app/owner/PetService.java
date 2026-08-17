package com.vetclinic.app.owner;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business/service layer for Pet-related use cases: registering a new pet
 * for an owner, updating an existing pet, and enforcing the "pet name must
 * be unique per owner" rule. Introduced in Version 2 to remove business
 * logic (duplicate-name checking and owner/pet collection management) that
 * was previously implemented directly inside {@link PetController}.
 */
@Service
public class PetService {

    private final OwnerService ownerService;
    private final PetTypeRepository petTypes;

    public PetService(OwnerService ownerService, PetTypeRepository petTypes) {
        this.ownerService = ownerService;
        this.petTypes = petTypes;
    }

    public Owner findOwnerOrThrow(Integer ownerId) {
        return ownerService.findByIdOrThrow(ownerId);
    }

    public Pet findPetOrThrow(Owner owner, Integer petId) {
        return owner.getPets().stream()
                .filter(pet -> pet.getId().equals(petId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + petId));
    }

    public List<PetType> findAvailablePetTypes() {
        return petTypes.findAllByOrderByNameAsc();
    }

    /**
     * Domain rule: an owner may not have two pets with the same name.
     * Previously this check lived inline inside the controller.
     */
    public boolean isDuplicateName(Owner owner, Pet pet) {
        return pet.getName() != null && owner.getPet(pet.getName()) != null;
    }

    public void registerNewPet(Owner owner, Pet pet) {
        owner.addPet(pet);
        ownerService.save(owner);
    }

    /**
     * Replaces the pet with id {@code petId} inside the owner's pet
     * collection with the updated {@code pet}, then persists the owner
     * aggregate. This aggregate-management logic previously lived inside
     * PetController.processUpdateForm.
     */
    public void updateExistingPet(Owner owner, Pet pet, Integer petId) {
        pet.setId(petId);
        pet.setOwner(owner);
        owner.getPets().removeIf(existing -> existing.getId() != null && existing.getId().equals(petId));
        owner.addPet(pet);
        ownerService.save(owner);
    }
}
