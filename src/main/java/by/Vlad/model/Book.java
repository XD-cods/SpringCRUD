package by.Vlad.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
  private int id;
  @NotEmpty
  private String title;
  @NotEmpty
  @Size(min = 2, max = 20)
  private String author;
  @NotEmpty
  @Min(value = 0,message = "Years will be greater than 0")
  private int year;

  public Book() {
  }

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
