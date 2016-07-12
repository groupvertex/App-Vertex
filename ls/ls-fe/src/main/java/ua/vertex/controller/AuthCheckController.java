package ua.vertex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCheckController {

    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public void check() {

    }
}
