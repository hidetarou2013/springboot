/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbook.repository;

import com.eventbook.bean.Viewer;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author edureyes1
 */
public interface ViewerRepository extends CrudRepository<Viewer, String>{
    
    @Query("select * from viewers where username = ?0")
    Viewer findByUsername(String username);
}
