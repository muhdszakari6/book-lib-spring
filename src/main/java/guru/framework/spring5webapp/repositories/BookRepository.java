package guru.framework.spring5webapp.repositories;

import guru.framework.spring5webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
