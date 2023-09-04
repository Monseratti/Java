package mybook.booksdb.Controller;

import jakarta.websocket.server.PathParam;
import mybook.booksdb.Model.Book;
import mybook.booksdb.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/create";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable(value = "id") Long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/";
        }
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable(value = "id") Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/";
        }
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/";
        }
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String search, Model model) {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> searchResult = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().contains(search) ||
                    book.getAuthor().contains(search) ||
                    book.getJenre().contains(search) ||
                    book.getDescription().contains(search)) {
                searchResult.add(book);
            }
        }
        model.addAttribute("books", searchResult);
        return "index";
    }
}
