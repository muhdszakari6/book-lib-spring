package guru.framework.spring5webapp.bootstrap;

import guru.framework.spring5webapp.models.Author;
import guru.framework.spring5webapp.models.Book;
import guru.framework.spring5webapp.models.Publisher;
import guru.framework.spring5webapp.repositories.AuthorRepository;
import guru.framework.spring5webapp.repositories.BookRepository;
import guru.framework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Publisher fbg = new Publisher("FBG","No 99 Free bands street", "Free Bands", "Free bands state", "900023");
        publisherRepository.save(fbg);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","1092");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(fbg);
        fbg.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(fbg);

        Author jkrowling = new Author("JK", "Rowling");
        Book hp = new Book("Harry Potter, prisoner of Azkaban","1092");
        eric.getBooks().add(hp);
        hp.getAuthors().add(jkrowling);
        hp.setPublisher(fbg);
        fbg.getBooks().add(hp);
        authorRepository.save(jkrowling);
        bookRepository.save(hp);
        publisherRepository.save(fbg);



        System.out.println("Number of publishers " +publisherRepository.count());
        System.out.println("Publisher number of books: " + fbg.getBooks().size());
        System.out.println("Number of authors " +authorRepository.count());
        System.out.println("Number of books " +bookRepository.count());

    }
}
