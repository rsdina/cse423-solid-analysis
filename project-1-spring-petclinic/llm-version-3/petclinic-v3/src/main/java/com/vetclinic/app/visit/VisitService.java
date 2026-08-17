package com.vetclinic.app.visit;

import com.vetclinic.app.owner.Owner;
import com.vetclinic.app.owner.Pet;

/**
 * Abstraction for recording veterinary visits.
 *
 * Version 3 change: this was a concrete class in Version 2. It is now an
 * interface so that {@link VisitController} depends on an abstraction
 * rather than on {@link VisitServiceImpl} directly. The single
 * implementation is {@link VisitServiceImpl}.
 */
public interface VisitService {

    Owner findOwnerOrThrow(Integer ownerId);

    Pet findPetOrThrow(Integer petId);

    Visit recordVisit(Pet pet, Visit visit);
}
