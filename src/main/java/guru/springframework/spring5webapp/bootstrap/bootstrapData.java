package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public bootstrapData(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("eric","Evans");
        Book   ddd  = new Book("Domain Driven Design","112233");


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        System.out.println("starting boot strap");
        System.out.println(bookRepo.count());
    }
}
