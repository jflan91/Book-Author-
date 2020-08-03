package justin.springapp.demowebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import justin.springapp.demowebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
