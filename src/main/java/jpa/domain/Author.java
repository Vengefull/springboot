package jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpetkov on 18/09/2017
 */
@Entity
public class Author implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long       authorId;
  @Column(nullable = false)
  private String     firstName;
  @Column(nullable = false)
  private String     lastName;
  @Column(nullable = false)
  private int        age;
  /**
   * bidirectional relationship
   */
  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Book> books = new ArrayList<>();

  public Author(String firstName, String lastName, int age)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public Long getAuthorId()
  {
    return authorId;
  }

  public void setAuthorId(Long authorId)
  {
    this.authorId = authorId;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public List<Book> getBooks()
  {
    return books;
  }

  public void setBooks(List<Book> books)
  {
    this.books = books;
  }

  @Override
  public String toString()
  {
    return "Author{" +
           "authorId=" + authorId +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", age=" + age +
           ", books=" + books +
           '}';
  }
}
