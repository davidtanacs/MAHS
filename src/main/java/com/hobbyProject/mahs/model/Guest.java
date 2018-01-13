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

    @Column(name = "name")
    private String name;

    public Guest() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setLockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }

    public void setName(String name) {
        this.name = name;
    }
}
