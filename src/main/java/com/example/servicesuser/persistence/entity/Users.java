package com.example.servicesuser.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;
  @Column(name = "username")
  private String username;

  @Column(name = "username", insertable = false, updatable = false)
  private String userName;

  private String password;
  private String email;
  private Boolean active;

  @ManyToOne
  @JoinColumn(name = "id_rol", nullable=false)
  public RolUser rolUser;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public RolUser getRolUser() {
    return rolUser;
  }

  public void setRolUser(RolUser rolUser) {
    this.rolUser = rolUser;
  }

  @Override
  public String toString() {
    return "Users{" +
        "userId=" + userId +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", active=" + active +
        ", rolUser=" + rolUser +
        '}';
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public Boolean isActive() {
    return active;
  }
}
