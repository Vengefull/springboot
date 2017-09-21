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

import static org.hamcrest.Matchers.*;

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

  @Test
  public void addFetchAuthor()
  {
    Author author = new Author("lubo", "petkov", 26);

    Book book  = new Book("Hello world");
    Book book2 = new Book("Hello world second edition");
    Book book3 = new Book("World of WarCraft");

    book.setAuthor(author);
    book2.setAuthor(author);
    book3.setAuthor(author);

    author.getBooks().add(book);
    author.getBooks().add(book2);
    author.getBooks().add(book3);

    authorRepository.save(author);
    authorRepository.findOne(author.getAuthorId());

    Author dbAuthor = authorRepository.findOne(author.getAuthorId());

    Assert.assertNotNull(dbAuthor);
    Assert.assertThat(dbAuthor.getBooks(), hasSize(3));
    Assert.assertThat(dbAuthor.getBooks().get(0).getTitle(), equalTo("Hello world"));
    Assert.assertEquals(dbAuthor.getBooks(), author.getBooks());
  }
}
