package by.Vlad.DAO;

import by.Vlad.model.Book;
import by.Vlad.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
  private JdbcTemplate jdbcTemplate;
  private List<People> peopleList = new ArrayList<People>();
  private static int COUNTER = 0;

  @Autowired
  public PeopleDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public PeopleDAO() {

  }

  public List<People> getAllPeople() {
//    return jdbcTemplate.query("Select * FROM peoples", new BeanPropertyRowMapper<People>(People.class));
    return peopleList;
  }

  public People getPeopleById(int id) {
//    return null;
    for (People people : peopleList) {
      if (people.getId() == id) {
        return people;
      }
    }
    return new People();
  }

  public void addPeople(People people) {
//    jdbcTemplate.update("INSERT INTO peoples()");
    people.setId(COUNTER++);
    peopleList.add(people);
  }

  public void delete(int id) {
    for (People people : peopleList) {
      if (people.getId() == id) {
        peopleList.remove(people);
      }
    }
  }

  public void update(int id, People people) {
    People oldPeople = getPeopleById(id);
    oldPeople.setFio(people.getFio());
    oldPeople.setYearBirthday(people.getYearBirthday());
  }
}
