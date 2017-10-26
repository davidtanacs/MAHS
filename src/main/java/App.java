import spark.Request;
import spark.Response;
import spark.Spark.*;
import org.thymeleaf.context.WebContext;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class App {

    public static void main(String[] args){

            // default server settings
            exception(Exception.class, (e, req, res) -> e.printStackTrace());
            staticFileLocation("/public");
            port(1234);

            get("/", (Request req, Response res) -> {
                return new ThymeleafTemplateEngine().render(DataController.renderMainMenu());
            });

            get("/booking", (Request req, Response res) -> {
                return new ThymeleafTemplateEngine().render(DataController.renderBookingPage());
            });

            get("/submitBooking", (Request req, Response res) -> {
                int lockerNo = Integer.parseInt(req.queryParams("lockerno"));
                String name = req.queryParams("name");
                long length = Integer.parseInt(req.queryParams("length"));
                int treatmentStartHour = Integer.parseInt(req.queryParams("appointment").split(":")[0]);
                int treatmentStartMinute = Integer.parseInt(req.queryParams("appointment").split(":")[1]);
                String masseur = req.queryParams("masseur");

                DataController.BookAMassage(lockerNo, name, length, treatmentStartHour, treatmentStartMinute, masseur);

                return new ThymeleafTemplateEngine().render(DataController.renderMainMenu());
            });

            enableDebugScreen();
        }

    }