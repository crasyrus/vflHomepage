/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service;

import de.siewares.springboottest.entity.Category;
import de.siewares.springboottest.entity.News;
import java.util.List;

/**
 *
 * @author Klaus
 */
public interface NewsService {

  void delete(int id);

  List<News> getByCategory(Category category);

  void save(News news);
  
}
