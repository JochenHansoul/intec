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

@SpringBootApplication/*(exclude={SecurityAutoConfiguration.class})*/
public class YummieAppBackEndApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(YummieAppBackEndApplication.class, args);
        /*UserRepository userRepository = ctx.getBean(UserRepository.class);
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
        Location l1 = new Location().setLatitude(0).setLongitude(0);
        Location l2 = new Location().setLatitude(100).setLongitude(0);
        Location l3 = new Location().setLatitude(200).setLongitude(0);
        Location l4 = new Location().setLatitude(300).setLongitude(0);
        Location l5 = new Location().setLatitude(400).setLongitude(0);
        Location l6 = new Location().setLatitude(500).setLongitude(0);
        Location l7 = new Location().setLatitude(600).setLongitude(0);

        // restaurant
        Restaurant r1 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r1")
                .setLocation(l1)
                .setRestaurantCertificateLocation("url");
        Restaurant r2 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r2")
                .setLocation(l2)
                .setRestaurantCertificateLocation("url");
        Restaurant r3 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r3")
                .setLocation(l3)
                .setRestaurantCertificateLocation("url");
        Restaurant r4 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r4")
                .setLocation(l4)
                .setRestaurantCertificateLocation("url");
        Restaurant r5 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r5")
                .setLocation(l5)
                .setRestaurantCertificateLocation("url");
        Restaurant r6 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r6")
                .setLocation(l6)
                .setRestaurantCertificateLocation("url");
        Restaurant r7 = new Restaurant()
                .setIdUser(user1.getIdUser())
                .setName("r7")
                .setLocation(l7)
                .setRestaurantCertificateLocation("url");

        user1.addRestaurant(r1);


        // saving
        // locations
        locationRepository.save(l1);
        locationRepository.save(l2);
        locationRepository.save(l3);
        locationRepository.save(l7);
        locationRepository.save(l6);
        locationRepository.save(l5);
        locationRepository.save(l4);
        // restaurants
        restaurantRepository.save(r1);
        restaurantRepository.save(r2);
        restaurantRepository.save(r3);
        restaurantRepository.save(r7);
        restaurantRepository.save(r6);
        restaurantRepository.save(r5);
        restaurantRepository.save(r4);
        // users
        userRepository.save(user1);*/
    }

}
