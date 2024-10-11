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

public class AddRooms extends JFrame implements ActionListener{
    JTextField troom, tprice;
    JComboBox<String> avl, cs, bs;
    JButton AR, cancel;
    
    AddRooms(){
        setBounds(250, 100, 800, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel AddRoom = new JLabel("Add Rooms");
        AddRoom.setBounds(150, 0, 90, 80);
        AddRoom.setFont(new Font("Serif", Font.BOLD, 15));
        AddRoom.setForeground(Color.BLACK);
        add(AddRoom);
        
        JLabel Lroom = new JLabel("Room Number");
        Lroom.setBounds(50, 90, 100, 30);
        add(Lroom);
        
        troom = new JTextField();
        troom.setBounds(200, 90, 150, 25);
        add(troom);
        
        JLabel Lavl = new JLabel("Available");
        Lavl.setBounds(50, 130, 100, 30);
        add(Lavl);
        
        String str[] = {"Available", "Not Available"};
        avl = new JComboBox<>(str);
        avl.setBounds(200, 130, 150, 25);
        avl.setBackground(Color.WHITE);
        add(avl);
        
        JLabel Lcs = new JLabel("Cleaning Status");
        Lcs.setBounds(50, 180, 100, 30);
        add(Lcs);
        
        String str2[] = {"Cleaned", "Dirty", "Half Cleaned"};
        cs = new JComboBox<>(str2);
        cs.setBounds(200, 180, 150, 25);
        cs.setBackground(Color.WHITE);
        add(cs);
        
        JLabel Lprice = new JLabel("Price");
        Lprice.setBounds(50, 220, 100, 30);
        add(Lprice);
        
        tprice = new JTextField();
        tprice.setBounds(200, 220, 150, 25);
        add(tprice);
        
        JLabel Lbs = new JLabel("Bed Size");
        Lbs.setBounds(50, 260, 100, 30);
        add(Lbs);
        
        String str3[] = {"Single size", "Double size", "King Size", "Queen Size"};
        bs = new JComboBox<>(str3);
        bs.setBounds(200, 260, 150, 25);
        bs.setBackground(Color.WHITE);
        add(bs);
        
        AR = new JButton("Add Room");
        AR.setBounds(50, 320, 150, 30);
        AR.setForeground(Color.WHITE);
        AR.setBackground(Color.BLACK);
        add(AR);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 320, 150, 30);
         cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        add(cancel);
        
        AR.addActionListener(this);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bed.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(400, 60, 400, 300);
        add(image);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AR) {
            // Handle adding the room
            String roomNumber = troom.getText();
            String available = (String) avl.getSelectedItem();
            String cleaningStatus = (String) cs.getSelectedItem();
            String price = tprice.getText();
            String bedSize = (String) bs.getSelectedItem();
            try{
                Conn conn = new Conn();
                String str = "insert into room values('" + roomNumber + "','" + available +"','"+ cleaningStatus +"','" + price +"','" + bedSize+"')";
            conn.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Room Added sucessfully");
            setVisible(false);
            new Dashboard();
           
            }
           catch (Exception er) {
    er.printStackTrace();
}
            
            
        
        } else if (e.getSource() == cancel) {
            setVisible(false);
            
// Closes the window
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
}
