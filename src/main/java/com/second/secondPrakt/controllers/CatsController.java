package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Cats;
import com.second.secondPrakt.models.Posts;
import com.second.secondPrakt.posts.CatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cats")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CatsController {
    @Autowired
    private CatsRepository catsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Cats> cats = catsRepository.findAll();
        model.addAttribute("cats", cats);
        return "Cats/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("cats", new Cats());
        return "Cats/add";
    }

//    @PostMapping("/add")
//    public String addPost(@RequestParam("breed") String breed,
//                          @RequestParam("color") String color,
//                          @RequestParam("colorOfEys") String colorOfEys,
//                          @RequestParam("weight") Double weight,
//                          @RequestParam("height") Double height,
//                          Model model)
//    {
//        Cats catsOne = new Cats(breed, color, colorOfEys, weight, height);
//        catsRepository.save(catsOne);
//        return "redirect:/cats/";
//    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("cats") @Valid Cats posts,
                          BindingResult bindingResult,
                          Model model)
    {
        if(bindingResult.hasFieldErrors())
            return  "Cats/add";

        catsRepository.save(posts);
        return "redirect:/cats/";
    }

    @GetMapping("/search")
    public  String getSearchElement(@RequestParam("title") String title, Model model)
    {
        List<Cats> catsList = catsRepository.findByBreedContains(title);
        model.addAttribute("cats", catsList);
        return "Cats/index";
    }

    @GetMapping("/{id}")
    public  String read(@PathVariable("id") Long id, Model model)
    {
        ArrayList<Cats> arrayList = new ArrayList<>();
        Optional<Cats> posts = catsRepository.findById(id);
        posts.ifPresent(arrayList::add);
        model.addAttribute("cats", arrayList);
        return "Cats/info-cats";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Long id, Model model)
    {
        catsRepository.deleteById(id);
        return "redirect:/cats/";
    }

    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable("id") Long id, Model model)
    {
        if (!catsRepository.existsById(id))
        {
            return "redirect:/cats/";
        }
        ArrayList<Cats> arrayList = new ArrayList<>();
        Optional<Cats> posts = catsRepository.findById(id);
        posts.ifPresent(arrayList::add);
        model.addAttribute("cats", arrayList.get(0));
        return "/Cats/edit-cats";
    }

//    @PostMapping("/edit/{id}")
//    public  String edit_post(@PathVariable("id") Long id, Model model,
//                             @RequestParam("breed") String breed,
//                             @RequestParam("color") String color,
//                             @RequestParam("colorOfEys") String colorOfEys,
//                             @RequestParam("weight") Double weight,
//                             @RequestParam("height") Double height)
//    {
//        Cats cats = catsRepository.findById(id).orElseThrow();
//
//        cats.setBreed(breed);
//        cats.setColor(color);
//        cats.setColorOfEys(colorOfEys);
//        cats.setWeight(weight);
//        cats.setHeight(height);
//        catsRepository.save(cats);
//        return "redirect:/cats/";
//    }

    @PostMapping("/edit/{id}")
    public  String edit_post(@PathVariable("id") Long id, Model model,
                             @ModelAttribute("cats") @Valid Cats cats,
                             BindingResult bindingResul
                             )
    {
        if(!catsRepository.existsById(id))
        {
            return "redirect:/cats/";
        }
        if(bindingResul.hasErrors())
        {
            return "/Cats/edit-cats";
        }

        cats.setId(id);
        catsRepository.save(cats);
        return "redirect:/cats/";
    }
}
