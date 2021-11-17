package be.jochenhansoul.springdata;

import be.jochenhansoul.springdata.model.Cake;
import be.jochenhansoul.springdata.repository.CakeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataApplication.class, args);

		CakeRepository repository = ctx.getBean(CakeRepository.class);
		System.out.println(repository);

		System.out.println("saved cake:");
		repository.save(new Cake("chocolate cake", 10, true));
		repository.save(new Cake("vanilla cake", 10, false));
		repository.save(new Cake("strawberry cake", 5, false));

		System.out.println("found cake:");
		repository.findAll().forEach(System.out::println);
		System.out.println("found cake with size 10:");
		repository.findCakeBySize(10).forEach(System.out::println);

		Optional<Cake> cake1 = Optional.of(repository.getById(1));
		//System.out.println(cake1);
	}

}
