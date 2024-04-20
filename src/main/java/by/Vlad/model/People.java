package by.Vlad.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class People {
  private int id;
  @NotEmpty
  private String fio;
  @NotEmpty
  private int yearBirthday;

  public People() {
  }

  public People(String fio, int yearBirthday) {
    this.fio = fio;
    this.yearBirthday = yearBirthday;
  }
}
