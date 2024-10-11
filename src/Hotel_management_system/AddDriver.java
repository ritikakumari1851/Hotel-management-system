package Hotel_management_system;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AddDriver extends JFrame implements ActionListener{
    JTextField tname, tage,tcar,tcarnum,tfLocation;
    JComboBox<String> gender,avl;
    JButton AD, cancel;
    
    
    AddDriver(){
        setBounds(160, 100, 1000, 490);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel AddDriver = new JLabel("Add Drivers");
        AddDriver.setBounds(130, 0, 110, 80);
        AddDriver.setFont(new Font("Serif", Font.BOLD, 17));
        AddDriver.setForeground(Color.BLACK);
        add(AddDriver);
        
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(50, 70, 100, 30);
        add(Lname);
        
       tname = new JTextField();
        tname.setBounds(200, 70, 150, 27);
        add(tname);
        
        
        JLabel Lage = new JLabel("Age");
        Lage.setBounds(50, 110, 100, 30);
        add(Lage);
        
        tage = new JTextField();
        tage.setBounds(200, 110, 150, 27);
        add(tage);
        
        JLabel LGender = new JLabel("Available");
        LGender.setBounds(50, 150, 100, 30);
        add(LGender);
        
           String str[] = {"Male", "Female"};
        gender = new JComboBox<>(str);
        gender.setBounds(200, 150, 150, 27);
        gender.setBackground(Color.WHITE);
        add(gender);
        
            JLabel car = new JLabel("CarModel");
        car.setBounds(50, 190, 100, 30);
        add(car);
        
        tcar = new JTextField();
        tcar.setBounds(200, 190, 150, 27);
        add(tcar);
        
            JLabel carnum = new JLabel("Car Number");
        carnum.setBounds(50, 230, 100, 30);
        add(carnum);
        
        tcarnum = new JTextField();
        tcarnum.setBounds(200, 230, 150, 27);
        add(tcarnum);
       
        
           JLabel Lavl = new JLabel("Available");
        Lavl.setBounds(50, 270, 100, 30);
        add(Lavl);
        

           String str1[] = {"Available", "Not Available"};
        avl = new JComboBox<>(str1);
        avl.setBounds(200, 270, 150, 27);
        avl.setBackground(Color.WHITE);
        add(avl);
        
            JLabel lbLocation = new JLabel("Location");
        lbLocation.setBounds(50, 310, 100, 30);
        add(lbLocation);
        
        tfLocation = new JTextField();
        tfLocation.setBounds(200, 310, 150, 27);
        add(tfLocation);
        
        
        
        AD = new JButton("Add Driver");
        AD.setBounds(50, 370, 135, 30);
        add(AD);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(210, 370, 135, 30);
        add(cancel);
        
        AD.addActionListener(this);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(410, 70, 520, 290);
        add(image);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==AD){
             String Name = tname.getText();
             String Age = tage.getText();
             String Gender = (String) gender.getSelectedItem();
             String Car = tcar.getText();
             String Car_no = tcarnum.getText();
             String available = (String) avl.getSelectedItem();
             String Location = tfLocation.getText();
             
             try{
                  Conn conn = new Conn();
                  String str = "insert into Driver values('" + Name + "','" + Age +"','"+ Gender +"','" + Car +"','" + Car_no+"','"+available+"','"+Location+"')";
                  conn.s.executeUpdate(str);
                  JOptionPane.showMessageDialog(null,"New Driver Added sucessfully");
                   setVisible(false);
             }
             catch(Exception er){
                 er.getStackTrace();
             }
         
         }else if(e.getSource()== cancel){
         setVisible(false);
     }
     }
    
    
    
    
        public static void main(String[] args) {
        new AddDriver();
    }
}
