package jpa.service;

import jpa.domain.Author;
import org.springframework.stereotype.Service;

/**
 * Created by lpetkov on 18/09/2017
 */
@Service
public interface AuthorService
{
  Author getAuthor(String firstName);

  Author getAuthorByBookTitle(String title);

  void addAuthor(Author author);

}
