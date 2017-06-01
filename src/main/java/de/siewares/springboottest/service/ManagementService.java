/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Management;
import java.util.List;

/**
 *
 * @author Klaus
 */
public interface ManagementService {

  Management get(int id);

  List<Management> getAll();

  void sendMail(Mail mail);
  
}
