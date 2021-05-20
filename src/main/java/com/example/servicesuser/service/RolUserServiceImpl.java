package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.RolUser;
import com.example.servicesuser.persistence.entity.Users;
import com.example.servicesuser.persistence.repository.RolUserRepository;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolUserServiceImpl implements RolUserService{

  @Autowired
  private RolUserRepository rolUserRepository;

  @Override
  public List<RolUser> getAll() {
    return (List<RolUser>) rolUserRepository.findAll();
  }

  @Override
  public RolUser save(RolUser rolUser) {
    return rolUserRepository.save(rolUser);
  }

  @Override
  public Optional<RolUser> getRolUser(int idRol) {
    return rolUserRepository.findByIdRol(idRol);
  }

  @Override
  public Boolean delete(int idRol) {
    return getRolUser(idRol).map(product -> {
      rolUserRepository.deleteById(idRol);
      return true;
    }).orElse(false);
  }
}
