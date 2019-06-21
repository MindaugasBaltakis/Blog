package com.baltictalents.Blog.controllers;

import com.baltictalents.Blog.entities.Post;
import com.baltictalents.Blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public void writePost(@RequestBody Post post){
        postService.writePost(post);
    }
}
