package blogs.MyBlog.Controllers;

import blogs.MyBlog.Models.Post;
import blogs.MyBlog.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class BlogController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        //reverse order of posts
        List<Post> postsReverse = new ArrayList<>();
        for (Post post : posts) {
            postsReverse.add(0, post);
        }
        model.addAttribute("posts", postsReverse);
        return "blogMain";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        model.addAttribute("post", null);
        return "blogAdd";
    }

    @PostMapping("/blog/add")
    public String blogAdd(@RequestParam String title, @RequestParam String shortDescription,
                          @RequestParam String content, Model model) {
        Post post = new Post(title, shortDescription, content);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Post post = null;
        if (postRepository.findById(id).isPresent()) {
            post = postRepository.findById(id).get();
        }
        model.addAttribute("post", post);
        return "blogInfo";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Post post = null;
        if (postRepository.findById(id).isPresent()) {
            post = postRepository.findById(id).get();
        }
        model.addAttribute("post", post);
        return "blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogEdit(@RequestParam long id, @RequestParam String title,
                           @RequestParam String shortDescription, @RequestParam String content,
                           Model model) {
        Post post = null;
        if (postRepository.findById(id).isPresent()) {
            post = postRepository.findById(id).get();
        }
        post.setTitle(title);
        post.setShortDescription(shortDescription);
        post.setContent(content);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}/remove")
    public String blogRemove(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Post post = null;
        if (postRepository.findById(id).isPresent()) {
            post = postRepository.findById(id).get();
            postRepository.delete(post);
        }
        return "redirect:/blog";
    }
}
