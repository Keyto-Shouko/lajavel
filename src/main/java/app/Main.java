package app;
import app.controller.AboutController;
import app.controller.ContributorController;
import app.controller.IndexController;
import app.controller.PartnerController;
import enums.HttpVerbs;
import lajavel.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Application.start(7071,Application.Mode.INFO);
        Route.register(HttpVerbs.GET,"/", IndexController.class,"index");
        Route.register(HttpVerbs.GET,"/contributors", ContributorController.class, "contributors");
        Route.register(HttpVerbs.GET,"/home", IndexController.class, "home");
        Route.register(HttpVerbs.GET,"/partners", PartnerController.class, "partners");
        Route.register(HttpVerbs.GET,"/about", AboutController.class, "about");

    }
}