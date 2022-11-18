package app.controller;

import facade.Response;
import lajavel.View;

public class AboutController extends Controller{
    public static void about(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("about"));
    }
}
