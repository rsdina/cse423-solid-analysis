package com.vetclinic.app.visit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository / data-access layer for Visit entities.
 */
public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
