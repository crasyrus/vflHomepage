/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.resource;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Trainer;
import de.siewares.springboottest.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
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
@RequestMapping("/trainer")
public class TrainerResource {

  @Autowired
  private TrainerService service;

  @RequestMapping(value = "{id}/contact", method = RequestMethod.POST)
  void sendMail(@PathVariable int id, @RequestBody Mail mail) {
    Trainer trainer = service.get(id);
    mail.setTo(trainer.getMail());
    service.sendMail(mail);
  }
}
