package hospital_consultation_oop_cw.ui;

import hospital_consultation_oop_cw.models.Consultation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Patients {
    private static JFrame f;
    private static JTextField timeslot,fname,sname;
    private static JLabel labelOutput;

    public Patients(ArrayList<Consultation> consultationList){
        viewDetails(consultationList);
    }

    private static void viewDetails(ArrayList<Consultation> consultationList){
        f=new JFrame();
        f.setLayout(new BorderLayout(30,35));
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));

        JLabel labeltimeslot = new JLabel("Selected Time Slot");
        labeltimeslot.setBounds(50,60, 300,30);
        timeslot=new JTextField();
        timeslot.setBounds(50,90, 650,30);

        JLabel labelFname = new JLabel("Patient First Name");
        labelFname.setBounds(50,140, 300,30);
        fname=new JTextField("");
        fname.setBounds(50,170, 300,30);

        JLabel labelSname = new JLabel("Patient Surname");
        labelSname.setBounds(400,140, 300,30);
        sname=new JTextField("");
        sname.setBounds(400,170, 300,30);

        JButton b1=new JButton("Search");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(200,220, 350,30);

        JLabel labelDescription = new JLabel("Consultation Details", SwingConstants.CENTER);
        labelDescription.setBounds(0,280, 800,30);

        labelOutput = new JLabel("");
        labelOutput.setBounds(50,290, 300,150);

        b1.addActionListener(e->{
            searchEntry(sname.getText(), fname.getText(), timeslot.getText(), consultationList);
        });

        JSeparator line = new JSeparator();
        line.setBounds(0,270, 800,1);

        f.add(line);
        f.add(b1); f.add(labelOutput);
        f.add(labeltimeslot); f.add(timeslot);
        f.add(labelFname); f.add(fname);
        f.add(labelSname); f.add(sname);
        f.add(labelDescription);

        f.setSize(800,650);
        f.setTitle("Hospital Manager");
        f.setResizable(false);
        f.setVisible(true);

        DisplayExitButton(f);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void DisplayExitButton(Frame f){         // custom exit method
        JButton homeButton =  new JButton("Home");
        homeButton.setBounds(685,0,90,50);
        f.add(homeButton);
        homeButton.addActionListener(e->{
            GUI obj = new GUI();
            obj.mainMenu();
            f.setVisible(false);
            f.dispose();
        });
    }

    private static void searchEntry(String sname, String fname, String timeslot, ArrayList<Consultation> consultationList){
        boolean status = false;
        StringBuilder textOutput = new StringBuilder();
        String name = fname+" "+sname;

        for(Consultation entry:consultationList){
            if(entry.getPatientName().equals(name) && entry.getDate().equals(timeslot)){
                status = true;
                textOutput.append("<html>");
                textOutput.append("Doctor:  ").append(entry.getDoctorName()).append("<br/>");
                textOutput.append("Patient:  ").append(entry.getPatientName()).append("<br/>");
                textOutput.append("Date:  ").append(entry.getDate()).append("<br/>");
                textOutput.append("Cost:  ").append(entry.getCost()).append("<br/>");
                try{
                    textOutput.append("Notes:  ").append((entry.getNotes())).append("<br/>");
                }catch (Exception e){
                    System.out.println(e.toString());
                }

                textOutput.append("</html>");
                labelOutput.setText(textOutput.toString());
                break;
            }
        }

        if(!status){
            labelOutput.setText("No entry found");
        }
    }
}
