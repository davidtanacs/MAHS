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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "massageTherapist")
    private List<Treatment> treatments;

    @Transient
    private static List<MassageTherapist> massageTherapists = new ArrayList<>();

    @ManyToOne
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

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public void addTreatments(Treatment treatmentId){
        treatments.add(treatmentId);
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
