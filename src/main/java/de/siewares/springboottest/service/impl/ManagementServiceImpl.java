/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service.impl;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Management;
import de.siewares.springboottest.repository.ManagementRepository;
import de.siewares.springboottest.service.MailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.siewares.springboottest.service.ManagementService;

/**
 *
 * @author Klaus
 */
@Service
public class ManagementServiceImpl implements ManagementService {
  
  @Autowired
  private MailService mailService;
  
  @Autowired
  private ManagementRepository repository;
  
  @Override
  public List<Management> getAll() {
    List<Management> result = this.repository.findAll();
    setHasMail(result);
    return result;
  }
  
  @Override
  public Management get(int id) {
    Management result = repository.findOne(id);
    result.setHasMail(result.getMail() != null);
    return result;
  }
  
  @Override
  public void sendMail(Mail mail) {
    mailService.sendMail(mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getText());
  }
  
  private void setHasMail(List<Management> management) {
    for (Management m : management) {
      m.setHasMail(m.getMail() != null);
    }
  }
}
