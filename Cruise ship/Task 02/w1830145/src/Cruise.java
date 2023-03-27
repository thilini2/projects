
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cruise {

    private static final Scanner input1 = new Scanner(System.in);
    static Cabin[] cabins = new Cabin[12];

    public static void main(String[] args) {

        Passenger[] persons = new Passenger[12];
        String selected = "";

        // initialise
        setCabins(cabins, persons);

        // loop until user stops
        while (true) {
            if (!selected.equalsIgnoreCase("Q")) {
                selected = displayMenu();
                menu(selected,persons);
            } else {
                System.out.println("Thank you for visiting us.");
                break;
            }
        }
    }

    public static void setCabins(Cabin[] rooms, Passenger[] persons) {
        for (int x = 0; x < cabins.length; x++) {
            cabins[x] = new Cabin(x + 1, "empty",0);
            persons[x] = new Passenger("","","");
        }
        System.out.println("initialise ");
    }

    private static String displayMenu() {


        System.out.println("Menu :");
        System.out.println("V: ToView all cabins available");
        System.out.println("A: To Add new passenger to the cabin");
        System.out.println("E: To Display Empty cabins in the cruise");
        System.out.println("D: To Remove a Passenger from a cabin");
        System.out.println("F: To Find a Passenger in a cabin");
        System.out.println("S: To Store data into file");
        System.out.println("O: To Print to the cabins in the alphabetically order ");
        System.out.println("L: To Load data from file");
        System.out.println("Q: To Quit");
        System.out.println(("*********************"));

        System.out.println("What do you want to do? ");
        return input1.next();
    }

    private static void menu(String selected, Passenger[] persons) {

        switch (selected.toUpperCase()) {

            case "V":
                viewCabins(cabins);
                break;

            case "A":
                addAPassenger(cabins,persons);
                break;

            case "E":
                showEmptyCabins(cabins);
                break;

            case "D":
                removeAPassenger(cabins,persons);
                break;

            case "F":
                findAPassenger(cabins,persons);
                break;

            case "S":
                saveToFile(cabins,persons);
                break;

            case "L":
                cabins = loadFile();
                break;

            case "O":
                sortByName(cabins);
                break;

            default:
                break;
        }
    }

    //Sort By Name "O"
    private static void sortByName(Cabin[] cabins) {
        String temp1;
        for (int i = 0; i < cabins.length; i++) {
            for (int j = i + 1; j < cabins.length; j++) {

                // to compare one string with other strings
                if (cabins[i].getCustomerName().compareTo(cabins[j].getCustomerName()) > 0) {
                    // swapping
                    temp1= cabins[i].getCustomerName();
                    cabins[i].setCustomerName(cabins[j].getCustomerName());
                    cabins[j].setCustomerName(temp1);
                }
            }
        }
        printCabins(cabins);
    }

    private static void printCabins(Cabin[] cabins) {
        System.out.println("Printing the sorted Array of the names of the passengers");
        for (int i = 0; i < cabins.length; i++) {
            System.out.println("Passenger Name: " + cabins[i].getCustomerName());
        }
    }

    //Load from file "L"
    private static Cabin[] loadFile() {
        Cabin[] tmp1 = new Cabin[12];
        try {
            System.out.println("Enter File name to load");
            String folderName = input1.next();
            BufferedReader infile = new BufferedReader(new FileReader(folderName));
            String l;
            System.out.println("The File contained:");
            int i = 1;
            while ((l = infile.readLine()) != null) {
                System.out.println(l);
                tmp1[i].setCustomerName(l);
                i++;
            }
            infile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int x = 0; x < tmp1.length; x++) {
            if (tmp1[x].getCustomerName() == null) {
                tmp1[x].setCustomerName("empty");
            }
        }
        return tmp1;
    }

    //Write to file "S"
    private static void saveToFile(Cabin[] cabins, Passenger[] persons) {
        String folderName = "";
        while (folderName.equals("")) {
            System.out.println("Enter File Name to read");

            folderName = input1.next();
            System.out.println("File Created");
        }
        try {
            FileWriter writer = new FileWriter(folderName);
            writer.write("CabinNo, Name, NoOfGuests, FirstName, Surname, Expenses\n");
            for (int i = 0; i < cabins.length; i++) {
                writer.write( (i + 1)+", "+cabins[i].getCustomerName()+", "+cabins[i].getNoOfGuests()+", "+persons[i].getFirstName()+", "+persons[i].getSurname()+", "+persons[i].getExpenses());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Find a passenger
    private static void findAPassenger(Cabin[] cabins, Passenger[] persons) {
        System.out.println("Enter Passenger Name to find cabin: ");
        String name = input1.next();
        boolean nameAvailable = false;
        for (int x = 0; x < cabins.length; x++) {
            if (cabins[x].getCustomerName().equalsIgnoreCase(name)) {
                System.out.println(name + " is in cabin" + (x + 1));
                System.out.println("No. of passengers in cabin: "+ cabins[x].getNoOfGuests());
                System.out.println("Payment Details: ");
                System.out.println("Name: "+ persons[x].getFirstName() +" "+ persons[x].getSurname());
                System.out.println("Credit Card No.: "+ persons[x].getExpenses());
                nameAvailable = true;
            }
        }
        if (!nameAvailable) {
            System.out.println("Sorry. There is no customer named "+ name);
        }
    }

    //remove a customer from a cabin
    private static void removeAPassenger(Cabin[] cabins, Passenger[] persons) {
        System.out.println("Enter Passenger Name to Delete: ");
        String del = input1.next();
        for (int x = 0; x < cabins.length; x++) {
            if (cabins[x].getCustomerName().equalsIgnoreCase(del)) {
                cabins[x] = new Cabin();
                persons[x] = new Passenger("","","");
                cabins[x].setCustomerName("empty");
                System.out.println("Removed " + del + " from cabin " + x + 1);
            }
        }
    }

    //Could view the empty cabins in the cruise
    private static void showEmptyCabins(Cabin[] cabins) {
        for (int x = 0; x < cabins.length; x++) {
            if (cabins[x].getCustomerName().equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            }
        }
    }

    // Add a passenger to a cabin
    private static void addAPassenger(Cabin[] cabins, Passenger[] persons) {
        String cabinName;
        int cabinNum;
        System.out.println("Enter cabin number (1-12) or 13 to go back: ");
        cabinNum = input1.nextInt();
        if (cabinNum != 13) {
            if (cabins[cabinNum - 1].getCustomerName().equals("empty")) {
                System.out.println("Enter the name for a cabin " + cabinNum + " :");
                cabinName = input1.next();
                cabins[cabinNum - 1].setCustomerName(cabinName);
                System.out.println("Please note that you could only include a maximum of 3 passengers for a cabin");
                System.out.println("Enter no of passengers in a cabin " + cabinNum + " :");
                cabins[cabinNum - 1].setNoOfGuests(input1.nextInt());
                System.out.println("Payments of the customer: ");
                System.out.println("Enter first name: ");
                persons[cabinNum - 1].setFirstName(input1.next());
                System.out.println("Enter Surname: ");
                persons[cabinNum - 1].setSurname(input1.next());
                System.out.println("Enter expenses of the passenger: ");
                persons[cabinNum - 1].setExpenses(input1.next());
            } else {
                System.out.println("The cabin " + cabinNum + " is already occupied");
            }
        }
    }

    // View All Cabins "V"
    private static void viewCabins(Cabin[] cabins) {
        for (int x = 0; x < cabins.length; x++) { //By traversing looks whether the cabins are occupied or not
            if (cabins[x].getCustomerName().equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            } else {
                System.out.println("Cabin " + (x + 1) + " is occupied by " + (cabins[x].getCustomerName()));
            }
        }

    }
}
