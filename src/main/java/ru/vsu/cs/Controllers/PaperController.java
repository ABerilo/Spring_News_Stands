package ru.vsu.cs.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PaperController {

    @GetMapping()
    public String index() {
        return "products/index";
    }
}

