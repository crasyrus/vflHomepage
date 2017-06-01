/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service;

import de.siewares.springboottest.entity.Mail;
import de.siewares.springboottest.entity.Trainer;

/**
 *
 * @author Klaus
 */
public interface TrainerService {

  Trainer get(int id);

  void sendMail(Mail mail);
  
}
