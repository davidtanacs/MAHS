package com.hobbyProject.mahs.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.type.StringType;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@TypeDef(
        name = "shift",
        defaultForType = String.class,
        typeClass = StringType.class
)

@Entity
@Table
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "shiftStart")
    private LocalTime shiftStart;

    @Column(name = "shiftEnd")
    private LocalTime shiftEnd;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "name")
    private List<MassageTherapist> massageTherapistsWorking;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public List<LocalTime> getFreeAppointments() {
        return freeAppointments;
    }

    public void setFreeAppointments(List<LocalTime> freeAppointments) {
        this.freeAppointments = freeAppointments;
    }
}
