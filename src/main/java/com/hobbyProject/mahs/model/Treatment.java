package com.hobbyProject.mahs.model;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "treatment")
@Component
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private LocalTime treatmentStart;

    @Column
    private LocalTime treatmentEnd;

    @Column(name = "break")
    private Duration breakAfter;

    @Column(name = "massage")
    private Massage massage;

    @Type(type = "MassageTherapist")
    private MassageTherapist massageTherapist;

    @Column(name = "guestId")
    private int guestId;

    public Treatment() {}

    public Treatment(Massage massage, int treatmentStartHour, int treatmentStartMinute, MassageTherapist massageTherapist, int guestId) {
        this.massage = massage;
        this.treatmentStart = LocalTime.of(treatmentStartHour, treatmentStartMinute);
        this.treatmentEnd = treatmentStart.plusMinutes(massage.length);
        this.massageTherapist = massageTherapist;
        this.guestId = guestId;

    }

    public Massage getMassage() {
        return massage;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }

    public int getId() {
        return id;
    }

    public LocalTime getTreatmentStart() {
        return treatmentStart;
    }

    public void setTreatmentStart(LocalTime treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    public LocalTime getTreatmentEnd() {
        return treatmentEnd;
    }

    public Duration getBreakAfter() {
        return breakAfter;
    }

    public void setBreakAfter(Duration breakAfter) {
        this.breakAfter = breakAfter;
    }

    public MassageTherapist getMassageTherapist() {
        return massageTherapist;
    }

    public void setMassageTherapist(MassageTherapist massageTherapist) {
        this.massageTherapist = massageTherapist;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
