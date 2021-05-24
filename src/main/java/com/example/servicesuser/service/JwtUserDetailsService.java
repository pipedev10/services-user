package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.Users;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserServiceImpl userService;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Users> user = userService.getUserByName(username);
    if(user == null){
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    String password = bcryptEncoder.encode(user.get().getPassword());
    return new User(user.get().getUserName(), password,
        new ArrayList<>());
  }


}
