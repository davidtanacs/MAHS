package com.hobbyProject.mahs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MassageTherapist")
@Component
@Scope("session")
public class MassageTherapist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    public massageTherapist name;

    @Column(name = "gender")
    String gender;

    @Transient
    List<Integer> treatments;

    @Transient
    static List<MassageTherapist> massageTherapists = new ArrayList<>();

    @Transient
    Shift shift;


    
    public MassageTherapist(massageTherapist name, Shift shift){
        this.name = name;
        this.gender = name.getGender();
        this.treatments = new ArrayList<>();
        this.shift = shift;
        massageTherapists.add(this);

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

    public void addTreatments(Integer treatmentId){
        treatments.add(treatmentId);
    }

    public List<Integer> getTreatments() {
        return treatments;
    }

    public massageTherapist getName() {
        return name;
    }

    public Shift getShift() {
        return shift;
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
