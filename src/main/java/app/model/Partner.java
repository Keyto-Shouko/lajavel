package app.model;

public class Partner {
    private String label;
    private String picture;

    public Partner(String label, String picture) {
        this.label = label;
        this.picture = picture;
    }

    public String getPartnerPicture() {
        return "https://avatars.dicebear.com/api/miniavs/"+this.label+".svg";
    }


}
