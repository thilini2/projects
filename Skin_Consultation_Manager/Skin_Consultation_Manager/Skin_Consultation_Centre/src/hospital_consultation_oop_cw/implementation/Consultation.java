package hospital_consultation_oop_cw.implementation;

public class Consultation {

    private String date;
    private String timeSlot;
    private String cost;
    private String notes;

    public Consultation(String date, String timeSlot, String cost, String notes) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.cost = cost;
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return timeSlot;
    }

    public void setTime(String time) {
        this.timeSlot = time;
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
