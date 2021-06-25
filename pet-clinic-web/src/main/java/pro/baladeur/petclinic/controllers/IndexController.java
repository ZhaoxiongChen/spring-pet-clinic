package pro.baladeur.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        // Return the name of template to be accessed
        return "index";
    }

    @RequestMapping("/oups")
    public String oups() {
        return "notImplemented";
    }
}
