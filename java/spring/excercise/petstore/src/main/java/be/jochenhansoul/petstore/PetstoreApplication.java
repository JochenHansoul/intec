package be.jochenhansoul.petstore;

import be.jochenhansoul.petstore.model.Category;
import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import be.jochenhansoul.petstore.repository.CategoryRepository;
import be.jochenhansoul.petstore.repository.PetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetstoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PetstoreApplication.class, args);
		CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);
		PetRepository petRepository = ctx.getBean(PetRepository.class);

		Category category1 = new Category(1L, "mammal");
		Category category2 = new Category(2L, "arachnid");

		categoryRepository.save(category1);
		categoryRepository.save(category2);

		petRepository.save(new Pet(
				1L,
				category1,
				"dog",
				PetStatus.AVAILABLE
		));
		petRepository.save(new Pet(
				2L,
				category1,
				"cat",
				PetStatus.AVAILABLE
		));
		petRepository.save(new Pet(
				3L,
				category2,
				"spider",
				PetStatus.SOLD
		));

		petRepository.getPetsByStatus(PetStatus.AVAILABLE)
				.forEach(System.out::println);
	}

}
