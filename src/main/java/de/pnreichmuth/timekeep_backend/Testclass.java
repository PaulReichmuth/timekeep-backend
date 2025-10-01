package de.pnreichmuth.timekeep_backend;

import java.util.Date;

public class Testclass {
    public String name;
    public int counter;
    public Date createdAt;
    public Date updatedAt;

    public Testclass(String name, int counter){
        this.name = name;
        this.counter = counter;
        this.createdAt = new Date();
        this.updatedAt = null;
    }
}
