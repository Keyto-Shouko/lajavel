package app.controller;

import facade.Response;
import lajavel.View;
import app.model.Person;

import java.util.Map;

public class IndexController extends Controller {

    public static void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Person marjory = new Person("Marjory","Delaqua");
        Person kasmeer = new Person("Kasmeer","Meade");
        Person logan = new Person("Logan","Tackeray");
        Person rytlock = new Person("Rytlock","Brimstone");
        //Person[] persons = {marjory,kasmeer,logan,rytlock};
        response.html(View.make("index", Map.entry("person",marjory),Map.entry("person2",kasmeer)/*Map.entry("persons",persons)*/));
    }
}
