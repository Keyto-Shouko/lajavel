package app.controller;

import app.model.Contributor;
import app.model.Partner;
import facade.Response;
import lajavel.View;
import app.model.Person;

import javax.servlet.http.Part;
import java.util.Map;

public class IndexController extends Controller {

    public static void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("index"));
    }
    public static void home(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("home"));
    }
}
