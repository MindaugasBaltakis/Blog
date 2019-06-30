package com.baltictalents.Blog.repositories;

import com.baltictalents.Blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByAuthor_UsernameOrderByDateDesc(String username);
}
