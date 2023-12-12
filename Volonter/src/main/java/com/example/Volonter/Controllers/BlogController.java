package com.example.Volonter.Controllers;

import com.example.Volonter.models.Post;
import com.example.Volonter.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blogMain";
    }
    @GetMapping("/blog/add")
    public String getBlog(Model model) {
        model.addAttribute("title", "");
        return "blogAdd";
    }

    @PostMapping("/blog/add")
    public String blogAdd(@ModelAttribute("post")Post post) {
        postRepository.save(post);
        return "redirect:/blog";
    }

    public Post getPostById(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }
        else{
            throw new RuntimeException("Post not found!");
        }
    }
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", getPostById(id));
        model.addAttribute("title", "Post");
        return "blogDetails";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", getPostById(id));
        model.addAttribute("title", "Post");
        return "blogEdit";
    }
//    @GetMapping("/blog/{id}/edit")
//    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
//        if (!postRepository.existsById(id)){
//            return "redirect:/blog";
//        }
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post", res);
//        return "blogEdit";
//    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id,@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id,@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
//    @PostMapping("/blog/{id}/remove")
//    public String blogPostDelete(@ModelAttribute("post")Post post) {
//        postRepository.delete(post);
//        return "redirect:/blog";
//    }
}
