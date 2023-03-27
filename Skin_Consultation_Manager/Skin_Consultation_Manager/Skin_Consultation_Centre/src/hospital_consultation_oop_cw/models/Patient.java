package hospital_consultation_oop_cw.models;

import java.io.Serializable;

public class Patient extends Person implements Serializable {

    private String id;

    public Patient(String fName, String sName, String dob, int contact, String id) {
        super(fName, sName, dob, contact);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
