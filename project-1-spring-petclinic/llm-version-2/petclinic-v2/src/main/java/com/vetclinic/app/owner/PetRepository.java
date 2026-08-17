package com.vetclinic.app.owner;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for direct Pet lookups, used when recording a visit for a
 * pet without needing to load the full owner aggregate separately.
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
