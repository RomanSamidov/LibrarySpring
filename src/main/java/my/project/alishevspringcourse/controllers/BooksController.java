package my.project.alishevspringcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {

    @GetMapping("/books")
    public String getBooks(){
        return "books";
    }
}
