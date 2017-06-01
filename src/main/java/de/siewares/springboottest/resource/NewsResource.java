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
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Klaus
 */
@RestController
public class NewsResource {

  @Autowired
  private NewsService service;

  @Autowired
  private TeamService teamService;

  @RequestMapping(value = "/news", method = RequestMethod.POST)
  void save(@RequestBody News news) {
    service.save(news);
  }

  @RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
  void delete(@PathVariable("id") int id) {
    service.delete(id);
  }

  @RequestMapping(value = "/news/team/{shortName}", method = RequestMethod.GET)
  List<News> getNews(@PathVariable("shortName") String shortName) {
    Team team = this.teamService.getByShortName(shortName);
    if (team != null) {
      return this.service.getByCategory(team.getCategory());
    } else {
      return Collections.<News>emptyList();
    }
  }
}
