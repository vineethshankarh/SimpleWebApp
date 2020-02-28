package guru.springframework.Simple.web.Application.repositories;

import guru.springframework.Simple.web.Application.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
