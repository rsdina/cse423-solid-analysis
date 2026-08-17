package com.vetclinic.app.owner;

import java.util.List;

/**
 * Abstraction for Pet-related use cases: registering a new pet for an
 * owner, updating an existing pet, and enforcing the "pet name must be
 * unique per owner" rule.
 *
 * Version 3 change: this was a concrete class in Version 2. It is now an
 * interface so that {@link PetController} depends on an abstraction
 * rather than on {@link PetServiceImpl} directly. The single
 * implementation is {@link PetServiceImpl}.
 */
public interface PetService {

    Owner findOwnerOrThrow(Integer ownerId);

    Pet findPetOrThrow(Owner owner, Integer petId);

    List<PetType> findAvailablePetTypes();

    /**
     * Domain rule: an owner may not have two pets with the same name.
     */
    boolean isDuplicateName(Owner owner, Pet pet);

    void registerNewPet(Owner owner, Pet pet);

    void updateExistingPet(Owner owner, Pet pet, Integer petId);
}
