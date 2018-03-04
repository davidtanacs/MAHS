package com.hobbyProject.mahs.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Component
public class Massage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    public int length;

    @Column
    private int price;

    @Column
    private int breakAfter;

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
}
