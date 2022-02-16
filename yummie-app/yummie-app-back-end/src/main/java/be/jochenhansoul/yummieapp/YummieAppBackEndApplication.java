package be.jochenhansoul.yummieapp;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.model.user.RestaurantUser;
import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.repository.LocationRepository;
import be.jochenhansoul.yummieapp.repository.RestaurantRepository;
import be.jochenhansoul.yummieapp.repository.RestaurantUserRepository;
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
        RestaurantUserRepository restaurantUserRepository = ctx.getBean(RestaurantUserRepository.class);

        // user
        User user = new User();
        user.setFirstName("first1");
        user.setLastName("last1");
        user.setPassword("pass1");
        user.setEmail("first.last@outlook.be");
        user.setTelephone("+32 111 11 11 11");
        userRepository.save(user);

        // getting stored user
        User storedUser = userRepository.getUsersByEmail("first.last@outlook.be");

        // restaurant user
        Location location1 = new Location().setLatitude(0).setLongitude(1);
        Restaurant restaurant1 = new Restaurant()
                .setIdRestaurantUser(user.getUserId())
                .setName("First Restaurant")
                .setLocation(location1)
                .setRestaurantCertificateLocation("url");
        RestaurantUser restaurantUser1 = new RestaurantUser(storedUser, restaurant1);

        // saving
        locationRepository.save(location1);
        restaurantRepository.save(restaurant1);
        restaurantUserRepository.save(restaurantUser1);

        // receiving
        //Restaurant storedRestaurant = restaurantRepository.getRestaurantByIdRestaurant(1L);
        Restaurant storedRestaurant = restaurantRepository.getRestaurantsByIdRestaurantUser(user.getUserId()).get(0);
        System.out.println("stored restaurant");
        System.out.println(storedRestaurant);

        System.out.println("stored restaurant user:");
        RestaurantUser storedRestaurantUser = restaurantUserRepository.getRestaurantUserByEmail("first.last@outlook.be");
        //storedRestaurantUser.addRestaurant(storedRestaurant);
        System.out.println(storedRestaurantUser);

    }

}
