package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Bots;
import com.second.secondPrakt.models.Cats;
import com.second.secondPrakt.models.Factory;
import com.second.secondPrakt.models.Posts;
import com.second.secondPrakt.posts.BotsRepository;
import com.second.secondPrakt.posts.CatsRepository;
import com.second.secondPrakt.posts.FactoryRepository;
import com.second.secondPrakt.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class OneToOneController {

    @Autowired
    private BotsRepository botsRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @GetMapping("/bots")
    public String Main(Model model){
        Iterable<Bots> bots = botsRepository.findAll();
        model.addAttribute("bots", bots);
        return "OneToOneAdd";
    }

    @PostMapping("/one/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String number, Model model)
    {
        Bots bots = botsRepository.findByName(name);
        Factory factory = new Factory(number, bots);
        factoryRepository.save(factory);
        return "redirect:/bots";
    }
}
