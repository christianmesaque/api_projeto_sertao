package com.example.sertao.controller;
import com.example.sertao.post.Post;
import com.example.sertao.post.PostRepository;
import com.example.sertao.post.PostRequestDTO;
import com.example.sertao.post.PostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("post")
public class postController {
    @Autowired
    private PostRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void savePost(@RequestBody PostRequestDTO data) {
        Post postData = new Post(data);
        repository.save(postData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<PostResponseDTO> getAll() {
        List<PostResponseDTO> postList = repository.findAll().stream().map(PostResponseDTO::new).toList();
        return postList;
    }
}
