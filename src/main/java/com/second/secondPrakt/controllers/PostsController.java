package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Posts;
import com.second.secondPrakt.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Posts> posts = postsRepository.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "Posts/add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam("title") String title,
                          @RequestParam("phone") String phone,
                          @RequestParam("description") String description,
                          @RequestParam("place") String place,
                          @RequestParam("views") Integer views,
                          Model model)
    {
        Posts postOne = new Posts(title, phone, description, place, views);
        postsRepository.save(postOne);
        return "redirect:/posts/";
    }

    @GetMapping("/search")
    public  String getSearchElement(@RequestParam("title") String title, Model model)
    {
        List<Posts> postsList = postsRepository.findByTitleContains(title);
        model.addAttribute("posts", postsList);
        return "Posts/index";
    }
}
