package com.vetclinic.app.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository / data-access layer for Owner entities. Provides the
 * persistence operations needed by the owner and pet workflows, including
 * lookup by last name for the search feature.
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    List<Owner> findByLastNameStartingWithIgnoreCase(String lastName);
}
