import spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(1234);

        //get("/hello", (req,res) -> "Hello world!");

    }

}
