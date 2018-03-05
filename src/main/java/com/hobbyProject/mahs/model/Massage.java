package com.hobbyProject.mahs.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
@Component
public class Massage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int length;

    @Column
    private int price;

    @Column
    private int breakAfter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "massage")
    private List<Treatment> treatments;

    public Massage() {
    }

    public Massage(int length){
        this.length = length;
        switch (length){
            case 15:
                this.price = 1990;
                this.breakAfter = 5;
                break;
            case 30:
                this.price = 3490;
                this.breakAfter = 5;
                break;
            case 45:
                this.price = 4990;
                this.breakAfter = 5;
                break;
            case 60:
                this.price = 6390;
                this.breakAfter = 10;
                break;
            case 90:
                this.price = 8990;
                this.breakAfter = 10;
                break;
        }
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBreakAfter() {
        return breakAfter;
    }

    public void setBreakAfter(int breakAfter) {
        this.breakAfter = breakAfter;
    }
}
