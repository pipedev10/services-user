package com.example.servicesuser.persistence.repository;

import com.example.servicesuser.persistence.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<Users, Integer> {

  Optional<Users> findByUserId(int userId);
  Optional<Users> findByUserNameAndPassword(String userName, String password);
}
