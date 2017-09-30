import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class DataController {

    public static ModelAndView renderMainMenu(){
        Map params = new HashMap<String, String>();
        //params.put("this", "That's it bro!");

        return new ModelAndView(params, "/index");
    }
}
