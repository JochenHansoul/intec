package be.jochenhansoul.yummieapp;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.repository.LocationRepository;
import be.jochenhansoul.yummieapp.repository.RestaurantRepository;
import be.jochenhansoul.yummieapp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class YummieAppBackEndApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(YummieAppBackEndApplication.class, args);
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        LocationRepository locationRepository = ctx.getBean(LocationRepository.class);
        RestaurantRepository restaurantRepository = ctx.getBean(RestaurantRepository.class);

        // user
        User user1 = new User();
        user1.setFirstName("first1");
        user1.setLastName("last1");
        user1.setPassword("pass1");
        user1.setEmail("first.last@outlook.be");
        user1.setTelephone("+32 111 11 11 11");

        // location
        Location location1 = new Location().setLatitude(0).setLongitude(1);

        // restaurant
        Restaurant restaurant1 = new Restaurant()
                .setIdUser(user1.getUserId())
                .setName("First Restaurant")
                .setLocation(location1)
                .setRestaurantCertificateLocation("url");

        user1.addRestaurant(restaurant1);

        // saving
        locationRepository.save(location1);
        restaurantRepository.save(restaurant1);
        userRepository.save(user1);

        // receiving
        /*Restaurant storedRestaurant = restaurantRepository.getRestaurantsByIdRestaurantUser(user.getUserId()).get(0);
        System.out.println("stored restaurant");
        System.out.println(storedRestaurant);*/

        // getting stored user
        User storedUser1 = userRepository.getUsersByEmail("first.last@outlook.be");
        System.out.println("stored user:");
        System.out.println(storedUser1);
    }

}
