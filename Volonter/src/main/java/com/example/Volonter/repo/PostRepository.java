package com.example.Volonter.repo;

import com.example.Volonter.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
