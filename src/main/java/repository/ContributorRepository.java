package repository;

import app.model.Contributor;
import app.model.Partner;

import java.util.List;

public class ContributorRepository {
    private static ContributorRepository instance;
    private List<Contributor> data;


    private static ContributorRepository getInstance(){
        if (instance == null){
            instance = new ContributorRepository();
        }
        return instance;
    }

    private ContributorRepository() {
        Contributor damien = new Contributor("Damien","Dabernat");
        Contributor henri = new Contributor("Henri","Phothinantha");
        Contributor bruno = new Contributor("Bruno","Alves Carvalho");
        Contributor benjamin = new Contributor("Benjamin","Marques");
        this.data = List.of(damien, henri,bruno,benjamin);
    }

    public static List<Contributor> allContributors() {
        return ContributorRepository.getInstance().data;
    }

    public static Contributor getOneContributor(Integer id) {
        return ContributorRepository.getInstance().data.get(id);
    }
}
