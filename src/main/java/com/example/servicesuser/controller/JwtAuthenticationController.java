package com.example.servicesuser.controller;

import com.example.servicesuser.config.JwtTokenUtil;
import com.example.servicesuser.persistence.entity.JwtRequest;
import com.example.servicesuser.persistence.entity.JwtResponse;
import com.example.servicesuser.persistence.entity.Users;
import com.example.servicesuser.persistence.repository.UserCrudRepository;
import com.example.servicesuser.service.JwtUserDetailsService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
  @Autowired
  private UserCrudRepository userCrudRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    String token = "";

    Optional<Users> users = userCrudRepository.findByUserNameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    if(users.isPresent()){
      authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

      final UserDetails userDetails = userDetailsService
          .loadUserByUsername(authenticationRequest.getUsername());

      token = jwtTokenUtil.generateToken(userDetails);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User or Password not valid");
    }

    return ResponseEntity.ok(new JwtResponse(token));


  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
