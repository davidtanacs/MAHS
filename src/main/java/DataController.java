import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.jws.WebParam;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class DataController {

    public static ModelAndView renderMainMenu(){
        Map params = new HashMap<String, String>();
        /*MassageTherapist test = new MassageTherapist(MassageTherapist.massageTherapist.Móni);
        params.put("test", test.gender);*/

        return new ModelAndView(params, "/index");
    }

    public static ModelAndView renderBookingPage(){
        Map params = new HashMap<String, String>();

        List masseurs = new ArrayList();
        List massageLengths = new ArrayList();

        MassageTherapist Kitti = new MassageTherapist(MassageTherapist.massageTherapist.Kitti);
        masseurs.add(Kitti.name);
        MassageTherapist Betti = new MassageTherapist(MassageTherapist.massageTherapist.Betti);
        masseurs.add(Betti.name);
        MassageTherapist Dani = new MassageTherapist(MassageTherapist.massageTherapist.Dani);
        masseurs.add(Dani.name);
        MassageTherapist Móni = new MassageTherapist(MassageTherapist.massageTherapist.Móni);
        masseurs.add(Móni.name);

        List appointments = Kitti.freeAppointments;
        params.put("appointments", appointments);
        params.put("masseurs", masseurs);


        massageLengths.add(Massage.fifteen.length);
        massageLengths.add(Massage.thirteen.length);
        massageLengths.add(Massage.fourtyfive.length);
        massageLengths.add(Massage.sixteen.length);
        massageLengths.add(Massage.nineteen.length);

        params.put("lengths", massageLengths);

        return new ModelAndView(params, "/booking");
    }

    public static void BookAMassage(int lockerNo, String name, long length, int treatmentStartHour, int treatmentStartMinute, String masseur){
        Guest guest = new Guest(lockerNo, name);
        Treatment treatment = new Treatment(length, treatmentStartHour, treatmentStartMinute,
                MassageTherapist.getMasseurByName(masseur), guest.getId());
        System.out.println(treatment.getTreatmentId());
        MassageTherapist.getMasseurByName(masseur).addTreatments(treatment.getTreatmentId());
        System.out.println(MassageTherapist.getMasseurByName(masseur).getTreatments());
        System.out.println("guest: " + guest.getName() + " id: " + guest.getId() + " lockerNO: " + guest.getLockerNo());
        System.out.println("treatment start: " + treatment.getTreatmentStart() + " end: " + treatment.getTreatmentEnd());
        System.out.println("length: " + treatment.getTreatmentLength()  + " break after: " + treatment.getBreakAfter());
        System.out.println("guestid: " + treatment.getGuestId() + " masseur: " + treatment.getMassageTherapist());
    }
    
    
}
