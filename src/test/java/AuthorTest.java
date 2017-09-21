import jpa.WebApplication;
import jpa.domain.Author;
import jpa.domain.Book;
import jpa.repositories.AuthorRepository;
import jpa.repositories.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lpetkov on 21/09/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class AuthorTest
{
  @Autowired
  AuthorRepository authorRepository;
  @Autowired
  BookRepository   bookRepository;

  @Test
  public void print()
  {
    Author author  = new Author("lubo", "petkov", 26);
    Author author2 = new Author("luben", "petkov", 26);


    Book book  = new Book("Hello world");
    Book book2 = new Book("Hello world second edition");
    Book book3 = new Book("world of warcraft");

    author2.getBooks().add(book3);

    book3.setAuthor(author2);
    book.setAuthor(author);
    book2.setAuthor(author);

    author.getBooks().add(book);
    author.getBooks().add(book2);

    authorRepository.save(author);
    //2nd author
    authorRepository.save(author2);
    book3.setTitle("Warcraft");
    bookRepository.save(book3);

    authorRepository.findOne(author2.getAuthorId());
    Author dbAuthor = authorRepository.findOne(author.getAuthorId());

    System.out.println(dbAuthor.getFirstName() + " " + dbAuthor.getLastName() + " has " + dbAuthor.getBooks().size());
    Assert.assertNotNull(dbAuthor);
    Assert.assertEquals(dbAuthor.getFirstName(), author.getFirstName());

    System.out.println(dbAuthor.getBooks().get(0).getTitle() + ", " + dbAuthor.getBooks().get(1).getTitle());
    Book book4 = bookRepository.findOne(book3.getId());
    System.out.println(book4.getTitle() + ":" + book4.getAuthor().getFirstName());
  }
}
