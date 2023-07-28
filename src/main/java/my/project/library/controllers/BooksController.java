//package my.project.library.controllers;
//
//import jakarta.validation.Valid;
//import my.project.library.models.Book;
//import my.project.library.services.BooksService;
//import my.project.library.utill.validators.BookValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
////@Controller
//@RequestMapping("/books")
//public class BooksController {
//
//    private final BooksService booksService;
//
//    private final BookValidator bookValidator;
//
////    @Autowired
//    public BooksController(BooksService booksService, BookValidator bookValidator) {
//        this.booksService = booksService;
//        this.bookValidator = bookValidator;
//    }
//
//    @GetMapping()
//    public String getBooks(Model model){
//        return "books/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") long id, Model model){
//        return "books/show";
//    }
//
//    @GetMapping("/new")
//    public String newBook (Model model) {
//        model.addAttribute("book", new Book());
//        return "books/new";
//    }
//
//    @PostMapping
//    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
//        bookValidator.validate(book, bindingResult);
//        if(bindingResult.hasErrors())
//            return "books/new";
////        booksService.save(book);
//        return "redirect:/books";
//    }
//
//
//    @GetMapping("/{id}/edit")
//    public String edit(@RequestParam("id") long id, Model model){
//        return "books/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("book") @Valid Book book, @PathVariable("id") long id, BindingResult bindingResult) {
//        bookValidator.validate(book, bindingResult);
//        if(bindingResult.hasErrors())
//            return "books/edit";
//
//        return "redirect:/books/" + id;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@RequestParam("id") long id){
//        return "redirect:/books";
//    }
//}
