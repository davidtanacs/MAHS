package com.hobbyProject.mahs.model;

public enum Massage {

    fifteen(15),
    thirteen(30),
    fourtyfive(45),
    sixteen(60),
    nineteen(90);

    public int length;
    int price;
    int breakAfter;

    Massage(int length){
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
