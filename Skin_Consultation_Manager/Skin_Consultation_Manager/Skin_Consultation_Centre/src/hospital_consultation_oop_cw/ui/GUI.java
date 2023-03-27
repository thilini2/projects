package hospital_consultation_oop_cw.ui;

import hospital_consultation_oop_cw.models.Consultation;
import hospital_consultation_oop_cw.models.Doctor;
import hospital_consultation_oop_cw.models.Patient;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GUI {

    public static ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
    public static ArrayList<Patient> patientList=new ArrayList<Patient>();
    public static ArrayList<Consultation> consultationList=new ArrayList<Consultation>();

    public GUI() {
        readData();
        mainMenu();
    }

    public void mainMenu(){
        JFrame f;                // initializing the UI elements for home page
        f=new JFrame();

        JButton tableButton;
        JButton addButton;
        JButton viewButton;
        JButton exit;

        f.setLayout(new BorderLayout(30,35));
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));

        tableButton=new JButton("Doctor List");
        tableButton.setBackground(Color.black);
        tableButton.setForeground(Color.white);
        addButton=new JButton("Add Patient");
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        viewButton=new JButton("View Consultation Booking");
        viewButton.setBackground(Color.black);
        viewButton.setForeground(Color.white);

        exit=new JButton("Exit");
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);

        tableButton.setBounds(120,50,200,90);       // set locations for UI elements
        addButton.setBounds(120,170,200,90);
        viewButton.setBounds(420,50,200,90);
        exit.setBounds(420,170,200,90);

        tableButton.addActionListener(e->{
            new Doctors(doctorList,e.getSource());            // creating the object to call functions for driver table page
            f.setVisible(false);                              // setting the visibility as false on the frame
            f.dispose();                                      // closing the window
        });

        addButton.addActionListener(e->{
            new ConsultationForm(patientList,doctorList,consultationList);
            f.setVisible(false);
            f.dispose();
        });

        viewButton.addActionListener(e->{
            new Patients(consultationList);
            f.setVisible(false);
            f.dispose();
        });

        exit.addActionListener(e->{
            System.exit(0);                             // exiting from the software
        });

        f.add(addButton,BorderLayout.NORTH);
        f.add(tableButton,BorderLayout.NORTH);
        f.add(viewButton,BorderLayout.NORTH);
        f.add(exit,BorderLayout.NORTH);

        f.setSize(800,400);
        f.setTitle("Hospital Manager");
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void readData(){                           // racing the data from files

        try{
            FileInputStream file = new FileInputStream("saveFile_1.txt");
            ObjectInputStream input = new ObjectInputStream(file);
            doctorList = (ArrayList<Doctor>) input.readObject();
            input.close();

        } catch (Exception e) {
            System.out.println("File is not found ");
        }
    }

}


