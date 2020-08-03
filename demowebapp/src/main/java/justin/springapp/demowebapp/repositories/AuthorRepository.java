package justin.springapp.demowebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import justin.springapp.demowebapp.domain.*;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
