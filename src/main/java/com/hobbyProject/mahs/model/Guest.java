package com.hobbyProject.mahs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Guest {


    private static int idCounter = 0;
    private int id;
    private int lockerNo;
    private String name;

    public Guest(int lockerNo, String name){
        this.lockerNo = lockerNo;
        this.name = name;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public int getLockerNo() {
        return lockerNo;
    }

    public String getName() {
        return name;
    }
}
