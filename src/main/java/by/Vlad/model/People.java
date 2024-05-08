package by.Vlad.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class People {
  private int peopleId;
  @Size(min = 10,message = "the fio must have no less than 10 characters")
  @NotEmpty(message = "Input fio")
  private String fio;
  @Min(value = 1900,message = "the birth year must have no less than 1900 year")
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
