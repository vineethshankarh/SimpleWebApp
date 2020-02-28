package guru.springframework.Simple.web.Application.bootstrap;

import guru.springframework.Simple.web.Application.domain.Author;
import guru.springframework.Simple.web.Application.domain.Book;
import guru.springframework.Simple.web.Application.domain.Publisher;
import guru.springframework.Simple.web.Application.repositories.AuthorRepository;
import guru.springframework.Simple.web.Application.repositories.BookRepository;
import guru.springframework.Simple.web.Application.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine1("St Petersburg");
        publisher.setCity("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: "+publisherRepository.count());
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "564594");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
