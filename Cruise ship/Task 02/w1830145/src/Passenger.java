public class Passenger {

    private String firstName;
    private String surname;
    private String expenses;

    Passenger() {
    }

    public Passenger(String firstName, String surname, String expenses) {
        this.firstName = firstName;
        this.surname = surname;
        this.expenses = expenses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
}
