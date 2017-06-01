/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service.impl;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Trainer;
import de.siewares.springboottest.repository.TrainerRepository;
import de.siewares.springboottest.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.siewares.springboottest.service.TrainerService;

/**
 *
 * @author Klaus
 */
@Service
public class TrainerServiceImpl implements TrainerService {
  @Autowired
  private TrainerRepository repository;
  
  @Autowired
  private MailService mailService;
  
  @Override
  public Trainer get(int id) {
    Trainer trainer = repository.findOne(id);
    trainer.setHasMail(trainer.getMail() != null);
    return trainer;
  }
  
  @Override
  public void sendMail(Mail mail) {
    mailService.sendMail(mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getText());
  }
  
}
