package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.Users;
import com.example.servicesuser.persistence.repository.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserCrudRepository userCrudRepository;

  public List<Users> getAll(){
    return (List<Users>) userCrudRepository.findAll();
  }

  public Users save(Users users){
    return userCrudRepository.save(users);
  }

  public Optional<Users> getUser(int userId){
    return userCrudRepository.findByUserId(userId);
  }

  public Boolean delete(int userId){
    return getUser(userId).map(product -> {
      userCrudRepository.deleteById(userId);
      return true;
    }).orElse(false);
  }
}
