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

    public static ModelAndView renderBooking(){
        Map params = new HashMap<String, String>();

        /*Treatment test = new Treatment(90L, 6, 15, MassageTherapist.massageTherapist.Móni, 1);
        List testList = new ArrayList();
        testList.add(test.getTreatmentLength());
        testList.add(test.getTreatmentStart());
        testList.add(test.getTreatmentEnd());
        testList.add(test.getBreakAfter());
        testList.add(test.getMassageTherapist());
        testList.add(test.getGuestId());
        testList.add(test.getTreatmentId());
        params.put("test", testList);*/

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
}
