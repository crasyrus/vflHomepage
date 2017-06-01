/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Klaus
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "username")
  private String username;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "password")
  private String password;
  @OneToMany(mappedBy = "username")
  @JsonBackReference(value="management_user")
  private List<Management> managementList;
  @OneToMany(mappedBy = "username")
  @JsonBackReference(value="trainer_user")
  private List<Trainer> trainerList;

  public User() {
  }

  public User(String username) {
    this.username = username;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @XmlTransient
  public List<Management> getManagementList() {
    return managementList;
  }

  public void setManagementList(List<Management> managementList) {
    this.managementList = managementList;
  }

  @XmlTransient
  public List<Trainer> getTrainerList() {
    return trainerList;
  }

  public void setTrainerList(List<Trainer> trainerList) {
    this.trainerList = trainerList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (username != null ? username.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.siewares.springboottest.entity.User[ username=" + username + " ]";
  }
  
}
