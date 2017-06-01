/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service.impl;

import de.siewares.springboottest.entity.Match;
import de.siewares.springboottest.entity.Team;
import de.siewares.springboottest.repository.MatchRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.siewares.springboottest.service.MatchService;

/**
 *
 * @author Klaus
 */
@Service
public class MatchServiceImpl implements MatchService {

  @Autowired
  private MatchRepository matchRepository;

  @Override
  public List<Match> getAll() {
    List<Match> result = matchRepository.findAll();
    return result;
  }

  @Override
  public Match getNextMatch(Team team) {
    List<Match> nextMatches = matchRepository.findByTeamAndKickoffAfterOrderByKickoffDesc(team, new Date());
    if (!nextMatches.isEmpty()) {
      return nextMatches.get(0);
    }
    return null;
  }

  @Override
  public Match getPrevMatch(Team team) {
    List<Match> prevMatches = matchRepository.findByTeamAndKickoffBeforeOrderByKickoffAsc(team, new Date());
    if (!prevMatches.isEmpty()) {
      return prevMatches.get(0);
    }
    return null;
  }
}
