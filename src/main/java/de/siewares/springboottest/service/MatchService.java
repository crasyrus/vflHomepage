/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service;

import de.siewares.springboottest.entity.Match;
import de.siewares.springboottest.entity.Team;
import java.util.List;

/**
 *
 * @author Klaus
 */
public interface MatchService {

  List<Match> getAll();

  Match getNextMatch(Team team);

  Match getPrevMatch(Team team);
  
}
