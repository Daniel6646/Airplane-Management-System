package airline.management.system;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{

	TextField t1,t2;
    Label l1,l2;
    Button b2,b3,b4;
    GridBagLayout gbl;  //Layout
    GridBagConstraints gbc; 
    Font f1,f2;
	
	

    public Login(){
        super("Login"); //when u execute,Login written at top of frame is due to this super
    
        setBackground(Color.WHITE); //this for frame background color,setForegroundColor(Color.RED);- foreground is to set color of the text 
        f1 = new Font("TimesRoman",Font.BOLD,20); // 20 -Textsize
        f2 = new Font("TimesRoman",Font.BOLD,15);
		
        gbl=new GridBagLayout(); //predefined layout //if dont want gridbag and want custom layout use this two lines ahead- setLayout(null) setBounds(x,y,length,breadth)
    	gbc=new GridBagConstraints();
            setLayout(gbl); //setLayout(new FlowLayout)
    

            l1 = new Label("Username");// name of the label which will be displayed in frame
            l1.setFont(f1);
    	
            l2 = new Label("Password");
            l2.setFont(f1);

            t1 = new TextField(15); 
        	t2 = new TextField(15); //JPasswordField field = new JPasswordField(); so no need of this and below line 
            t2.setEchoChar('*');//PASWORD-ADMIN it makes it look like PASSWORD-*****
    
            b2 = new Button("Reset");//quote in doublee quotes will be displayed on button
            b2.setFont(f2);
        		
            b3 = new Button("Submit");
            b3.setFont(f2);
        		
            b4 = new Button("Close");
            b4.setFont(f2);
    
            gbc.gridx=0;
        	gbc.gridy=0; 
            gbl.setConstraints(l1,gbc);//execute and see how each labels,texts are arranged acc to x and y ordinates xleft to right, y top to bottom.
        	add(l1);
                
        	gbc.gridx=2;
                gbc.gridy=0;
        	gbl.setConstraints(t1,gbc);
                add(t1);
        		
        	gbc.gridx=0;
                gbc.gridy=2;
        	gbl.setConstraints(l2,gbc);
                add(l2);

        	gbc.gridx=2;
                gbc.gridy=2;
                gbl.setConstraints(t2,gbc);
        	add(t2);
        				
        	
        	gbc.gridx=0;
                gbc.gridy=8;
        	gbl.setConstraints(b2,gbc);
                add(b2);

                gbc.gridx=2;
        	gbc.gridy=8;
                gbl.setConstraints(b3,gbc);
        	add(b3);
        	
                gbc.gridx=4;
        	gbc.gridy=8;
                gbl.setConstraints(b4,gbc);
        	add(b4);
                

                b2.addActionListener(this);
                b3.addActionListener(this);
        	b4.addActionListener(this);
                        
                setVisible(true);   //by default false,if false wont be visible
                setSize(400,250); //for the frame 400-x axis,250-y axis x starts from left-right , y from top to bottom
                setLocation(400,200);//it will display at a location 400 from x axis start from left to right and 200 from y axis
            
    }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b2){
	          
            t1.setText("");  //getText another mehtod one to set one to get
            t2.setText(""); 
	}
        if(ae.getSource()==b4){
            System.exit(0); //project close or terminate
	}
        
        if(ae.getSource()==b3){
            try{
                conn c1 = new conn();
                
                String s1 = t1.getText();
                String s2 = t2.getText();
            
                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet rs = c1.s.executeQuery(str);  //whenever we have to execute query have to use preparestmt or staement so here c1 is conn clase statement inside conn class so c1.s.executeQuery(str);
                
                if(rs.next()){
                    new Mainframe();
                    setVisible(false);//here makes curent login frame to close
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false); //hode login frame so false
                }
            
            }catch(Exception e){}
            
	}
    	} 
        
		
	 public static void main(String[] args){
         new Login();
 }

}
