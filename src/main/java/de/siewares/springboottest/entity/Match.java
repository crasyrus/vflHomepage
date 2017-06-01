/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Klaus
 */
@Entity
@Table(name = "[match]")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Match.findAll", query = "SELECT m FROM Match m")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Match implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "kickoff")
  @Temporal(TemporalType.TIMESTAMP)
  private Date kickoff;
  @Basic(optional = false)
  @NotNull
  @Column(name = "is_home")
  private boolean isHome;
  @Column(name = "goals_home")
  private Integer goalsHome;
  @Column(name = "goals_away")
  private Integer goalsAway;
  @Column(name = "is_canceled")
  private Boolean isCanceled;
  @Column(name = "is_aborted")
  private Boolean isAborted;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
  private List<Goal> goalList;
  @JoinColumn(name = "opponent", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Club opponent;
  @JoinColumn(name = "team", referencedColumnName = "id")
  @ManyToOne(optional = false)
  @JsonBackReference(value="team_match")
  private Team team;

  public Match() {
  }

  public Match(Integer id) {
    this.id = id;
  }

  public Match(Integer id, Date kickoff, boolean isHome) {
    this.id = id;
    this.kickoff = kickoff;
    this.isHome = isHome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getKickoff() {
    return kickoff;
  }

  public void setKickoff(Date kickoff) {
    this.kickoff = kickoff;
  }

  public boolean getIsHome() {
    return isHome;
  }

  public void setIsHome(boolean isHome) {
    this.isHome = isHome;
  }

  public Integer getGoalsHome() {
    return goalsHome;
  }

  public void setGoalsHome(Integer goalsHome) {
    this.goalsHome = goalsHome;
  }

  public Integer getGoalsAway() {
    return goalsAway;
  }

  public void setGoalsAway(Integer goalsAway) {
    this.goalsAway = goalsAway;
  }

  public Boolean getIsCanceled() {
    return isCanceled;
  }

  public void setIsCanceled(Boolean isCanceled) {
    this.isCanceled = isCanceled;
  }

  public Boolean getIsAborted() {
    return isAborted;
  }

  public void setIsAborted(Boolean isAborted) {
    this.isAborted = isAborted;
  }

  @XmlTransient
  public List<Goal> getGoalList() {
    return goalList;
  }

  public void setGoalList(List<Goal> goalList) {
    this.goalList = goalList;
  }

  public Club getOpponent() {
    return opponent;
  }

  public void setOpponent(Club opponent) {
    this.opponent = opponent;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
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
    if (!(object instanceof Match)) {
      return false;
    }
    Match other = (Match) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.siewares.springboottest.entity.Match[ id=" + id + " ]";
  }
  
}
