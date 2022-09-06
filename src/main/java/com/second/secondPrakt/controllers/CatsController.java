package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Cats;
import com.second.secondPrakt.posts.CatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cats")
public class CatsController {
    @Autowired
    private CatsRepository catsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Cats> cats = catsRepository.findAll();
        model.addAttribute("cats", cats);
        return "Posts/Cats/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "Posts/Cats/add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam("breed") String breed,
                          @RequestParam("color") String color,
                          @RequestParam("colorOfEys") String colorOfEys,
                          @RequestParam("weight") Double weight,
                          @RequestParam("height") Double height,
                          Model model)
    {
        Cats catsOne = new Cats(breed, color, colorOfEys, weight, height);
        catsRepository.save(catsOne);
        return "redirect:/cats/";
    }

    @GetMapping("/search")
    public  String getSearchElement(@RequestParam("title") String title, Model model)
    {
        List<Cats> catsList = catsRepository.findByBreedContains(title);
        model.addAttribute("cats", catsList);
        return "Posts/Cats/index";
    }
}
