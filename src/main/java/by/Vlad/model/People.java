package by.Vlad.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class People {
  private int id;
  @NotEmpty
  private String fio;
  @NotEmpty
  private int yearBirthday;
  private List<Book> books = new ArrayList<>();

  public People() {
  }

  public People(String fio, int yearBirthday) {
    this.fio = fio;
    this.yearBirthday = yearBirthday;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
  }

  public int getYearBirthday() {
    return yearBirthday;
  }

  public void setYearBirthday(int yearBirthday) {
    this.yearBirthday = yearBirthday;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
