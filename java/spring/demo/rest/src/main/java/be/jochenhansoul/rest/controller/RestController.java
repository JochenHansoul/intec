package be.jochenhansoul.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/")
public class RestController {

    //localhost:8080/hello
    @RequestMapping("hello")
    public String helloWorld() {
        System.out.println("hello world method called");
        return "hello world";
    }

    @RequestMapping("goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
