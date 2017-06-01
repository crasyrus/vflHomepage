/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service.impl;

import de.siewares.springboottest.entity.Team;
import de.siewares.springboottest.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.siewares.springboottest.service.TeamService;

/**
 *
 * @author Klaus
 */
@Service
public class TeamServiceImpl implements TeamService {

  @Autowired
  private TeamRepository teamRepository;

  @Override
  public List<Team> getAll() {
    List<Team> result = teamRepository.findAll();
    return result;
  }

  @Override
  public List<Object[]> getAllTeamNames() {
    List<Object[]> result = teamRepository.findAllTeamNames();
    return result;
  }

  @Override
  public Team getByShortName(String shortName) {
    Team result = teamRepository.findByShortName(shortName);
    return result;
  }
}
