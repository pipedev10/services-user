package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.Users;
import java.util.List;
import java.util.Optional;


public interface UserService {

  public List<Users> getAll();
  public Users save(Users users);
  public Optional<Users> getUser(int userId);
  public Boolean delete(int userId);
  public Users update(int userId, Users users);
  public Optional<Users> loginUser(String userName, String password);
  public Optional<Users> getUserByName(String userName);
}
