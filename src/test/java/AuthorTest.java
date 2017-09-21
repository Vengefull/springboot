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
    Author author = new Author("lubo", "petkov", 26);
    Book   book   = new Book("Hello world");
    Book   book2  = new Book("Hello world second edition");

    author.getBooks().add(book);

    author.getBooks().add(book2);
    authorRepository.save(author);
    Author dbAuthor = authorRepository.findOne(author.getAuthorId());

   // authorRepository.save(author);
    dbAuthor = authorRepository.findOne(author.getAuthorId());
    System.out.println(dbAuthor.getFirstName() + " " + dbAuthor.getLastName() + " has " + dbAuthor.getBooks().size());
    Assert.assertNotNull(dbAuthor);
    Assert.assertEquals(dbAuthor.getFirstName(), author.getFirstName());

    System.out.println(dbAuthor.getBooks().get(0).getTitle() + ", " + dbAuthor.getBooks().get(1).getTitle());
    Book book3 = bookRepository.findOne(book2.getId());
    System.out.println(book3.getAuthor().getFirstName());
  }
}
