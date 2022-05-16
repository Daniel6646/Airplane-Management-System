package airline.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 
        
        //to get the image,and put it on the frame
        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/Iconss/front.jpg")));
	NewLabel.setBounds(0, 0, 1920, 990); //x(LEFT TO RIGHT),y(top to bottom),lenght,breadth.
	add(NewLabel); //add to the frame
        
        JLabel AirlineManagementSystem = new JLabel("AIR INDIA WELCOMES YOU");
	AirlineManagementSystem.setForeground(Color.BLUE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	AirlineManagementSystem.setBounds(700, 60, 1000, 55);//x,y,len,breadthh
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();// this is the menu BAR,it has menu inside airline system on click it will display menu items as below 5
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");//one menu name, has 5 menU items as below
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
    JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");//after u click on abovr airline sys option a list come where this all 5 options will be available
	AirlineSystem.add(FlightDetails);
		
	JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");//menu item
	AirlineSystem.add(ReservationDetails);
		
	JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");//menu item
	AirlineSystem.add(PassengerDetails);
		
	JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");//menu item
	AirlineSystem.add(SectorDetails_1);
		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
		
	JMenu Ticket = new JMenu("TICKET");//menu see image for more ref or project video airline mangmt system
        Ticket.setForeground(Color.RED);//set background for background,foreground to set characters in some color
	menuBar.add(Ticket);
		
        JMenu List = new JMenu("LIST"); //menu
        List.setForeground(Color.BLUE);
	menuBar.add(List);
		
	JMenu Misc = new JMenu("MISC"); //menu
        Misc.setForeground(Color.RED);
	menuBar.add(Misc);
        
		
	FlightDetails.addActionListener(new ActionListener(){

		
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();//whenever we click on things it should perform a function so we use actionevent,when we click on flight info it calls and creates object of flight info and opens the frame m,code written in class
            }//when u do .addactionListener error add umimplemented method and then comes actionPerformed method

			
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
		
        setSize(1950,1090);
	setVisible(true);
    }
}
