package by.Vlad.DAO;

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

  public List<People> getAllPeople() {
    return jdbcTemplate.query("Select * FROM People", new BeanPropertyRowMapper<People>(People.class));
  }


}
