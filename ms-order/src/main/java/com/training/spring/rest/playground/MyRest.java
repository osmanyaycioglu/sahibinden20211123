package com.training.spring.rest.playground;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myrest")
public class MyRest {

    @GetMapping("/hello1")
    public String hello1() {
        return "Hello world";
    }

    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") final String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("name") final String name) {
        return "Hello " + name;
    }

    @PostMapping("/xyz/{command}")
    public ResponseEntity<?> handleRequest(@PathVariable("command") final String command,
                                           final HttpServletRequest hsr) {
        switch (command) {
            case "add":
                String parameterLoc = hsr.getParameter("name");
                String parameter2Loc = hsr.getParameter("surname");
                return ResponseEntity.ok("OK");

            default:
                break;
        }
        return null;
    }

    @PostMapping("/xyz/add")
    public String handleRequest(@RequestParam("name") final String name,
                                @RequestParam("surname") final String surname) {
        return "OK";
    }

}
