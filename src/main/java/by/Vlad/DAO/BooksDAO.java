package by.Vlad.DAO;

import by.Vlad.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BooksDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Book> getAllBooks() {
    String sql = "select * from books";
    return new ArrayList<>(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class)));
  }

  public Book getBookById(int id) {
    String sql = "select * from books where book_id = ?";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class), id).stream().findFirst().orElse(null);
  }

  public void updateBook(Book book) {
    String sql = "update books set people_id =?, title = ?, author = ?, year_of_issue = ? where book_id = ?";
    jdbcTemplate.update(sql, book.getPeopleId(), book.getTitle(), book.getAuthor(), book.getYearOfIssue(), book.getBookId());
  }

  public void addBook(Book book) {
    String sql = "insert into books (title, author, year_of_issue) values (?, ?, ?)";
    jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getYearOfIssue());
  }

  public void deleteBook(int id) {
    String sql = "delete from books where book_id = ?";
    jdbcTemplate.update(sql, id);
  }
}
