import java.time.Duration;
import java.time.Clock;
import java.time.LocalTime;

public class Treatment {

    private static int treatmentId = 0;
    private Duration treatmentLength;
    private LocalTime treatmentStart;
    private LocalTime treatmentEnd;
    private Duration breakAfter;
    MassageTherapist.massageTherapist massageTherapist;
    private int guestId;

    public Treatment(Long treatmentLength, int treatmentStartHour, int treatmentStartMinute, MassageTherapist.massageTherapist massageTherapist, int guestId) {
        treatmentId++;
        this.treatmentId = treatmentId;
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
    }

    public static int getTreatmentId() {
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

    public MassageTherapist.massageTherapist getMassageTherapist() {
        return massageTherapist;
    }

    public void setMassageTherapist(MassageTherapist.massageTherapist massageTherapist) {
        this.massageTherapist = massageTherapist;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
