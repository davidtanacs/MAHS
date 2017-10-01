import java.util.ArrayList;
import java.util.List;

public class MassageTherapist {

    massageTherapist name;
    String gender;
    List<String> treatments;

    MassageTherapist(massageTherapist name){
        this.name = name;
        this.gender = name.getGender();
        this.treatments = new ArrayList<>();
    }

    public void addTreatments(String treatmentId){
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
