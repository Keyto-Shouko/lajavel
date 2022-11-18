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

    private PartnerRepository() {
        Partner floppa = new Partner("Big Floppa","/img/floppaGaming.png");
        Partner doge = new Partner("Doge","/img/doge.webp");
        Partner randomUser42 = new Partner("User42","");
        Partner wojak = new Partner("Wojak","/img/happyWojak.png");
        this.data = List.of(floppa, doge, randomUser42,wojak);
    }

    public static Partner allPartners() {
        return null;
    }

    public static Partner getOnePartner(Integer id) {
        return PartnerRepository.getInstance().data.get(id);
    }
}
