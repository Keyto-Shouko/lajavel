package app;
import controller.IndexController;
import enums.HttpVerbs;
import lajavel.*;
import model.Person;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Application.start(7071,Application.Mode.INFO);
        Route.register(HttpVerbs.GET,"/", IndexController.class,"index");
    }
}