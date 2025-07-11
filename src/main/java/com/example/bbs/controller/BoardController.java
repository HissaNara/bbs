package com.example.bbs.controller;

import com.example.bbs.entity.Post;
import com.example.bbs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    @Autowired
    private PostRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", repo.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name, @RequestParam String content) {
        Post p = new Post();
        p.setName(name);
        p.setContent(content);
        repo.save(p);
        return "redirect:/";
    }
}