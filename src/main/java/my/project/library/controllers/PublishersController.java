package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.Publisher;
import my.project.library.services.PublishersService;
import my.project.library.utill.validators.PublisherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublishersController {

    private final PublishersService publishersService;
    private final PublisherValidator publisherValidator;

    @Autowired
    public PublishersController(PublishersService publishersService, PublisherValidator publisherValidator) {
        this.publishersService = publishersService;
        this.publisherValidator = publisherValidator;
    }

    @GetMapping()
    public String getBooks(Model model){
        return "publishers/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        return "publishers/show";
    }

    @GetMapping("/new")
    public String newPublisher(Model model){
        model.addAttribute("publisher", new Publisher());
        return "publishers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult bindingResult){
        publisherValidator.validate(publisher, bindingResult);
        if(bindingResult.hasErrors())
            return "publishers/new";
        //publishersService.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        return "publishers/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult bindingResult, @PathVariable("id") long id){
        publisherValidator.validate(publisher, bindingResult);
        if(bindingResult.hasErrors())
            return "publishers/edit";

//        publishersService.update(id, publisher);
        return "redirect:/publishers/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
//        publishersService.delete(id);
        return "redirect:/publishers";
    }
}
