package hospital_consultation_oop_cw.models;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {

    private int mLicence;
    private String specialisation;

    public Doctor(String fName, String sName, String dob, int contact, int mLicence, String specialisation) {
        super(fName, sName, dob, contact);
        this.mLicence = mLicence;
        this.specialisation = specialisation;
    }

    public int getmLicence() {
        return mLicence;
    }

    public void setmLicence(int mLicence) {
        this.mLicence = mLicence;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
