package com.hobbyProject.mahs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;


@Component
@Scope("session")
public class Treatment {

    private static int treatmentCounter = 0;
    private int treatmentId;
    private Duration treatmentLength;
    private LocalTime treatmentStart;
    private LocalTime treatmentEnd;
    private Duration breakAfter;
    MassageTherapist massageTherapist;
    private int guestId;
    private int price;

    public Treatment(Long treatmentLength, int treatmentStartHour, int treatmentStartMinute, MassageTherapist massageTherapist, int guestId) {
        treatmentCounter++;
        this.treatmentId = treatmentCounter;
        this.treatmentLength = Duration.ofMinutes(treatmentLength);
        this.treatmentStart = LocalTime.of(treatmentStartHour, treatmentStartMinute);
        this.treatmentEnd = treatmentStart.plusMinutes(treatmentLength);
        this.massageTherapist = massageTherapist;
        this.guestId = guestId;
        if (treatmentLength < 60){
            this.breakAfter = Duration.ofMinutes(5);
        } else {
            this.breakAfter = Duration.ofMinutes(10);
        }
        if (treatmentLength == 15L) {
            this.price = 1990;
        } else if (treatmentLength == 30L) {
            this.price = 3490;
        } else if (treatmentLength == 45L) {
            this.price = 4990;
        } else if (treatmentLength == 60L) {
            this.price = 6390;
        } else if (treatmentLength == 90L) {
            this.price = 8990;
        }
    }

    public int getPrice() {
        return price;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public Duration getTreatmentLength() {
        return treatmentLength;
    }

    public void setTreatmentLength(Duration treatmentLength) {
        this.treatmentLength = treatmentLength;
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
