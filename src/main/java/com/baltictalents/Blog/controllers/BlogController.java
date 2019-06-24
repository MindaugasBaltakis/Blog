package com.baltictalents.Blog.controllers;

import com.baltictalents.Blog.entities.Post;
import com.baltictalents.Blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("post/{id}")
    public Optional<Post> getPost(@PathVariable Integer id){ return postService.getPost(id); }

    @PostMapping("/post")
    public void writePost(@RequestBody Post post){
        postService.writePost(post);
    }




}
