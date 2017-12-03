package com.hobbyProject.mahs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "guest")
@Component
@Scope("session")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "lockerNo")
    private int lockerNo;

    @Column(name = "guestName")
    private String name;

    public Guest(int lockerNo, String name){
        this.lockerNo = lockerNo;
        this.name = name;
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
