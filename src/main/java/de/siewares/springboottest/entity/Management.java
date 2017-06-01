/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Klaus
 */
@Entity
@Table(name = "management")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Management.findAll", query = "SELECT m FROM Management m")})
public class Management implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "first_name")
  private String firstName;
  @Basic(optional = false)
  @NotNull
  @Column(name = "is_male")
  private boolean isMale;
  @Size(max = 45)
  @Column(name = "image_path")
  private String imagePath;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "address")
  private String address;
  @Basic(optional = false)
  @NotNull
  @Column(name = "postcode")
  private int postcode;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "city")
  private String city;
  @Size(max = 45)
  @Column(name = "number_private")
  private String numberPrivate;
  @Size(max = 45)
  @Column(name = "number_mobile")
  private String numberMobile;
  @Size(max = 45)
  @Column(name = "number_work")
  private String numberWork;
  @Size(max = 45)
  @Column(name = "mail")
  @JsonIgnore
  private String mail;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "job")
  private String job;
  @JoinColumn(name = "username", referencedColumnName = "username")
  @ManyToOne
  @JsonManagedReference(value="management_user")
  private User username;

  @Transient
  private boolean hasMail = false;

  public Management() {
  }

  public Management(Integer id) {
    this.id = id;
  }

  public Management(Integer id, String name, String firstName, boolean isMale, String address, int postcode, String city, String job) {
    this.id = id;
    this.name = name;
    this.firstName = firstName;
    this.isMale = isMale;
    this.address = address;
    this.postcode = postcode;
    this.city = city;
    this.job = job;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public boolean getIsMale() {
    return isMale;
  }

  public void setIsMale(boolean isMale) {
    this.isMale = isMale;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPostcode() {
    return postcode;
  }

  public void setPostcode(int postcode) {
    this.postcode = postcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getNumberPrivate() {
    return numberPrivate;
  }

  public void setNumberPrivate(String numberPrivate) {
    this.numberPrivate = numberPrivate;
  }

  public String getNumberMobile() {
    return numberMobile;
  }

  public void setNumberMobile(String numberMobile) {
    this.numberMobile = numberMobile;
  }

  public String getNumberWork() {
    return numberWork;
  }

  public void setNumberWork(String numberWork) {
    this.numberWork = numberWork;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public User getUsername() {
    return username;
  }

  public void setUsername(User username) {
    this.username = username;
  }

  public void setHasMail(boolean hasMail) {
    this.hasMail = hasMail;
  }
  
  public boolean isHasMail() {
    return hasMail;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Management)) {
      return false;
    }
    Management other = (Management) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.siewares.springboottest.entity.Management[ id=" + id + " ]";
  }

}
