package com.study.system.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xtreme on 5/3/15.
 */
@Entity
@Table(name = "COUNTERS", schema = "StudySystem")
public class IdCounter {
    @Id
    private String id;

    @Column(name="NAME", unique = true)
    private String name;

    @Column(name="COUNTER")
    private int counter;

    public IdCounter(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void incrementCounter(){
        this.counter++;
    }
}
