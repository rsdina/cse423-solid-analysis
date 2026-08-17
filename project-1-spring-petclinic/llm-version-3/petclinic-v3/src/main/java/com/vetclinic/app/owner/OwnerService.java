package com.vetclinic.app.owner;

import java.util.List;

/**
 * Abstraction for Owner-related use cases: creating, updating, looking up
 * and searching for owners.
 *
 * Version 3 change: this was a concrete class in Version 2. It is now an
 * interface so that {@link OwnerController}, {@link PetService} and
 * {@link com.vetclinic.app.visit.VisitService} depend on an abstraction
 * rather than on {@link OwnerServiceImpl} directly (Dependency Inversion
 * Principle). The single implementation is {@link OwnerServiceImpl}.
 */
public interface OwnerService {

    /**
     * Finds an owner by id or throws if none exists.
     */
    Owner findByIdOrThrow(Integer ownerId);

    List<Owner> findByLastName(String lastName);

    Owner save(Owner owner);
}
