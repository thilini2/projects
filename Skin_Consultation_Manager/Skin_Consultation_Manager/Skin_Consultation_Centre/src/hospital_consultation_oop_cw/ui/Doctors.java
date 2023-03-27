package hospital_consultation_oop_cw.ui;

import hospital_consultation_oop_cw.models.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Doctors {
    private static JFrame f;
    private static JButton AscendingButton;
    private static JButton DescendingButton;

    public Doctors(ArrayList<Doctor> dataTable, Object e){
        f=new JFrame();
        f.setLayout(new BorderLayout(30,35));
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));
        displayTable(dataTable,e);
    }

    public static void displayTable(ArrayList<Doctor> dataTable, Object source){

        DisplayExitButton(f);       // adding exit method

        AscendingButton=new JButton("Ascending");
        AscendingButton.setBackground(Color.black);
        AscendingButton.setForeground(Color.white);

        DescendingButton=new JButton("Descending");
        DescendingButton.setBackground(Color.black);
        DescendingButton.setForeground(Color.white);

        AscendingButton.setBounds(40,30,150,30);
        DescendingButton.setBounds(200,30,150,30);

        f.add(DescendingButton,BorderLayout.NORTH);
        f.add(AscendingButton,BorderLayout.NORTH);

        String column[]={"First Name","Last Name","Date of birth","Doctor License","Contact","Specialisation"};  // table column
        JButton pressed = (JButton) source;
        String[][] rowdata= new String[dataTable.size()][];

        for (int i = 0; i < dataTable.size(); i++) {
            Doctor doctor = (Doctor) dataTable.get(i);
            rowdata[i] = new String[]{doctor.getfName(), doctor.getsName(), doctor.getDob(), String.valueOf(doctor.getmLicence()), String.valueOf(doctor.getContact()), String.valueOf(doctor.getSpecialisation())};  // table data
        }

        DefaultTableModel tableModel = new DefaultTableModel(rowdata,column); // adding table date model to table

        AscendingButton.addActionListener(e->{
            String[][] data = Ascending(dataTable);             // calling sorting method for the table
            tableModel.setDataVector(data,column);
        });

        DescendingButton.addActionListener(e->{
            String[][] data = Desending(dataTable);            // calling sorting method for the table
            tableModel.setDataVector(data,column);
        });

        JTable jt=new JTable(tableModel);
        JScrollPane sp=new JScrollPane(jt);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jt.getColumn("First Name").setCellRenderer( rightRenderer );
        jt.getColumn("Last Name").setCellRenderer( rightRenderer );
        jt.getColumn("Date of birth").setCellRenderer( rightRenderer );
        jt.getColumn("Doctor License").setCellRenderer( rightRenderer );
        jt.getColumn("Contact").setCellRenderer( rightRenderer );
        jt.getColumn("Specialisation").setCellRenderer( rightRenderer );
        sp.setBounds(40,80,705,300);
        f.add(sp,BorderLayout.CENTER);

        f.setSize(800,500);
        f.setTitle("Hospital Manager");
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private static String[][] Ascending(ArrayList<Doctor> dataTable){            // Ascending from bubble sort

        if(dataTable.size() > 0) {
            dataTable.sort(new Comparator<Doctor>() {
                @Override
                public int compare(Doctor doctor1, Doctor doctor2) {
                    return doctor1.getsName().compareToIgnoreCase(doctor2.getsName());
                }
            });
        }else{
            System.out.println("-------------- No doctors available -----------------");
        }

        String[][] data = new String[dataTable.size()][4];
        int counter = 0;
        for(Doctor doctor : dataTable) {
            data[counter] = new String[]{doctor.getfName(), doctor.getsName(), doctor.getDob(), String.valueOf(doctor.getmLicence()), String.valueOf(doctor.getContact()), String.valueOf(doctor.getSpecialisation())};
            counter++;
        }
        return data;

    }

    private static String[][] Desending(ArrayList<Doctor> dataTable){

        if(dataTable.size() > 0) {
            dataTable.sort(new Comparator<Doctor>() {
                @Override
                public int compare(Doctor doctor1, Doctor doctor2) {
                    return -doctor1.getsName().compareToIgnoreCase(doctor2.getsName());
                }
            });
        }else{
            System.out.println("-------------- No doctors available -----------------");
        }

        String[][] data = new String[dataTable.size()][4];
        int counter = 0;
        for(Doctor doctor:dataTable) {
            data[counter] = new String[]{doctor.getfName(), doctor.getsName(), doctor.getDob(), String.valueOf(doctor.getmLicence()), String.valueOf(doctor.getContact()), String.valueOf(doctor.getSpecialisation())};
            counter++;
        }
        return data;
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
}
