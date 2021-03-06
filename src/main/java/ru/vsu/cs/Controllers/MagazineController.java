package ru.vsu.cs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.Models.Magazine;
import ru.vsu.cs.Models.Paper;
import ru.vsu.cs.Servecies.Manager;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/magazine")
public class MagazineController {
    private final Manager manager;

    @Autowired
    public MagazineController(Manager manager) {
        this.manager = manager;
    }

    @GetMapping()
    public List<Magazine> showMagazine() {
        return manager.getMagazines();
    }

    @GetMapping("/{id}")
    public Paper show(@PathVariable("id") int id) {
        return manager.getPaper(id);
    }

    @PostMapping()
    public int createMagazine(@RequestBody Magazine magazine) {
        return manager.addNewPaper(magazine);
    }

    @PutMapping("/{id}")
    public void updateMagazine(@PathVariable("id") int id, @RequestBody Magazine magazine) {
        magazine.setId(id);
        manager.editPaper(magazine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        manager.removePaper(id);
    }

//    @GetMapping()
//    public String showMagazine(Model model) {
//        model.addAttribute("magazines", manager.getMagazines());
//        return "products/magazine/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        Magazine m = (Magazine) manager.getPaper(id);
//        model.addAttribute("magazine", m);
//        return "products/magazine/show";
//    }
//
//    @GetMapping("/new")
//    public String newMagazine(@ModelAttribute("magazine") Magazine magazine) {
//        return "products/magazine/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("magazine") Magazine magazine){
//        manager.addNewPaper(magazine);
//        return "redirect:/magazine";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        Magazine m = (Magazine) manager.getPaper(id);
//        model.addAttribute("magazine", m);
//        return "products/magazine/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("magazine") Magazine magazine) {
//        manager.editPaper(magazine);
//        return "redirect:/magazine";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        manager.removePaper(id);
//        return "redirect:/magazine";
//    }
}
