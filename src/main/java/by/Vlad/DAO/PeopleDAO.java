package by.Vlad.DAO;

import by.Vlad.model.Book;
import by.Vlad.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleDAO {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public PeopleDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public PeopleDAO() {

  }

  public List<People> getAllPeople() {
    String sql = "select * from people";
    return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(People.class));
  }

  public People getPeopleById(int id) {
    String sql = "select * from people where people_id = ?";
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(People.class), id);
  }

  public List<Book> getPeoplesBook(int id) {
    String sql = "select * from books where people_id = ?";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class), id);
  }

  public void addPeople(People people) {
    String sql = "insert into people (fio,birth_year) values(?,?)";
    jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(People.class), people.getFio(), people.getBirthYear());
  }

  public void delete(int id) {
  String sql = "delete from people where people_id = ?";
  jdbcTemplate.update(sql,id);
  }

  public void update(int id, People people) {
  String sql = "update people set fio = ?, birth_year = ? where people_id = ?";
  jdbcTemplate.update(sql,people.getFio(),people.getBirthYear(),id);
  }
}
