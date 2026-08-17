package com.vetclinic.app.owner;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default implementation of {@link OwnerService}, backed by
 * {@link OwnerRepository}.
 *
 * Version 3 change: renamed from {@code OwnerService} (Version 2) to
 * separate the abstraction ({@link OwnerService}) from its implementation.
 * Behavior is unchanged from Version 2.
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository owners;

    public OwnerServiceImpl(OwnerRepository owners) {
        this.owners = owners;
    }

    @Override
    public Owner findByIdOrThrow(Integer ownerId) {
        return owners.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId));
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return owners.findByLastNameStartingWithIgnoreCase(lastName);
    }

    @Override
    public Owner save(Owner owner) {
        return owners.save(owner);
    }
}
