package by.Vlad.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
  private Integer bookId;
  private Integer peopleId;
  @Size(min = 3,message = "The title must have no more than 3 characters")
  @NotEmpty(message = "Input book title")
  private String title;
  @Size(min = 3, message = "The author name must have no less than 3 characters")
  @NotEmpty(message = "Input author name")
  private String author;
  @Min(value = 1900, message = "Years will be greater than 1900")
  private int yearOfIssue;

  public Book() {
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
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
