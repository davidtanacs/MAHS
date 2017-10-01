import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataController {

    public static ModelAndView renderMainMenu(){
        Map params = new HashMap<String, String>();
        /*MassageTherapist test = new MassageTherapist(MassageTherapist.massageTherapist.Móni);
        params.put("test", test.gender);*/

        Treatment test = new Treatment(90L, 6, 15, MassageTherapist.massageTherapist.Móni, 1);
        List testList = new ArrayList();
        testList.add(test.getTreatmentLength());
        testList.add(test.getTreatmentStart());
        testList.add(test.getTreatmentEnd());
        testList.add(test.getBreakAfter());
        testList.add(test.getMassageTherapist());
        testList.add(test.getGuestId());
        testList.add(test.getTreatmentId());
        params.put("test", testList);



        /*params.put("testLength", test.getTreatmentLength());
        params.put("testStart", test.getTreatmentStart());
        params.put("testEnd", test.getTreatmentEnd());
        params.put("testBreakAfter", test.getBreakAfter());
        params.put("testTherapist", test.getMassageTherapist());
        params.put("testGuestId", test.getGuestId());*/

        return new ModelAndView(params, "/index");
    }
}
