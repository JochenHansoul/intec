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

		Cake cake = new Cake("chocolate cake", 10, true);

		System.out.println("saved cake:");
		System.out.println(repository.save(cake));

		System.out.println("found cake:");
		repository.findAll().forEach(System.out::println);

		Optional<Cake> cake1 = Optional.of(repository.getById(1));
		//System.out.println(cake1);
	}

}
