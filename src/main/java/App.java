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
                return new ThymeleafTemplateEngine().render(DataController.renderBooking());
            });

            enableDebugScreen();
        }

    }