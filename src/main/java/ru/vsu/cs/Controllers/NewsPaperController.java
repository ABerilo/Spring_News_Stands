package ru.vsu.cs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.Models.NewsPaper;
import ru.vsu.cs.Servecies.Manager;

@Controller
@RequestMapping("/newspaper")
public class NewsPaperController {
    private final Manager manager;

    @Autowired
    public NewsPaperController(Manager manager) {
        this.manager = manager;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("newspapers", manager.getNewsPapers());
        return "products/newspaper/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        NewsPaper np = (NewsPaper) manager.getPaper(id);
        model.addAttribute("newspaper", np);
        return "products/newspaper/show";
    }

    @GetMapping("/new")
    public String newNewsPaper(@ModelAttribute("newspaper") NewsPaper newsPaper) {
        return "products/newspaper/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("newspaper") NewsPaper newsPaper){
        manager.addNewPaper(newsPaper);
        return "redirect:/newspaper";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        NewsPaper np = (NewsPaper) manager.getPaper(id);
        model.addAttribute("newspaper", np);
        return "products/newspaper/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("newspaper") NewsPaper newsPaper) {
        manager.editPaper(newsPaper);
        return "redirect:/newspaper";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        manager.removePaper(id);
        return "redirect:/newspaper";
    }

}
