/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.service.impl;

import de.siewares.springboottest.entity.Category;
import de.siewares.springboottest.entity.News;
import de.siewares.springboottest.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import de.siewares.springboottest.repository.NewsRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import de.siewares.springboottest.service.NewsService;

/**
 *
 * @author Klaus
 */
@Service
public class NewsServiceImpl implements NewsService {
  
  @Autowired
  private NewsRepository newsRepository;
  
  @Override
  public void save(News news)  {
    newsRepository.save(news);
  }
  
  @Override
  public void delete(int id){
    newsRepository.delete(id);
  }
  
  
  @Override
  public List<News> getByCategory(Category category) {
   return  newsRepository.findByCategory(category);
  }
  
}
