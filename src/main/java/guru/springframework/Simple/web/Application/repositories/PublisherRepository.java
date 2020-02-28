package guru.springframework.Simple.web.Application.repositories;

import guru.springframework.Simple.web.Application.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
