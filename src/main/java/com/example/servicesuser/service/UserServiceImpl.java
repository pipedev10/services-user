package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.Users;
import com.example.servicesuser.persistence.repository.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserCrudRepository userCrudRepository;

  @Override
  public List<Users> getAll(){
    return (List<Users>) userCrudRepository.findAll();
  }

  @Override
  public Users save(Users users){
    return userCrudRepository.save(users);
  }

  @Override
  public Optional<Users> getUser(int userId){
    return userCrudRepository.findByUserId(userId);
  }

  @Override
  public Boolean delete(int userId){
    return getUser(userId).map(product -> {
      userCrudRepository.deleteById(userId);
      return true;
    }).orElse(false);
  }

  @Override
  public Users update(int userId, Users users) {
    if(!getUser(userId).isPresent()){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
    Users usersAux = userCrudRepository.save(users);
    return usersAux;
  }

  @Override
  public Optional<Users> loginUser(String userName, String password) {
    return userCrudRepository.findByUserNameAndPassword(userName, password);
  }

  @Override
  public Optional<Users> getUserByName(String userName) {
    return userCrudRepository.findByUserName(userName);
  }
}
