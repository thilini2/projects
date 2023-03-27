import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(System.in);


        String []ServiceCenter1 = new String[13];  //Names of the passengers are stored
        Initialise(ServiceCenter1);  //Getting ready the cabin

        File myFile = new File("CruiseRecord.txt"); //Creating a file

        int userValue=0;
        while(userValue!=999){  //This is to exit from the program. You can use do-while loop too instead of this method
            System.out.println("To View all Cabins Available:--------------------"+"V\n"+
                               " To View all Empty Cabins:--------------------------"+"E\n"+
                               " To Add a Passenger to a Cabin:-------------------------"+"A\n"+
                               " To Remove Passenger from a Cabin:--------------------"+"D\n"+
                               " To View Passengers Sorted in an alphabetical order:-----"+"O\n"+
                               " To Store Program Data into file:-------------------"+"S\n"+
                               " To Load Program Data from file:--------------------"+"L\n"+
                               " To Exit the Program:-------------------------------"+"999 or Q");


            System.out.println("");
            System.out.println("Your selection: ");
            String user=input.next();
            switch (user){

                case "V":
                    ViewAllCabins(ServiceCenter1);
                    break;


                case "E":
                    ViewEmptyCabins(ServiceCenter1);
                    break;


                case "A":
                     AddPassenger(ServiceCenter1);
                    break;


                case "D":
                    RemovePassenger(ServiceCenter1);
                    break;


                case "O":
                    ViewPassengersSorted(ServiceCenter1);
                    break;


                case "S":
                    StoreFile(ServiceCenter1);
                    break;


                case "L":
                    LoadFile();
                    break;




                case "Q":
                    userValue = 999;
                    System.out.println("Thank you for using this cruise management system. Have a Good day!");
                    break;

                default:
                    System.out.println("Sorry, Invalid choice. Please try again.");
                    System.out.println("");
            }
        }
    }
    public static void Initialise(String cabins[]){
        //Getting ready all 12 cabins to store names of passengers.
        System.out.println("---Welcome to the cruise management  system!---");
        for(int x=0;x<12;x++){
            cabins[x]="e";
            System.out.println("Cabin number "+x+" initialized!");
        }
        System.out.println("All cabins successfully initialized! Please assign customers to each cabin.");
        System.out.println("");
    }
    public static void ViewAllCabins(String cabins[]){
        //This views all cabins  including empty cabins.
        System.out.println("---Viewing all cabins in the cruise---");
        for(int x=0;x<12;x++){
            if(cabins[x].equals("e")){
                System.out.println("Cabin number "+x+" is empty. Please assign a customer to this Cabin.");
            }
            else{
                System.out.println("Cabin number "+x+ " is occupied by "+cabins[x]);
            }
        }
        System.out.println("");
    }
    public static void ViewEmptyCabins(String cabins[]){
        //This views only empty cabins which can assign a new Passenger.
        System.out.println("---Viewing all empty cabins in the cruise---");
        int checkEmpty=0;  //A variable which used to check if all the cabins are occupied or not.
        for(int x=0;x<12;x++){
            if(cabins[x].equals("e")){
                checkEmpty=1;
                System.out.println("cabin number "+x+" is empty. Please assign a customer to this cabin.");
            }
        }
        if(checkEmpty==0){
            System.out.println("All cabins are occupied by passengers.");
        }
        System.out.println("");
    }
    public static void AddPassenger(String cabins[]) {
        //This lets you to add a new Passenger to the cabin. Also shows empty cabins to make the adding task easy.
        System.out.println("---Viewing empty booths that you can add a new customer---");
        for (int x = 0; x < 12; x++) {  //You can use previously declared method(ViewEmptyBooths) here too to show empty booths
            if (cabins[x].equals("e")) {
                System.out.println("Booth number " + x + " is empty. Enter " + x + " to assign a customer to this booth.");
            }
        }
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number: ");
        int cabinNum = input.nextInt();

        System.out.println("Enter customer name for booth " + cabinNum + " :");
        cabins[cabinNum] = input.next();


        System.out.println("Customer " + cabins[cabinNum] + " successfully added to the booth.");
        System.out.println("");

    }



    public static void RemovePassenger(String cabins[]){
        //This lets you to remove a passenger. To make the task easy, it shows occupied booths too.
        System.out.println("---Here is the current occupied cabins list---");
        ViewAllCabins(cabins);
        System.out.println("");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cabin number that you want to free?");
        int cabinFree = input.nextInt();

        cabins[cabinFree] = "e";
        System.out.println("The passenger in the cabin number "+cabinFree+" successfully removed from the cabins list.");
        System.out.println("");

    }
    public static void ViewPassengersSorted(String cabins[]){
        //Viewing passenger names in alphabetical order.
        System.out.println("---Viewing customer names according to the alphabetical order---");
        int n = 6;

        String temporary;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (cabins[i].compareTo(cabins[j])>0){
                    temporary = cabins[i];
                    cabins[i] = cabins[j];
                    cabins[j] = temporary;
                }
            }
        }
        System.out.println("Sorted passengers list: ");
        for (int i = 0; i < n; i++) {
            if(cabins[i].equals("e")){
                continue;
            }
            else {
                System.out.println(cabins[i]);
            }
        }
        System.out.println("");
    }

    public static void StoreFile(String cabins[]) throws IOException {
        //Storing data of the passengers
        FileWriter myFile = new FileWriter("CruiseRecord.txt");
        for(int x=0;x<cabins.length;x++){
            if(!(cabins[x].equals("e"))){
                myFile.write("Cabin Number "+x+"\nPassenger Name: "+cabins[x]+"\n");
                myFile.write("------------------\n");
                myFile.write("");
            }
        }
        myFile.close();
        System.out.println("Passenger details successfully updated to a file.");
        System.out.println("");
    }

    public static void LoadFile() throws FileNotFoundException {
        //Loading cabin numbers with the names to the console
        System.out.println("--- Printing information in the file to the console---");
        File myFile = new File("CruiseRecord.txt");
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        System.out.println("");

    }



}
