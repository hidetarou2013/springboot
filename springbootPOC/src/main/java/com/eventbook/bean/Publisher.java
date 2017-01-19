/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbook.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *
 * @author edureyes1
 */
@Document(indexName = "publisher", type = "publisher", shards = 1, replicas = 0, refreshInterval = "-1")
public class Publisher {

    @Id
    private String id;

    private String username;

    public Publisher(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public Publisher() {
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", username=" + username + '}';
    }

}
