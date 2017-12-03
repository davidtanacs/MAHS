package com.hobbyProject.mahs.model;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Shift {

    @Column(name = "shiftStart")
    LocalTime shiftStart;

    @Column(name = "shiftEnd")
    LocalTime shiftEnd;

    @Transient
    public List<LocalTime> freeAppointments = new ArrayList<>();

    public Shift() {
        this.freeAppointments = generateAppointments();
    }

    public boolean isAfternoon(){
        if (LocalTime.now().isAfter(LocalTime.of(13,00))){
            return true;
        }
        return false;
    }

    public List generateAppointments(){
        if (isAfternoon()){
            shiftStart = LocalTime.of(15,30);
            if (LocalTime.now().isAfter(shiftStart)){
                shiftStart = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            }
            shiftEnd = LocalTime.of(20,35);
        } else {
            shiftStart = LocalTime.of(9,00);
            if(LocalTime.now().isAfter(shiftStart)){
                shiftStart = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            }
            shiftEnd = LocalTime.of(11,35);
        }
        while (shiftStart.getMinute() % 5 != 0){
            shiftStart = shiftStart.plusMinutes(1);
        }
        while (shiftStart.isBefore(shiftEnd)){
            freeAppointments.add(shiftStart);
            shiftStart = shiftStart.plusMinutes(5);
        }
        return freeAppointments;
    }
}
