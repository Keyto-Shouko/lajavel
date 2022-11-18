package app.controller;

import app.model.Contributor;
import facade.Response;
import lajavel.View;
import repository.ContributorRepository;

import java.util.Map;

public class ContributorController extends Controller{
    public static void contributors(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("contributors", Map.entry("contributor1",ContributorRepository.getOneContributor(0)), Map.entry("contributor2",ContributorRepository.getOneContributor(1)), Map.entry("contributor3",ContributorRepository.getOneContributor(2)), Map.entry("contributor4",ContributorRepository.getOneContributor(3))));
    }
}
