/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.repository;

import de.siewares.springboottest.entity.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Klaus
 */
public interface TeamRepository extends JpaRepository<Team, Integer>{
  List<Object[]> findAllTeamNames();
  Team findByShortName(String shortName);
}
