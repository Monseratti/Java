package mybook.booksdb.Controller;

import mybook.booksdb.Model.Book;
import mybook.booksdb.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }
}
