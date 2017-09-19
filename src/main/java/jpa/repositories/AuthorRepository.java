package jpa.repositories;

import jpa.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lpetkov on 18/09/2017
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>
{

}
