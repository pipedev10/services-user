package com.example.servicesuser.service;

import com.example.servicesuser.persistence.entity.RolUser;
import java.util.List;
import java.util.Optional;

public interface RolUserService {

  public List<RolUser> getAll();
  public RolUser save(RolUser rolUser);
  public Optional<RolUser> getRolUser(int idRol);
  public Boolean delete(int idRol);
}
