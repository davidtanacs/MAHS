package com.hobbyProject.mahs.model;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.StringType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@TypeDef(
        name = "MassageTherapist",
        defaultForType = String.class,
        typeClass = StringType.class
)

@Entity
@Table(name = "MassageTherapist")
@Component
@Scope("session")
public class MassageTherapist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private massageTherapist name;

    @Column(name = "gender")
    private String gender;

    @Transient
    private List<Integer> treatments;

    @Transient
    private static List<MassageTherapist> massageTherapists = new ArrayList<>();

    @Type(type = "shift")
    private Shift shift;

    public MassageTherapist() {
    }

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
