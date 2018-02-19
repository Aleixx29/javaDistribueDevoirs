package Serveur;

import java.io.Serializable;

public class OUI implements Serializable {
    private String Assignment;
    private String OrganizationName;
    private String OrganizationAddress;

    //construteur de la classe OUI
    public OUI(String assignment, String organizationName, String organizationAddress){
        this.Assignment = assignment;
        this.OrganizationName = organizationName;
        this.OrganizationAddress = organizationAddress;
    }

    public OUI(){

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
