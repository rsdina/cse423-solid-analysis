package com.vetclinic.app.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Serves the application landing page.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "welcome";
    }
}
