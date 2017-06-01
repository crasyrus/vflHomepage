/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.resource;

import de.siewares.springboottest.entity.News;
import de.siewares.springboottest.entity.Team;
import de.siewares.springboottest.service.NewsService;
import de.siewares.springboottest.service.TeamService;
import java.util.Collection;
import java.util.Collections;
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
@RequestMapping("/team")
public class TeamResource {

  @Autowired
  private TeamService teamService;

  @Autowired
  private NewsService newsService;

  @RequestMapping(method = RequestMethod.GET)
  List<Team> query() {
    return this.teamService.getAll();
  }

  @RequestMapping(value = "names", method = RequestMethod.GET)
  List<Object[]> getNames() {
    return this.teamService.getAllTeamNames();
  }

  @RequestMapping(value = "{shortName}", method = RequestMethod.GET)
  Team get(@PathVariable("shortName") String shortName) {
    return this.teamService.getByShortName(shortName);
  }

}
