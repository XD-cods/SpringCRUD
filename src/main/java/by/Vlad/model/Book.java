package by.Vlad.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
  private Integer bookId;
  private Integer peopleId;
  @NotNull
  private String title;
  @NotNull
  @Size(min = 2, max = 20)
  private String author;
  @NotNull
  @Min(value = 0,message = "Years will be greater than 0")
  private int yearOfIssue;

  public Book() {
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
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

  public int getYearOfIssue() {
    return yearOfIssue;
  }

  public void setYearOfIssue(int yearOfIssue) {
    this.yearOfIssue = yearOfIssue;
  }

  public Integer getPeopleId() {
    return peopleId;
  }

  public void setPeopleId(Integer peopleId) {
    this.peopleId = peopleId;
  }
}
