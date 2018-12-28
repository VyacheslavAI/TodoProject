package entities;

public class Client {
    private String id;

    private String companyName;

    public Client(String id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
