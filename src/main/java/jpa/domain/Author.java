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
  @Column(name = "A_ID")
  private Long   authorid;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false)
  private int    age;
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

  public Author()
  {
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
    return authorid;
  }

  public void setAuthorId(Long authorid)
  {
    this.authorid = authorid;
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
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Author author = (Author) o;

    if (!authorid.equals(author.authorid)) {
      return false;
    }
    if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) {
      return false;
    }
    return lastName != null ? lastName.equals(author.lastName) : author.lastName == null;
  }

  @Override
  public int hashCode()
  {
    int result = authorid.hashCode();
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    return "Author{" +
           "authorid=" + authorid +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", age=" + age +
           ", books=" + books +
           '}';
  }
}
