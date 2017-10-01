import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.jws.WebParam;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List testList = new ArrayList();

        MassageTherapist testmasseur = new MassageTherapist(MassageTherapist.massageTherapist.Móni);
        MassageTherapist testmasseur2 = new MassageTherapist(MassageTherapist.massageTherapist.Kitti);


        testList.add(new MassageTherapist(MassageTherapist.massageTherapist.Kitti).name);
        testList.add(new MassageTherapist(MassageTherapist.massageTherapist.Betti).name);
        testList.add(new MassageTherapist(MassageTherapist.massageTherapist.Dani).name);
        testList.add(new MassageTherapist(MassageTherapist.massageTherapist.Dávid).name);


        params.put("masseur", testList);


        params.put("appointments", testmasseur.freeAppointments);


        return new ModelAndView(params, "/booking");
    }
}
