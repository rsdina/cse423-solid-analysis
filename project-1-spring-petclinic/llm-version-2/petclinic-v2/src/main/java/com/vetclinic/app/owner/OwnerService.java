package com.vetclinic.app.owner;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business/service layer for Owner-related use cases: creating, updating,
 * looking up and searching for owners. Introduced in Version 2 so that
 * {@link OwnerController} (and other controllers that need an Owner, such
 * as {@link com.vetclinic.app.visit.VisitController}) no longer duplicate
 * lookup logic or talk to {@link OwnerRepository} directly.
 */
@Service
public class OwnerService {

    private final OwnerRepository owners;

    public OwnerService(OwnerRepository owners) {
        this.owners = owners;
    }

    /**
     * Finds an owner by id or throws if none exists. Centralizes the
     * "owner not found" rule that was previously re-implemented separately
     * in OwnerController and PetController.
     */
    public Owner findByIdOrThrow(Integer ownerId) {
        return owners.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId));
    }

    public List<Owner> findByLastName(String lastName) {
        return owners.findByLastNameStartingWithIgnoreCase(lastName);
    }

    public Owner save(Owner owner) {
        return owners.save(owner);
    }
}
