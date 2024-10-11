package Hotel_management_system;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Allrooms extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Allrooms(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(440, 10, 510, 430);
        add(image);
        
                JLabel l1= new JLabel("Room No");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        
        
        
        JLabel l2= new JLabel("Availablilty");
        l2.setBounds(80,10,100,20);
        add(l2);
     
              JLabel l3= new JLabel("Cleaning stus");
        l3.setBounds(160,10,100,20);
        add(l3);
        
        
        
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(250,10,100,20);
        add(l4);
     
              JLabel l5= new JLabel("Bed Size");
        l5.setBounds(320,10,100,20);
        add(l5);
        
        
        
        
     
        
        table = new JTable();
        table.setBounds(0,40,400,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        
        back.setBounds(100, 420, 135, 30);
        add(back);
        
        back.addActionListener(this);
        
        setBounds(300,100,900,500);
        
        setVisible(true);
        
        
}
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }
    
    
    
        public static void main(String[] args){
        new Allrooms();
}
}
