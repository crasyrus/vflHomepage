/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Klaus
 */
@Entity
@Table(name = "team")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
  @NamedQuery(name = "Team.findAllTeamNames", query = "SELECT name, shortName FROM Team t")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Team implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "short_name")
  private String shortName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "dfb_competition_id")
  private String dfbCompetitionId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "year_start")
  @Temporal(TemporalType.DATE)
  private Date yearStart;
  @Column(name = "year_end")
  @Temporal(TemporalType.DATE)
  private Date yearEnd;
  @Basic(optional = false)
  @NotNull
  @Column(name = "gender")
  private int gender;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
  @JsonManagedReference(value="team_training")
  private List<Trainingtime> trainingtimeList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
  @JsonManagedReference(value="team_match")
  private List<Match> matchList;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  @JsonManagedReference(value="category_team")
  private Category category;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
  private List<Player> playerList;
  @JoinTable(name = "trainer_team",
          joinColumns = {
            @JoinColumn(name = "team", nullable = false, updatable = false)},
          inverseJoinColumns = {
            @JoinColumn(name = "trainer", nullable = false, updatable = false)}
  )
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonManagedReference(value="team_trainer")
  private List<Trainer> trainerList;

  public Team() {
  }

  public Team(Integer id) {
    this.id = id;
  }

  public Team(Integer id, String name, String shortName, String dfbCompetitionId, Date yearStart, int gender) {
    this.id = id;
    this.name = name;
    this.shortName = shortName;
    this.dfbCompetitionId = dfbCompetitionId;
    this.yearStart = yearStart;
    this.gender = gender;
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

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getDfbCompetitionId() {
    return dfbCompetitionId;
  }

  public void setDfbCompetitionId(String dfbCompetitionId) {
    this.dfbCompetitionId = dfbCompetitionId;
  }

  public Date getYearStart() {
    return yearStart;
  }

  public void setYearStart(Date yearStart) {
    this.yearStart = yearStart;
  }

  public Date getYearEnd() {
    return yearEnd;
  }

  public void setYearEnd(Date yearEnd) {
    this.yearEnd = yearEnd;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  @XmlTransient
  public List<Trainer> getTrainerList() {
    return trainerList;
  }

  public void setTrainerList(List<Trainer> trainerList) {
    this.trainerList = trainerList;
  }

  @XmlTransient
  public List<Trainingtime> getTrainingtimeList() {
    return trainingtimeList;
  }

  public void setTrainingtimeList(List<Trainingtime> trainingtimeList) {
    this.trainingtimeList = trainingtimeList;
  }

  @XmlTransient
  public List<Match> getMatchList() {
    return matchList;
  }

  public void setMatchList(List<Match> matchList) {
    this.matchList = matchList;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @XmlTransient
  public List<Player> getPlayerList() {
    return playerList;
  }

  public void setPlayerList(List<Player> playerList) {
    this.playerList = playerList;
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
    if (!(object instanceof Team)) {
      return false;
    }
    Team other = (Team) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.siewares.springboottest.entity.Team[ id=" + id + " ]";
  }
  
}
