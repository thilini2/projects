package hospital_consultation_oop_cw.ui;

import hospital_consultation_oop_cw.models.Consultation;
import hospital_consultation_oop_cw.models.Doctor;
import hospital_consultation_oop_cw.models.Patient;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ConsultationForm {

    private static JFrame f;
    private static JTextField id,timeslot,fname,sname,contact,dob,cost;
    private static JLabel notify,labelSelectedDoctor;
    private static JTextArea note;
    private static JComboBox doctorList;

    public ConsultationForm(ArrayList<Patient> dataList , ArrayList<Doctor> doctorsList , ArrayList<Consultation> consultationList){

        String[] doctorsNames = new String[doctorsList.size()];

        f=new JFrame();
        f.setLayout(new BorderLayout(30,35));
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));

        JLabel labelid = new JLabel("Patient ID");
        labelid.setBounds(50,70, 300,30);
        id=new JTextField(UUID.randomUUID().toString());
        id.setBounds(50,100, 300,30);

        JLabel labeltimeslot = new JLabel("Selected Time Slot (dd/MM/yyyy HH:mm)");
        labeltimeslot.setBounds(400,70, 300,30);
        timeslot=new JTextField();
        timeslot.setBounds(400,100, 300,30);

        JLabel labelFname = new JLabel("Patient First Name");
        labelFname.setBounds(50,140, 300,30);
        fname=new JTextField("");
        fname.setBounds(50,170, 300,30);

        JLabel labelsname = new JLabel("Patient Surname");
        labelsname.setBounds(400,140, 300,30);
        sname=new JTextField("");
        sname.setBounds(400,170, 300,30);

        JLabel labelcontact = new JLabel("Patient Contact Number");
        labelcontact.setBounds(50,210, 300,30);
        contact=new JTextField("");
        contact.setBounds(50,240, 300,30);

        JLabel labeldob = new JLabel("Patient Date-Of-Birth (dd/MM/yyyy)");
        labeldob.setBounds(400,210, 300,30);
        dob=new JTextField("");
        dob.setBounds(400,240, 300,30);

        JLabel labelcost = new JLabel("Consultation Cost");
        labelcost.setBounds(50,280, 300,30);
        cost=new JTextField("");
        cost.setBounds(50,310, 300,30);

        JLabel labelnote = new JLabel("Consultation Note");
        labelnote.setBounds(400,280, 300,30);
        note=new JTextArea("");
        note.setBounds(400,310, 300,60);

        JButton submitButton=new JButton("Submit");
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.white);
        submitButton.setBounds(200,520, 350,30);

        submitButton.addActionListener(e->{
            if(addPatient(dataList)){
                addConsultation(consultationList);
            }
        });

        for(int i = 0; i < doctorsList.size(); i++){
            doctorsNames[i] = (doctorsList.get(i).getfName()+" "+doctorsList.get(i).getsName());
        }

        JLabel labelSelected = new JLabel("Selected : ");
        labelSelected.setBounds(50,395, 100,30);

        labelSelectedDoctor = new JLabel("");
        labelSelectedDoctor.setBounds(125,395, 300,30);

        JLabel labelDoctor = new JLabel("Available Doctor");
        labelDoctor.setBounds(50,430, 300,30);

        doctorList = new JComboBox(doctorsNames);
        doctorList.setBounds(50,460, 300,30);

        JButton checkButton =new JButton("Check Availability ");
        checkButton.setBackground(Color.black);
        checkButton.setForeground(Color.white);
        checkButton.setBounds(400,440, 350,30);


        checkButton.addActionListener(e->{
            String doctorname = (String) doctorList.getItemAt(doctorList.getSelectedIndex());
            searchDoctors(consultationList,doctorname, timeslot.getText(), doctorsList);
        });

        notify = new JLabel("",SwingConstants.CENTER);
        notify.setForeground(Color.red);
        notify.setBounds(0,583, 800,30);

        JSeparator line = new JSeparator();
        line.setBounds(0,390, 800,1);

        JSeparator bottomLline = new JSeparator();
        bottomLline.setBounds(0,505, 800,1);

        JSeparator notifyLline = new JSeparator();
        notifyLline.setBounds(0,580, 800,1);

        f.add(labelid); f.add(id);
        f.add(labelFname); f.add(fname);
        f.add(labelsname); f.add(sname);
        f.add(labelcontact); f.add(contact);
        f.add(labeldob); f.add(dob);
        f.add(submitButton);
        f.add(labeltimeslot); f.add(timeslot);
        f.add(labelcost); f.add(cost);
        f.add(labelnote); f.add(note);
        f.add(labelSelected);

        f.add(line); f.add(bottomLline); f.add(notifyLline);
        f.add(labelDoctor); f.add(doctorList);
        f.add(labelSelectedDoctor);
        f.add(checkButton);
        f.add(notify);

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

    private static boolean addPatient(ArrayList<Patient> dataList){
        boolean status = false;

        try{
            if(isDOBValid(dob.getText())){
                dataList.add(new Patient(fname.getText(), sname.getText(), dob.getText(),Integer.parseInt(contact.getText()), id.getText()));
                notify.setText("Patient: "+fname.getText()+" "+sname.getText()+" added successfully");
                status = true;
            }else{
                notify.setText(" Recheck the Date&Time format to verify it's [ dd/MM/yyyy]  ");
            }
        }catch (Exception e){
            notify.setText("Please enter valid inputs ");
        }

        return status;
    }

    private static void addConsultation(ArrayList<Consultation> consultationList){
        try {
            if(!labelSelectedDoctor.getText().equals("No available doctors")){
                if(isDateValid(timeslot.getText())){
                    consultationList.add(new Consultation(labelSelectedDoctor.getText(),(fname.getText()+" "+sname.getText()),timeslot.getText(), cost.getText(), note.getText()));
                    notify.setText(" Consultation scheduled for "+(fname.getText()+" "+sname.getText())+" on "+timeslot.getText());
                }else{
                    notify.setText(" Recheck the Date&Time format to verify it's [ dd/MM/yyyy HH:mm ]  ");
                }
            }else{
                notify.setText(" No available doctors for this time slot ");
            }
        }catch (Exception e){
            notify.setText(e.toString());
        }

    }

    private static void searchDoctors(ArrayList<Consultation> consultationList, String doctorName, String timeSlot , ArrayList<Doctor> doctorsList){
        String selectedDoctor = doctorName;
        if(!checkAvailability(consultationList,doctorName,timeSlot)){
            selectedDoctor = randomSelectDoctor(consultationList,doctorsList,timeSlot);
        }
        labelSelectedDoctor.setText(selectedDoctor);
    }

    private static String randomSelectDoctor(ArrayList<Consultation> consultationList,ArrayList<Doctor> doctorsList,String timeSlot){
        int randomNum = ThreadLocalRandom.current().nextInt(0, doctorsList.size());
        String tempDoc = doctorsList.get(randomNum).getfName()+" "+doctorsList.get(randomNum).getsName();
        int count = 0;

        while(!checkAvailability(consultationList, tempDoc ,timeSlot)){
            randomNum = ThreadLocalRandom.current().nextInt(0, doctorsList.size());
            tempDoc = doctorsList.get(randomNum).getfName()+" "+doctorsList.get(randomNum).getsName();
            if(count >= doctorsList.size()){
                tempDoc = "No available doctors";
                break;
            }
            count++;
        }
        return tempDoc;
    }

    private static boolean checkAvailability(ArrayList<Consultation> consultationList, String doctorName, String timeslot){
        Boolean status = true;
        for(Consultation consult:consultationList){
            if(consult.getDoctorName().equals(doctorName) && consult.getDate().equals(timeslot)){
                status = false;
                break;
            }
        }
        return status;
    }

    public static boolean isDateValid(String date){                          // Date Validation Method
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isDOBValid(String date){                          // Date Validation Method
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

