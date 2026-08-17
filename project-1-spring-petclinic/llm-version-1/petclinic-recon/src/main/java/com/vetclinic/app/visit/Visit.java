package com.vetclinic.app.visit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vetclinic.app.model.BaseEntity;
import com.vetclinic.app.owner.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

/**
 * Represents a single veterinary visit / appointment recorded for a Pet.
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visit_date")
    private LocalDate visitDate = LocalDate.now();

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
