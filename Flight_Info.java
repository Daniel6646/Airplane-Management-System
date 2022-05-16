package airline.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Flight_Info().setVisible(true);    //code and call to constructor
    }
    
    public Flight_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");//enter the code and shows details for all the colums needed
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select f_code,f_name,src,dst,capacity,class_code,class_name from flight ,sector where f_code = '"+code+"'";
      //first 4 colum from flight table,last 3 from sector table, in textfield we will add code which we fetch above where f_code =
                    ResultSet rs = c.s.executeQuery(str);// what is this ss..??
                    table.setModel(DbUtils.resultSetToTableModel(rs));// to set data in model,when we use table.setModel it willl convert the data into table format and display it	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }//from try to here, we fetch data from database and enter into the table.
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();// to show data in the table,this will display the table
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);//scrollpane gives scrollbar in the table
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightCode = new JLabel("FLIGHT CODE");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        FlightCode.setBounds(23, 220, 126, 14);
	add(FlightCode);
		
	JLabel FlightName = new JLabel("FLIGHT NAME");
        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightName.setBounds(145, 220, 120, 14);
	add(FlightName);
		
	JLabel Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(275, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(367, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("CAPACITY");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(497, 220, 111, 14);
	add(Capacity);
		
	JLabel ClassCode = new JLabel("CLASS CODE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassCode.setBounds(587, 220, 120, 14);
	add(ClassCode);
		
	JLabel ClassName = new JLabel("CLASS NAME");
	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassName.setBounds(700, 220, 111, 14);
	add(ClassName);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//size and all of frame
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
