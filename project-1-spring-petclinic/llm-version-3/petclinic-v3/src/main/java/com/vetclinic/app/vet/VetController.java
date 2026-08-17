package com.vetclinic.app.vet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Handles HTTP requests related to viewing veterinarians and their
 * specialties. Handles only vet-related requests.
 */
@Controller
public class VetController {

    private final VetRepository vets;

    public VetController(VetRepository vets) {
        this.vets = vets;
    }

    @GetMapping("/vets")
    public String showVetList(Model model) {
        List<Vet> vetList = vets.findAllByOrderByLastNameAsc();
        model.addAttribute("vets", vetList);
        return "vets/vetList";
    }
}
