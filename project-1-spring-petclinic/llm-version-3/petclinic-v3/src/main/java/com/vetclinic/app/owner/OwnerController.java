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
 * viewing and searching for owners. Delegates all business/persistence
 * logic to {@link OwnerService}.
 *
 * Version 2 change: this controller previously talked to
 * {@link OwnerRepository} directly and re-implemented the "owner not
 * found" lookup logic itself. It now depends on OwnerService instead,
 * keeping the controller focused on request/response coordination.
 */
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
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
        ownerService.save(owner);
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/owners/find")
    public String initFindForm() {
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(@RequestParam(required = false, defaultValue = "") String lastName,
                                   Model model) {
        List<Owner> results = ownerService.findByLastName(lastName);

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
        model.addAttribute("owner", ownerService.findByIdOrThrow(ownerId));
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
        ownerService.save(owner);
        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("/owners/{ownerId}")
    public String showOwner(@PathVariable Integer ownerId, Model model) {
        model.addAttribute("owner", ownerService.findByIdOrThrow(ownerId));
        return "owners/ownerDetails";
    }
}
