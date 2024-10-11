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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JRadioButton check;
    
    SearchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       JLabel text = new JLabel("Search For Room");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(400,30,200,30);
       add(text);
        
       JLabel lbed = new JLabel("Bed Type");
        lbed.setBounds(50,100,100,20);
       add(lbed);
       
       bedtype = new JComboBox(new String[]{"Single size","Double size","King size","Queen Size"});
       bedtype.setBounds(150,100,150,25);
       bedtype.setBackground(Color.WHITE);
       add(bedtype);
       
       check = new JRadioButton("Only Display Available");
       check.setBounds(650,100,150,25);
       check.setBackground(Color.WHITE);
         check.setFont(new Font("Tahoma",Font.BOLD,10));
       add(check);
       
       
       
                JLabel l1= new JLabel("Room No");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        
        
        
        JLabel l2= new JLabel("Availablilty");
        l2.setBounds(270,160,100,20);
        add(l2);
     
              JLabel l3= new JLabel("Cleaning stus");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        
        
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
     
              JLabel l5= new JLabel("Bed Size");
        l5.setBounds(800,160,100,20);
        add(l5);
        
        
        
        
     
        
        table = new JTable();
        table.setBounds(0,200,1000,200);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from room");
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        
        back.setBounds(300, 400, 120, 30);
        add(back);
        
        back.addActionListener(this);
        
          submit = new JButton("Submit");
        
        submit.setBounds(500, 400, 120, 30);
        add(submit);
        
        submit.addActionListener(this);
        
        setBounds(300,100,900,500);
        
        setVisible(true);
        
        
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
               String query1= "Select *from room where bedsize ='"+bedtype.getSelectedItem()+"'";
                String query2= "Select *from room where available= 'Avaialble' AND bedsize ='"+bedtype.getSelectedItem()+"'";
            
                Conn conn = new Conn();
                ResultSet rs;
                if(check.isSelected()){
                    rs = conn.s.executeQuery(query2);
                    
                }else{
                    rs= conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
          
            } catch(Exception e){
                e.printStackTrace();
                }
            } else{
            setVisible(false);
            new Reception();
                    }
        

    }
    
    
    
        public static void main(String[] args){
        new SearchRoom();
}
}
