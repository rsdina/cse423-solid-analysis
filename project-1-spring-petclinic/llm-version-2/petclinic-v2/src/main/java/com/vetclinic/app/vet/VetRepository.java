package com.vetclinic.app.vet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository / data-access layer for Vet entities.
 */
public interface VetRepository extends JpaRepository<Vet, Integer> {

    List<Vet> findAllByOrderByLastNameAsc();
}
