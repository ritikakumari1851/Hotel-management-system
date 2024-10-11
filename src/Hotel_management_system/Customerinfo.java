package Hotel_management_system;
import javax.swing.JFrame;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Customerinfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1= new JLabel("Document");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        
        
        
        JLabel l2= new JLabel("ID");
        l2.setBounds(130,10,100,20);
        add(l2);
     
              JLabel l3= new JLabel("GENDER");
        l3.setBounds(220,10,100,20);
        add(l3);
        
        
        
        
        JLabel l4= new JLabel("COUNTRY");
        l4.setBounds(350,10,100,20);
        add(l4);
     
              JLabel l5= new JLabel("ROOM");
        l5.setBounds(450,10,100,20);
        add(l5);
        
        
        
        
        JLabel l6= new JLabel("Checkin TIME");
        l6.setBounds(550,10,100,20);
        add(l6);
     
              JLabel l7= new JLabel("DEPOSITE");
        l7.setBounds(670,10,100,20);
        add(l7);
        
        
        
        
        JLabel l8= new JLabel("DURATION");
        l8.setBounds(780,10,100,20);
        add(l8);
          JLabel l9= new JLabel("NAME");
        l9.setBounds(880,10,100,20);
        add(l9);
       JLabel l10= new JLabel("Contact no:");
        l10.setBounds(990,10,100,20);
        add(l10);
        
        
        
        table = new JTable();
        table.setBounds(0,40,1100,300);
        table.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        
        back.setBounds(450, 420, 135, 30);
        add(back);
        
        back.addActionListener(this);
        
        setBounds(100,100,1100,500);
        
        setVisible(true);
        
        
}
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }
    
    
    
        public static void main(String[] args){
        new Customerinfo();
}
}
