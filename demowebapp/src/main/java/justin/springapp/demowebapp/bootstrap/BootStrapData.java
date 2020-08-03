package justin.springapp.demowebapp.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import justin.springapp.demowebapp.domain.Author;
import justin.springapp.demowebapp.domain.Book;
import justin.springapp.demowebapp.domain.Publisher;
import justin.springapp.demowebapp.repositories.AuthorRepository;
import justin.springapp.demowebapp.repositories.BookRepository;
import justin.springapp.demowebapp.repositories.PublisherRepository;




@Component
public class BootStrapData implements CommandLineRunner{
	
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
		Publisher sp = new Publisher();
		sp.setName("Scholastic Point");
		sp.setCity("Wilkinsburg");
		sp.setState("Pennsylvania");
		
		Publisher hc = new Publisher();
		hc.setName("Harper Collins");
		hc.setCity("New York City");
		hc.setState("New York");
		
		Author gregory = new Author("Gregory", "Maguire");
		Book wicked = new Book("Wicked", "23452");
		
		gregory.getBooks().add(wicked);
		wicked.getAuthors().add(gregory);
		wicked.setPublisher(hc);
		hc.getBooks().add(wicked);
		
		authorRepository.save(gregory);
		bookRepository.save(wicked);
		publisherRepository.save(hc);
		
		
		
		Author phillip = new Author("Phillip", "Pullman");
		Book tsk = new Book("The Subtle Knife", "465468");
		
		phillip.getBooks().add(tsk);
		tsk.getAuthors().add(phillip);
		tsk.setPublisher(sp);
		sp.getBooks().add(tsk);
		
		authorRepository.save(phillip);
		bookRepository.save(tsk);
		publisherRepository.save(sp);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
	}
	
	

}
