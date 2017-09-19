package jpa.service;

import jpa.domain.Author;
import jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lpetkov on 18/09/2017
 */
@Service
public class AuthroServiceImpl implements AuthorService
{
  @Autowired
  AuthorRepository authorRepository;

  @Override
  public Author getAuthor(String firstName)
  {
    authorRepository.findAll();
    return null;
  }

  @Override
  public Author getAuthorByBookTitle(String title)
  {
    return null;
  }

  @Override
  public void addAuthor(Author author)
  {

  }
}
