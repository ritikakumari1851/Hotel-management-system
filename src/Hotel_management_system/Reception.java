package Hotel_management_system;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Reception extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    Reception(){
        setBounds(160, 100, 1000, 540);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
    b1= new JButton("New Customer Form");
        b1.setBounds(10,5,400,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        
        add(b1);
        
        
                 b2= new JButton("Room");
        b2.setBounds(10,45,400,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
        add(b2);
        
                 b3= new JButton("Department");
        b3.setBounds(10,85,400,35);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
          b3.addActionListener(this);
        add(b3);
        
        b4= new JButton("All Employee info");
        b4.setBounds(10,125,400,35);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
         b4.addActionListener(this);
        add(b4);
        
                 b5= new JButton("Customer Info");
        b5.setBounds(10,165,400,35);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
         b5.addActionListener(this);
        add(b5);
        
                 b6= new JButton("Manager info");
        b6.setBounds(10,205,400,35);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
         b6.addActionListener(this);
        add(b6);
        
                 b7= new JButton("Check out");
        b7.setBounds(10,245,400,35);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
            b7.addActionListener(this);
        add(b7);
        
                 b8= new JButton("Update status");
        b8.setBounds(10,285,400,35);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        add(b8);
        
                 b9= new JButton("Update Room Status");
        b9.setBounds(10,325,400,35);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
          b9.addActionListener(this);
        add(b9);
        
                 b10= new JButton("Pick up Service");
        b10.setBounds(10,365,400,35);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
          b10.addActionListener(this);
        add(b10);
        
                 b11= new JButton("Search Room");
        b11.setBounds(10,405,400,35);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        add(b11);
    
        
                 b12= new JButton(" LogOut ");
        b12.setBounds(10,445,400,35);
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        add(b12);
    
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(440,10, 510,470);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
            setVisible(false);
            new CustomerForm();
        }else if(ae.getSource()== b2){
            setVisible(false);
            new Allrooms();
        }else if(ae.getSource()== b3){
            setVisible(false);
            new Department();
        }else if(ae.getSource()==b4){
            setVisible(false);
            AllEmployes.open();
        }else if(ae.getSource()==b5){
            setVisible(false);
            new Customerinfo();
        }else if(ae.getSource()==b6){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==b11){
            setVisible(false);
            new SearchRoom();

        }else if(ae.getSource()==b8){
            setVisible(false);
            new Updatecheckout();
        }else if(ae.getSource()==b7){
            setVisible(false);
            new checkout();
        }else if(ae.getSource()==b10){
            setVisible(false);
            new Drivers();      
        }else if(ae.getSource()==b9){
            setVisible(false);
            new Roomstatus();
    }else if (ae.getSource() == b12) {  // LogOut button action
            setVisible(false);  // Close the reception window
            new Hotel_management_system();  // Open the home window
        }
    }
    
    
        public static void main(String[] args) {
        new Reception();
    }
}

