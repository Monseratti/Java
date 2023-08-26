package blogs.MyBlog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(@RequestParam(name = "login", required = false, defaultValue = "TestUser")
                        String login,
                        @RequestParam(name = "password", required = false, defaultValue = "userPassword")
                        String password,
                        Model model) {
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About page");
        model.addAttribute("text", "About text");
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("title", "Contacts page");
        model.addAttribute("text", "Contacts text");
        return "contacts";
    }

}
