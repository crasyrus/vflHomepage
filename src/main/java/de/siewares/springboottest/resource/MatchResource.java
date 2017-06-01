/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.resource;

import de.siewares.springboottest.entity.Match;
import de.siewares.springboottest.entity.Team;
import de.siewares.springboottest.service.MatchService;
import de.siewares.springboottest.service.TeamService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Klaus
 */
@RestController
@RequestMapping("/match")
public class MatchResource {

  @Autowired
  private TeamService teamService;
  @Autowired
  private MatchService matchService;

  @RequestMapping(method = RequestMethod.GET)
  List<Match> query() {
    return this.matchService.getAll();
  }

  @RequestMapping(value = "{shortName}", method = RequestMethod.GET)
  List<Match> getMatchesToTeam(@PathVariable("shortName") String shortName) {
    Team team = this.teamService.getByShortName(shortName);
    return team.getMatchList();
  }

  @RequestMapping(value = "{shortName}/next", method = RequestMethod.GET)
  Match getNextMatchToTeam(@PathVariable("shortName") String shortName) {
    Team team = this.teamService.getByShortName(shortName);
    return matchService.getNextMatch(team);
  }

  @RequestMapping(value = "{shortName}/prev", method = RequestMethod.GET)
  Match getPrevMatchToTeam(@PathVariable("shortName") String shortName) {
    Team team = this.teamService.getByShortName(shortName);
    return matchService.getPrevMatch(team);
  }

}
