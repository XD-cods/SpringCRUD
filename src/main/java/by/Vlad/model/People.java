package by.Vlad.model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class People {
  private int peopleId;
  @NotEmpty
  private String fio;
  @NotEmpty
  private int birthYear;

  public People() {
  }

  public People(String fio, int birthYear) {
    this.fio = fio;
    this.birthYear = birthYear;
  }

  public int getPeopleId() {
    return peopleId;
  }

  public void setPeopleId(int peopleId) {
    this.peopleId = peopleId;
  }

  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
