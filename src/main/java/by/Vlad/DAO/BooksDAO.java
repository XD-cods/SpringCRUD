package by.Vlad.DAO;

import by.Vlad.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksDAO {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public BooksDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

}
