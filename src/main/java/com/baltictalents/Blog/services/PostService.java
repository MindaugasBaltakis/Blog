package com.baltictalents.Blog.services;

import com.baltictalents.Blog.entities.Post;
import com.baltictalents.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }


    public void writePost(Post post) {
        postRepository.save(post);
    }
}
