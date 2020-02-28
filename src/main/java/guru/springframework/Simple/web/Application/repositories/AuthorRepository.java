package guru.springframework.Simple.web.Application.repositories;

import guru.springframework.Simple.web.Application.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
