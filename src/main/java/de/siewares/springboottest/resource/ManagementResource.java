/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.resource;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Management;
import de.siewares.springboottest.service.ManagementService;
import de.siewares.springboottest.service.impl.ManagementServiceImpl;
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
@RequestMapping("/management")
public class ManagementResource {

  @Autowired
  private ManagementService service;

  @RequestMapping(method = RequestMethod.GET)
  List<Management> query() {
    return this.service.getAll();
  }

  @RequestMapping(value = "{id}/contact", method = RequestMethod.POST)
  void sendMail(@PathVariable int id, @RequestBody Mail mail) {
    Management person = service.get(id);
    mail.setTo(person.getMail());
    service.sendMail(mail);
  }

}
