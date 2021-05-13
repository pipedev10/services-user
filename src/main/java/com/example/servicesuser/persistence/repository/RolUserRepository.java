package com.example.servicesuser.persistence.repository;

import com.example.servicesuser.persistence.entity.RolUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUserRepository extends JpaRepository<RolUser, Integer> {

  Optional<RolUser> findByIdRol(int idRol);
}
