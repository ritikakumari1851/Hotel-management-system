package Hotel_management_system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class CustomerForm extends JFrame implements ActionListener{
    
    JTextField tno, tcountry, tname, tdeposite, tduration,Tphone;
    JRadioButton btn1, btn2;
    JButton Ac, cancel;
    JComboBox Id;
    Choice croom;
    JLabel checkintime;
    
    CustomerForm() {
        // Set layout to null for absolute positioning
        setLayout(null);
        
        // Setting the frame's size and background color
        setBounds(250,50,800, 600);
        getContentPane().setBackground(Color.WHITE);

        // Adding the "New Customer Form" label
        JLabel Customer = new JLabel("NEW CUSTOMER FORM");
        Customer.setBounds(100, 20, 300, 20);  // Adjusted width for visibility
        Customer.setForeground(Color.BLACK);
        Customer.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(Customer);

        // Adding the label for ID selection
        JLabel LId = new JLabel("ID");
        LId.setBounds(50, 90, 100, 30);  // Set appropriate position for the label
        add(LId);

        // Adding the ComboBox for ID options
        String str1[] = { "Passport", "Voter ID", "Driving License", "Adhar Card", "PAN Card", "Membership Card" };
        Id = new JComboBox(str1);
        Id.setBounds(160, 90, 200, 27);  // Positioned right next to the label
        Id.setBackground(Color.WHITE);
        add(Id);

        // Adding the label for Number
        JLabel Lno = new JLabel("Number");
        Lno.setBounds(50, 140, 100, 30);  // Set appropriate position for the label
        add(Lno);
        
        tno = new JTextField();
        tno.setBounds(160, 140, 200, 27);
        add(tno);

        // Adding the label for Name
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(50, 180, 100, 30);  // Set appropriate position for the label
        add(Lname);
        
        tname = new JTextField();
        tname.setBounds(160, 180, 200, 27);
        add(tname);

        // Adding the label for Gender
        JLabel lGender = new JLabel("Gender");
        lGender.setBounds(50, 220, 100, 30);
        lGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lGender);

        btn1 = new JRadioButton("Male");
        btn1.setBounds(160, 220, 70, 30);
        btn1.setFont(new Font("Tahuma", Font.BOLD, 14));
        btn1.setBackground(Color.WHITE);
        add(btn1);

        btn2 = new JRadioButton("Female");
        btn2.setBounds(240, 220, 90, 30);
        btn2.setFont(new Font("Tahuma", Font.BOLD, 14));
        btn2.setBackground(Color.WHITE);
        add(btn2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(btn1);
        bg.add(btn2);

        // Adding the label for Country
        JLabel LCountry = new JLabel("Country");
        LCountry.setBounds(50, 260, 100, 30);  // Set appropriate position for the label
        add(LCountry);
        
        tcountry = new JTextField();
        tcountry.setBounds(160, 260, 200, 27);
        add(tcountry);

        // Adding the label for Room No
        JLabel Lroom = new JLabel("Room no");
        Lroom.setBounds(50, 300, 100, 30);  // Set appropriate position for the label
        add(Lroom);
        
        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query = "Select * from room where available = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomNumber"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
croom.setBounds(160, 300, 200, 40); // Change the y-coordinate to match the label "Room no"
        add(croom);

        // Adding the label for Check-in Time
        JLabel Ltime = new JLabel("Checkin Time");
        Ltime.setBounds(50, 340, 100, 30);  // Set appropriate position for the label
        add(Ltime);
        
        Date date = new Date();
        checkintime = new JLabel(" " + date);
        checkintime.setBounds(160, 340, 200, 30);
        add(checkintime);

        // Adding the label for Deposit
        JLabel Ldeposite = new JLabel("Deposit");
        Ldeposite.setBounds(50, 380, 100, 30);  // Set appropriate position for the label
        add(Ldeposite);
        
        tdeposite = new JTextField();
        tdeposite.setBounds(160, 380, 200, 27);
        add(tdeposite);

        // Adding the label for Duration
        JLabel Lduration = new JLabel("Duration");
        Lduration.setBounds(50, 420, 100, 30);  // Set appropriate position for the label
        add(Lduration);
        
        tduration = new JTextField();
        tduration.setBounds(160, 420, 200, 27);
        add(tduration);
        
         JLabel LPhone = new JLabel("Contact no:");
        LPhone.setBounds(50, 460, 100, 30);  // Set appropriate position for the label
        add(LPhone);
        
         Tphone = new JTextField();
        Tphone.setBounds(160, 460, 200, 27);
        add(Tphone);

        // Adding the "Add Customer" and "Cancel" buttons
        Ac = new JButton("Add Customer");
        Ac.setBounds(50, 510, 135, 30);
        add(Ac);

        cancel = new JButton("Cancel");
        cancel.setBounds(210, 510, 135, 30);
        add(cancel);

        // Adding action listeners to the buttons
        Ac.addActionListener(this);
        cancel.addActionListener(this);

        // Adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(320, 10, 510, 430);
        add(image);

        // Set layout and visibility
        setLayout(null); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Ac){
            String ID = (String) Id.getSelectedItem();
            String num = tno.getText();
            String name = tname.getText();
            String gender = null;
            
            if(btn1.isSelected()){
                gender = "Male";
            } else if(btn2.isSelected()){
                gender = "Female";
            }

            String Country = tcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tdeposite.getText();
            String duration = tduration.getText();
            String phone = Tphone.getText();
            
            try{
                Conn conn = new Conn();
                String qur = "insert into customer values('" + ID + "','" + num + "','" + gender + "','" + Country + "','" + room + "','" + time + "','" + deposite + "','" + duration + "','" + name + "','"+phone+"')";
                String qur2 = "update room set available = 'Not available' where roomNumber = '" + room + "'"; 
                
                conn.s.executeUpdate(qur);
                conn.s.executeUpdate(qur2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added successfully");
                setVisible(false);
                new Reception();
                
            } catch(Exception er){
                er.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CustomerForm();
    }
}
