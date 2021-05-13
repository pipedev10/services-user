package com.example.servicesuser.persistence.repository;

import com.example.servicesuser.persistence.entity.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<Users, Integer> {

  Optional<Users> findByUserId(int userId);
}
