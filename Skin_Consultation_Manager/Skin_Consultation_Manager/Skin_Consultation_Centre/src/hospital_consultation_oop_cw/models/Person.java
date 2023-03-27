package hospital_consultation_oop_cw.models;

import java.io.Serializable;

public class Person implements Serializable {

    private String fName;
    private String sName;
    private String dob;
    private int contact;

    public Person(String fName, String sName, String dob, int contact) {
        this.fName = fName;
        this.sName = sName;
        this.dob = dob;
        this.contact = contact;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
