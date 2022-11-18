package app.controller;

import app.model.Partner;
import facade.Response;
import lajavel.View;
import repository.PartnerRepository;

import java.util.Map;

public class PartnerController extends Controller{

    public static void partners(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("partners", Map.entry("partner1", PartnerRepository.getOnePartner(0)),Map.entry("partner2", PartnerRepository.getOnePartner(1)),Map.entry("partner3", PartnerRepository.getOnePartner(2)),Map.entry("partner4", PartnerRepository.getOnePartner(3))));
    }
}
