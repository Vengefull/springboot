package jpa.repositories;

import jpa.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lpetkov on 18/09/2017
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long>
{
}
