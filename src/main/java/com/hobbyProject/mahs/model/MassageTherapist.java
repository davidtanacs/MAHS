package com.hobbyProject.mahs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("session")
public class MassageTherapist {

    public massageTherapist name;
    String gender;
    List<Integer> treatments;
    static List<MassageTherapist> massageTherapists = new ArrayList<>();
    public List<LocalTime> freeAppointments = new ArrayList<>();
    LocalTime shiftStart;
    LocalTime shiftEnd;
    
    
    public MassageTherapist(massageTherapist name){
        this.name = name;
        this.gender = name.getGender();
        this.treatments = new ArrayList<>();
        this.freeAppointments = generateAppointments();
        massageTherapists.add(this);

    }
    
    private boolean isAfternoon(){
        if (LocalTime.now().isAfter(LocalTime.of(13,00))){
            return true;
        }
        return false;
    }

    public static MassageTherapist getMasseurByName(String name){
        MassageTherapist.massageTherapist massageTherapist = MassageTherapist.massageTherapist.valueOf(name);
        for (MassageTherapist masseur: massageTherapists
             ) {
            if (massageTherapist.equals(masseur.getName())){
                return masseur;
            }
        }
        return null;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    private List generateAppointments(){
        if (isAfternoon()){
            shiftStart = LocalTime.of(15,30);
            if (LocalTime.now().isAfter(shiftStart)){
                shiftStart = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            }
            shiftEnd = LocalTime.of(20,35);
        } else {
            shiftStart = LocalTime.of(9,00);
            /*if(LocalTime.now().isAfter(shiftStart)){
                shiftStart = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            }*/
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

    public void addTreatments(Integer treatmentId){
        treatments.add(treatmentId);
    }

    public List<Integer> getTreatments() {
        return treatments;
    }

    public massageTherapist getName() {
        return name;
    }

    public enum massageTherapist {
        Móni("female"),
        Betti("female"),
        Kitti("female"),
        Dani("male"),
        Dávid("male");

        private String gender;

        massageTherapist(String gender){
            this.gender = gender;
        }

        public String getGender(){
            return gender;
        }

    }
}
