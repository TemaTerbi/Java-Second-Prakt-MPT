package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Posts;
import com.second.secondPrakt.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public  String read(@PathVariable("id") Long id, Model model)
    {
        ArrayList<Posts> arrayList = new ArrayList<>();
        Optional<Posts> posts = postsRepository.findById(id);
        posts.ifPresent(arrayList::add);
        model.addAttribute("posts", arrayList);
        return "Posts/info-posts";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Long id, Model model)
    {
        postsRepository.deleteById(id);
        return "redirect:/posts/";
    }

    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable("id") Long id, Model model)
    {
        if (!postsRepository.existsById(id))
        {
            return "redirect:/posts/";
        }
        ArrayList<Posts> arrayList = new ArrayList<>();
        Optional<Posts> posts = postsRepository.findById(id);
        posts.ifPresent(arrayList::add);
        model.addAttribute("posts", arrayList);
        return "Posts/edit-posts";
    }

    @PostMapping("/edit/{id}")
    public  String edit_post(@PathVariable("id") Long id, Model model,
    @RequestParam("title") String title,
    @RequestParam("phone") String phone,
    @RequestParam("description") String description,
    @RequestParam("place") String place,
    @RequestParam("views") Integer views)
    {
        Posts posts = postsRepository.findById(id).orElseThrow();

        posts.setTitle(title);
        posts.setPhone(phone);
        posts.setDescription(description);
        posts.setPlace(place);
        posts.setViews(views);
        postsRepository.save(posts);
        return "redirect:/posts/";
    }
}
