package app;
import app.controller.IndexController;
import enums.HttpVerbs;
import lajavel.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Application.start(7071,Application.Mode.INFO);
        Route.register(HttpVerbs.GET,"/", IndexController.class,"index");
    }
}