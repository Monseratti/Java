package blogs.MyBlog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String blogMain(Model model) {
        model.addAttribute("title", "Blog page");
        model.addAttribute("text", "Blog text");
        return "blogMain";
    }
}
