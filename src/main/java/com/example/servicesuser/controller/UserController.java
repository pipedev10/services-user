package com.example.servicesuser.controller;

import com.example.servicesuser.persistence.entity.Users;
import com.example.servicesuser.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/greeting")
  public ResponseEntity<String> helloUser(){
    return ResponseEntity.ok("Hello User");
  }

  @GetMapping("/all")
  public ResponseEntity<List<Users>> getAll(){
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }


  @PostMapping("/save")
  public ResponseEntity<Users> save(@RequestBody Users users){
    return new ResponseEntity<>(userService.save(users), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Users>  getUser(@PathVariable("id") int userId){
    return userService.getUser(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int productId){
    if(userService.delete(productId)){
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
