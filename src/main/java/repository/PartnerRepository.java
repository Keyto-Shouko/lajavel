package repository;

import app.model.Partner;

import java.util.List;

public class PartnerRepository {
    private static PartnerRepository instance;
    private List<Partner> data;


    private static PartnerRepository getInstance(){
        if (instance == null){
            instance = new PartnerRepository();
        }
        return instance;
    }

    public PartnerRepository() {
        Partner partner1 = new Partner("Github","nice.png");
        Partner partner2 = new Partner("Javalin","javalin.png");
        this.data = List.of(partner1, partner2);
    }

    public static Partner allPartners() {
        return null;
    }
}
