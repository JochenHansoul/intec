package be.jochenhansoul.springdata;

import be.jochenhansoul.springdata.model.Cake;
import be.jochenhansoul.springdata.repository.CakeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataApplication.class, args);

		CakeRepository repository = ctx.getBean(CakeRepository.class);
		System.out.println(repository);

		Cake cake = new Cake();
		cake.setName("chocolate cake");
		cake.setSize(10);
		cake.setHasChocolate(true);

		Cake savedCake = repository.save(cake);
		System.out.println("saved cake: " + savedCake);
	}

}
