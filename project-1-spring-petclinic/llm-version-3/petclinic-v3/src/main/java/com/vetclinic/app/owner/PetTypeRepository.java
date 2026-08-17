package com.vetclinic.app.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for PetType lookup data, used to populate pet-registration
 * forms with the available categories of pet.
 */
public interface PetTypeRepository extends JpaRepository<PetType, Integer> {

    List<PetType> findAllByOrderByNameAsc();
}
