package com.example.servicesuser.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol_user")
public class RolUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rol")
  private Integer idRol;

  private String name;

  @JsonIgnoreProperties(value = { "rolUser", "password" })
  @OneToMany(mappedBy = "rolUser")
  Set<Users> users;


  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Users> getUsers() {
    return users;
  }

  public void setUsers(Set<Users> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "RolUser{" +
        "idRol=" + idRol +
        ", name='" + name + '\'' +
        '}';
  }
}
