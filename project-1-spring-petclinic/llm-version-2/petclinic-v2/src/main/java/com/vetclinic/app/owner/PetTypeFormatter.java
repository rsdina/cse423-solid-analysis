package com.vetclinic.app.owner;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Converts between the PetType entity and the string identifier used in
 * HTML select form fields, so that pet-registration forms can bind
 * directly to a PetType.
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeRepository petTypes;

    public PetTypeFormatter(PetTypeRepository petTypes) {
        this.petTypes = petTypes;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getId() == null ? "" : petType.getId().toString();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        List<PetType> all = petTypes.findAllByOrderByNameAsc();
        for (PetType type : all) {
            if (type.getId().toString().equals(text) || type.getName().equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new ParseException("PetType not found: " + text, 0);
    }
}
