package be.jochenhansoul.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class RestController {

    //localhost:8080/hello
    @RequestMapping("/hello")
    public String helloWorld() {
        System.out.println("hello world method called");
        return "hello world";
    }
}
