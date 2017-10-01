import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MassageTherapist {

    massageTherapist name;
    String gender;
    List<Integer> treatments;
    List<LocalTime> freeAppointments = new ArrayList<>();
    LocalTime shiftStart;
    LocalTime shiftEnd;
    
    
    MassageTherapist(massageTherapist name){
        this.name = name;
        this.gender = name.getGender();
        this.treatments = new ArrayList<>();
        this.freeAppointments = generateAppointments();

    }
    
    private boolean isAfternoon(){
        if (LocalTime.now().isAfter(LocalTime.of(13,00))){
            return true;
        }
        return false;
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
            shiftEnd = LocalTime.of(20,35);
        } else {
            shiftStart = LocalTime.of(9,00);
            shiftEnd = LocalTime.of(11,35);
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
