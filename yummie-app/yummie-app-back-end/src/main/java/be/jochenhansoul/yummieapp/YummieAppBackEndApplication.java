package be.jochenhansoul.yummieapp;

import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class YummieAppBackEndApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(YummieAppBackEndApplication.class, args);
        /*UserRepository userRepository = ctx.getBean(UserRepository.class);

        User user = new User();
        user.setFirstName("first1");
        user.setLastName("last1");
        user.setPassword("pass1");
        user.setEmail("first.last@outlook.be");
        user.setTelephone("+32 111 11 11 11");
        userRepository.save(user);

        User user2 = userRepository.getUsersByEmail("first.last@outlook.be");
        System.out.println(user2);*/
    }

}
