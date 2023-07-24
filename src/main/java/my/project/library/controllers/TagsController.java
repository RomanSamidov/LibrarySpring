package my.project.library.controllers;

import jakarta.validation.Valid;
import my.project.library.models.Tag;
import my.project.library.services.TagsService;
import my.project.library.utill.validators.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tags")
public class TagsController {

    private final TagsService tagsService;
    private final TagValidator tagValidator;

    @Autowired
    public TagsController(TagsService tagsService, TagValidator tagValidator) {
        this.tagsService = tagsService;
        this.tagValidator = tagValidator;
    }

    @GetMapping()
    public String getBooks(Model model){
        return "tags/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        return "tags/show";
    }

    @GetMapping("/new")
    public String newTag(Model model){
        model.addAttribute("tag", new Tag());
        return "tags/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("tag") @Valid Tag tag, BindingResult bindingResult){
        tagValidator.validate(tag, bindingResult);
        if(bindingResult.hasErrors())
            return "tags/new";
        //tagsService.save(tag);
        return "redirect:/tags";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        return "tags/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("tag") @Valid Tag tag, BindingResult bindingResult, @PathVariable("id") long id){
        tagValidator.validate(tag, bindingResult);
        if(bindingResult.hasErrors())
            return "tags/edit";

//        tagsService.update(id, tag);
        return "redirect:/tags/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
//        tagsService.delete(id);
        return "redirect:/tags";
    }
}
