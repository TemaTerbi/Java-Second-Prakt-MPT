package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Actor;
import com.second.secondPrakt.models.Theater;
import com.second.secondPrakt.posts.ActorRepository;
import com.second.secondPrakt.posts.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManyToMany {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    @GetMapping("/actor")
    private String Main(Model model){
        Iterable<Actor> actors = actorRepository.findAll();
        model.addAttribute("actor", actors);
        Iterable<Theater> theaters = theaterRepository.findAll();
        model.addAttribute("theater", theaters);

        return "ManyToMany";
    }

    @PostMapping("/many/add")
    public String blogPostAdd(@RequestParam String student, @RequestParam String universiti, Model model)
    {
        Actor actor = actorRepository.findByName(student);
        Theater theater = theaterRepository.findByNumber(universiti);
        actor.getTheaterList().add(theater);
        theater.getActorList().add(actor);
        actorRepository.save(actor);
        theaterRepository.save(theater);
        return "redirect:/actor";
    }
}
