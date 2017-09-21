package jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lpetkov on 18/09/2017
 */
@Entity
public class Book implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long   id;
  @Column(nullable = false)
  private String title;
  /**
   * bidirectional relationship
   */
  @ManyToOne
  @JoinColumn(name = "authorId")
  private Author author;

  public Book(String title)
  {
    this.title = title;
  }

  public Book(String title, Author author)
  {
    this.title = title;
    this.author = author;
  }

  public Book()
  {
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Author getAuthor()
  {
    return author;
  }

  public void setAuthor(Author author)
  {
    this.author = author;
  }

  @Override
  public String toString()
  {
    return "Book{" +
           "id=" + id +
           ", title='" + title + '\'' +
           ", author=" + author +
           '}';
  }
}
