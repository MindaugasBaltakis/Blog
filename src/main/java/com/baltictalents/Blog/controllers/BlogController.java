package com.baltictalents.Blog.controllers;

import com.baltictalents.Blog.entities.Post;
import com.baltictalents.Blog.services.PostService;
import com.baltictalents.Blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final PostService postService;
    private final UserService userService;

    public BlogController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }


    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @GetMapping("/user/posts")
    public List<Post> getAllUserPosts(Principal principal) {
        return postService.getAllUserPosts(principal.getName());
    }


    @GetMapping("post/{id}")
    public Optional<Post> getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }


    @PostMapping("/post")
    public void writePost(@RequestBody Post post, Principal principal) {
        post.setAuthor(userService.getUser(principal.getName()));
        postService.writePost(post);
    }

    @DeleteMapping("post/{id}")
    public void deletePost(@PathVariable Integer id, Principal principal) {
        if(postService.getPost(id).get().getAuthor().getUsername().equals(principal.getName())){
            postService.deletePost(id);
        }


    }

}