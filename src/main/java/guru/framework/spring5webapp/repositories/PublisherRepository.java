package guru.framework.spring5webapp.repositories;

import guru.framework.spring5webapp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
