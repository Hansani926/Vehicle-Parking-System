package model;

public class Driver {
    private  String dName;
    private String nic;
    private String dLNo;
    private String address;
    private String contact;

    public Driver() {

    }

    public Driver(String dName, String nic, String dLNo, String address, String contact) {
        this.dName = dName;
        this.nic = nic;
        this.dLNo = dLNo;
        this.address = address;
        this.contact = contact;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getdLNo() {
        return dLNo;
    }

    public void setdLNo(String dLNo) {
        this.dLNo = dLNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
