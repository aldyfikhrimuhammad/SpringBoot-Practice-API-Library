package net.batch7.apiLibrary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  // get mapping menggunakan request params
  @GetMapping("/hello")
  // localhost:8080/hello?key=value
  // localhost:8080/hello?username=femil
  public String hello(@RequestParam(value = "username", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  // path variable
  @GetMapping("/hello2/{name}")
  // localhost:8080/hello2/ajeng
  public String hello2(@PathVariable("name") String name) {
    return String.format("Hello %s from path variable", name);
  }

  // request body
  @GetMapping("/hello3")
  // localhost:8080/hello2/ajeng
  public String hello3(@RequestBody String name) {
    return String.format("Hello %s from request body", name);
  }

}
