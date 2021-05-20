package com.example.servicesuser.controller;

import com.example.servicesuser.persistence.entity.RolUser;
import com.example.servicesuser.service.RolUserServiceImpl;
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
@RequestMapping("/rol")
public class RolUserController {

  @Autowired
  private RolUserServiceImpl rolUserServiceImpl;

  @GetMapping("/all")
  public ResponseEntity<List<RolUser>> getAll(){
    return new ResponseEntity<>(rolUserServiceImpl.getAll(), HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<RolUser> save(@RequestBody RolUser rolUser){
    return new ResponseEntity<>(rolUserServiceImpl.save(rolUser), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RolUser>  getRolUser(@PathVariable("id") int roleId){
    return rolUserServiceImpl.getRolUser(roleId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int rolId){
    if(rolUserServiceImpl.delete(rolId)){
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
