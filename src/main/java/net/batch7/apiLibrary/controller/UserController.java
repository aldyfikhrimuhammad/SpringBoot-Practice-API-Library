package net.batch7.apiLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.model.dto.UserDto;
import net.batch7.apiLibrary.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  private ResponseData<Object> responseData;

  @PostMapping
  public ResponseEntity<Object> signUp(@RequestBody UserDto request) {
    responseData = userService.register(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @PostMapping("/login")
  public ResponseEntity<Object> signIn(@RequestBody UserDto request) {
    responseData = userService.login(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }

  @PutMapping
  public ResponseEntity<Object> updateDetailUser(@RequestBody UserDto request) {
    responseData = userService.updateDetailUser(request);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);
  }
}
