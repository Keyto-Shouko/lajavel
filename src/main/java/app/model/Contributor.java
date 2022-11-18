package app.model;

public class Contributor {
    private String firstname;
    private String lastname;

    public Contributor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getContributorAvatar() {
        return "https://avatars.dicebear.com/api/miniavs/" + this.firstname + this.lastname + ".svg";
    }
}
