package ru.vsu.cs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.Models.Book;
import ru.vsu.cs.Models.Paper;
import ru.vsu.cs.Servecies.Manager;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/book")
public class BookController {
    private final Manager manager;

    @Autowired
    public BookController(Manager manager) {
        this.manager = manager;
    }

    @GetMapping()
    public List<Book> showBook() {
        return manager.getBooks();
    }

    @GetMapping("/{id}")
    public Paper show(@PathVariable("id") int id) {
        return manager.getPaper(id);
    }

    @PostMapping()
    public int createBook(@RequestBody Book book) {
        return manager.addNewPaper(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        book.setId(id);
        manager.editPaper(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        manager.removePaper(id);
    }

//    @GetMapping()
//    public String showBook(Model model) {
//        model.addAttribute("books", manager.getBooks());
//        return "products/book/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        Book b = (Book)manager.getPaper(id);
//        model.addAttribute("book", b);
//        return "products/book/show";
//    }
//
//    @GetMapping("/new")
//    public String newBook(@ModelAttribute("book") Book book) {
//        return "products/book/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("book") Book book){
//        manager.addNewPaper(book);
//        return "redirect:/book";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        Book b = (Book)manager.getPaper(id);
//        model.addAttribute("book", b);
//        return "products/book/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("book") Book book) {
//        manager.editPaper(book);
//        return "redirect:/book";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        manager.removePaper(id);
//        return "redirect:/book";
//    }
}
