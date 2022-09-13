package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Places;
import com.second.secondPrakt.models.Storage;
import com.second.secondPrakt.posts.PlacesRepository;
import com.second.secondPrakt.posts.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OneToManyAndManyToOne {

    @Autowired
    public PlacesRepository placesRepository;
    @Autowired
    public StorageRepository storageRepository;

    @GetMapping("/storage")
    public String Main(Model model){
        Iterable<Places> address = placesRepository.findAll();
        model.addAttribute("places",address);
        return "LastConnect";
    }

    @PostMapping("/last/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String street, Model model)
    {
        Places adress = placesRepository.findByStreet(street);
        Storage person = new Storage(name, adress);
        storageRepository.save(person);
        return "redirect:/storage";
    }
}
