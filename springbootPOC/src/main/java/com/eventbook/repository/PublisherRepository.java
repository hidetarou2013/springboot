/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbook.repository;

import com.eventbook.bean.Publisher;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author edureyes1
 */
public interface PublisherRepository extends ElasticsearchRepository<Publisher, String>  {
 
    public Publisher findById(String id);
    
    public Publisher findByUsername(String username);    
}
