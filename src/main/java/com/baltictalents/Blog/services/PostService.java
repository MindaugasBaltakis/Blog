package com.baltictalents.Blog.services;

import com.baltictalents.Blog.entities.Post;
import com.baltictalents.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    public List<Post> getAllUserPosts(String username){
        return postRepository.findAllByAuthor_UsernameOrderByDateDesc(username);
    }

    public Optional<Post> getPost(Integer id){
        return postRepository.findById(id);
    }

    public void writePost(Post post) {
        postRepository.save(post);
    }

    public void deletePost(Integer id) {
         postRepository.deleteById(id);
    }

}
