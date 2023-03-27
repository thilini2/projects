public class Cabin {

    private String customerName;
    private int cabinNumber;
    private int noOfGuests;

    Cabin() {}

    public Cabin(int cabinNumber, String customerName, int noOfGuests){
        this.customerName = customerName;
        this.cabinNumber = cabinNumber;
        this.noOfGuests = noOfGuests;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getCabinNumber(){
        return cabinNumber;
    }
    public void setCabinNumber(int cabinNumber){
        this.cabinNumber=cabinNumber;
    }

    public void setNoOfGuests(int noOfGuests){
        this.noOfGuests = noOfGuests;
    }

    public int getNoOfGuests(){
        return noOfGuests;
    }

}

