package by.Vlad.controllers;

import by.Vlad.DAO.BooksDAO;
import by.Vlad.DAO.PeopleDAO;
import by.Vlad.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
  private final JdbcTemplate jdbcTemplate;
  BooksDAO booksDAO;
  PeopleDAO peopleDAO;

  @Autowired
  public BooksController(BooksDAO booksDAO, PeopleDAO peopleDAO, JdbcTemplate jdbcTemplate) {
    this.peopleDAO = peopleDAO;
    this.booksDAO = booksDAO;
    this.jdbcTemplate = jdbcTemplate;
  }

  @GetMapping
  public String books(Model model) {
    List<Book> bookList = booksDAO.getAllBooks();
    model.addAttribute("books", bookList);
    return "book/books";
  }

  @GetMapping("/new")
  public String newBook(Model model) {
    model.addAttribute("book", new Book());
    return "book/newBook";
  }

  @PostMapping("/new")
  public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "book/newBook";
    }
    booksDAO.addBook(book);
    return "redirect:/books";
  }

  @GetMapping("/{id}")
  public String getBook(@PathVariable int id, Model model) {
    Book book = booksDAO.getBookById(id);
    model.addAttribute("book", book);
    if (book.getPeopleId() == null) {
      model.addAttribute("peoples", peopleDAO.getAllPeople());
    } else if (book.getPeopleId() != null) {
      model.addAttribute("person", peopleDAO.getPeopleById(book.getPeopleId()));
    }
    return "book/book";
  }

  @PatchMapping("/{id}")
  public String updateBook(@ModelAttribute("book") @Valid Book book, @PathVariable int id, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "book/book";
    }
    Book oldBook = booksDAO.getBookById(id);
    book.setTitle(oldBook.getTitle());
    book.setAuthor(oldBook.getAuthor());
    book.setYearOfIssue(oldBook.getYearOfIssue());
    if(oldBook.getPeopleId() != null) {
      book.setPeopleId(null);
    }
    book.setBookId(id);
    booksDAO.updateBook(book);
    return "redirect:/books";
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable int id){
    booksDAO.deleteBook(id);
  }

  @GetMapping("/{id}/edit")
  public String editBook(@PathVariable int id, Model model) {
    model.addAttribute("book", booksDAO.getBookById(id));
    return "book/editBook";
  }

  @PatchMapping("/{id}/edit")
  public String editedBook(@PathVariable int id, @ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "book/editBook";
    }
    booksDAO.updateBook(book);
    return "redirect:/books";
  }
}
