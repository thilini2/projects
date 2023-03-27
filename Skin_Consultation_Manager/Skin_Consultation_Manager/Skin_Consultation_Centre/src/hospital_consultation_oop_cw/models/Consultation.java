package hospital_consultation_oop_cw.models;

public class Consultation {
    private String doctorName;
    private String patientName;
    private String dateNtime;
    private String cost;
    private String notes;

    public Consultation(String doctorName, String patientName, String date, String cost, String notes) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.dateNtime = date;
        this.cost = cost;
        this.notes = notes;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDate() {
        return dateNtime;
    }

    public void setDate(String date) {
        this.dateNtime = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
