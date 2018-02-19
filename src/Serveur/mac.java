package Serveur;

public class mac {
    private String Assignment;
    private String OrganizationName;
    private String OrganizationAddress;

    public mac(String assignment,String organizationName, String organizationAddress){
        this.Assignment = assignment;
        this.OrganizationName = organizationName;
        this.OrganizationAddress = organizationAddress;
    }
    public mac(){

    }


    public String getOrganizationAddress() {
        return OrganizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        OrganizationAddress = organizationAddress;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    public String getAssignment() {
        return Assignment;
    }

    public void setAssignment(String assignment) {
        Assignment = assignment;
    }
}
