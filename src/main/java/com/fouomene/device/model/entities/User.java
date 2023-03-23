package com.fouomene.device.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_entity")
public class User extends AbstractEntity {

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String email;

  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  List<Role> roles;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

}
