package com.vetclinic.app.owner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Handles HTTP requests related to owner management: creating, updating,
 * viewing and searching for owners. Delegates all persistence work to
 * {@link OwnerRepository}.
 */
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerRepository owners;

    public OwnerController(OwnerRepository owners) {
        this.owners = owners;
    }

    @GetMapping("/owners/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        owners.save(owner);
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/owners/find")
    public String initFindForm() {
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(@RequestParam(required = false, defaultValue = "") String lastName,
                                   Model model) {
        List<Owner> results = owners.findByLastNameStartingWithIgnoreCase(lastName);

        if (results.isEmpty()) {
            model.addAttribute("message", "No owners found");
            return "owners/findOwners";
        }

        if (results.size() == 1) {
            Owner owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }

        model.addAttribute("owners", results);
        return "owners/ownersList";
    }

    @GetMapping("/owners/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Integer ownerId, Model model) {
        model.addAttribute("owner", findOwnerOrFail(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
                                          @PathVariable Integer ownerId, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("owner", owner);
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        owner.setId(ownerId);
        owners.save(owner);
        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("/owners/{ownerId}")
    public String showOwner(@PathVariable Integer ownerId, Model model) {
        model.addAttribute("owner", findOwnerOrFail(ownerId));
        return "owners/ownerDetails";
    }

    private Owner findOwnerOrFail(Integer ownerId) {
        return owners.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId));
    }
}
