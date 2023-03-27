package hospital_consultation_oop_cw.implementation;

import hospital_consultation_oop_cw.models.Doctor;
import hospital_consultation_oop_cw.ui.GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private static ArrayList<Doctor> doctors_list =new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        WestminsterSkinConsultationManager obj= new WestminsterSkinConsultationManager();
        Scanner input = new Scanner(System.in);

        try{
            obj.Load_file();
        }catch (IOException e){
            System.out.println("!!!---------------------save file not found -------------------------!!!");
        }

        while (true) {
            System.out.println("______________________________WELCOME________________________________");
            System.out.println();
            System.out.println("_________________ Skin Consultation Centre - Menu  __________________");                       // ----------- Display menu ---------------------
            System.out.println();
            System.out.println("_____________________Please Choose your selection ___________________");
            System.out.println();
            System.out.println("__ Enter '1' to Add a new doctor _______________________________\n" +
                    "__ Enter '2' to Delete a doctor ________________________________\n" +
                    "__ Enter '3' to View all doctors _______________________________\n" +
                    "__ Enter '4' to Save details  __________________________________\n" +
                    "__ Enter '5' to Open GUI _______________________________________\n"
            );

            try {
                System.out.println("_____________________ Enter your selection _____________________");
                int Menu_selection = input.nextInt();

                if (Menu_selection == 1){
                    obj.Add_doctor();
                }
                else if (Menu_selection == 2){
                    obj.Delete_doctor();
                }
                else if (Menu_selection == 3){
                    obj.View_All_doctors();
                }
                else if (Menu_selection == 4){
                    obj.Save_file();
                }
                else if (Menu_selection == 5){
                    GUI Home_Page_GUI = new GUI();                       //__ object of FormulaChampionshipManager given as parameter to
                }
                //__ Calling GUI class constructor
                else if (Menu_selection > 5) {
                    System.out.println("!!!______ Please enter a valid selection from the menu, Thank you ______!!!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("!!!______ Please enter a valid selection from the menu, Thank you _____!!!\n");
                main(null);
            }
        }
    }

    @Override
    public void Add_doctor() {
        try {
            System.out.println("Enter Doctor's First Name : ");
            String doctorFname = input.next();
            System.out.println("Doctor's SurName : .................... ");
            String doctorSname = input.next();
            System.out.println("Enter Doctor's date of birth :...................... ");
            String doctorDOB = input.next();
            System.out.println("Doctor's Contact Number :...................... ");
            int doctorContact = input.nextInt();
            System.out.println("Doctor's MLicense :...................... ");
            int doctorMLicense = input.nextInt();
            System.out.println("Doctor's Specialisation :...................... ");
            String doctorSpecialisation = input.next();

            boolean flag1 = true;
            for (Doctor temp : doctors_list) {
                if (temp.getfName().equals(doctorFname) && temp.getsName().equals(doctorSname)) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                doctors_list.add(new Doctor(doctorFname,doctorSname,doctorDOB,doctorContact,doctorMLicense,doctorSpecialisation));
                System.out.println("Doctor " + doctorFname +" "+ doctorSname + " is added\n" );
            }else{
                System.out.println("Doctor " + doctorFname +" "+ doctorSname + " is already existing\n" );
            }

        }catch(InputMismatchException e){
            System.out.println("!!!--------- Try again with valid inputs --!!!");
        }
    }

    @Override
    public void Delete_doctor() {
        System.out.println("Enter doctor's first name: ");
        String doctorFname = input.next();
        System.out.println("Enter doctor's surname: ");
        String doctorSname = input.next();

        int delObj = 0;
        for (Doctor temp : doctors_list) {
            if (temp.getfName().equals(doctorFname) && temp.getsName().equals(doctorSname)) {
                doctors_list.remove(delObj);
                System.out.println("Doctor " + temp.getfName() + " " + temp.getsName() + " is removed \n");
                return;
            }
            delObj++;
        }
        System.out.println("!!!---------- Please enter a valid doctor --------------!!!\n");
        Delete_doctor();
    }

    @Override
    public void View_All_doctors() {
        System.out.println("_____________________ Doctor list _____________________");

        if(doctors_list.size() > 0) {
            doctors_list.sort(new Comparator<Doctor>() {
                @Override
                public int compare(Doctor doctor1, Doctor doctor2) {
                    return doctor1.getsName().compareToIgnoreCase(doctor2.getsName());
                }
            });
            int counter = 0;
            for (Doctor temp : doctors_list) {
                counter++;
                System.out.printf("%s.   %s %s specialized in %s \n", counter, temp.getfName(), temp.getsName(), temp.getSpecialisation());
            }
        }else{
            System.out.println("-------------- No doctors available -----------------");
        }
        System.out.println("");
    }

    @Override
    public void Save_file() throws IOException {
        FileOutputStream saveFile_doctor = new FileOutputStream("saveFile_1.txt");    // Open a file to write to, named SavedObj.sav.
        ObjectOutputStream save_doctor = new ObjectOutputStream(saveFile_doctor);           // Create an ObjectOutputStream to put objects into save file.
        save_doctor.writeObject(doctors_list);                                              // write two objects
        save_doctor.close();
        System.out.println("Saved all data \n" );// close         // close
    }

    @Override
    public void Load_file() throws IOException, ClassNotFoundException {
        FileInputStream saveFile_doctor = new FileInputStream("saveFile_1.txt");
        ObjectInputStream restore_doctor = new ObjectInputStream(saveFile_doctor);
        doctors_list= (ArrayList<Doctor>) restore_doctor.readObject();
        restore_doctor.close();
    }
}
