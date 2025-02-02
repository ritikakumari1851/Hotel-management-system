package Hotel_management_system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField username, password;
    JButton login,cancel;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,40,100,30);
        add(user);
        
        
         username = new JTextField();
        username.setBounds(150,40,150,30);
        add(username);
        
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,80,200,30);
        add(pass);
        
        
       password = new JTextField();
        add(password);
        password.setBounds(150,80,150,30);
        
         login = new JButton("LOGIN");
        login.setBounds(40,160,120,30);
        login.addActionListener (this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(180,160,120,30);
         cancel.addActionListener (this);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        
        image.setBounds(350,10,200,200);
        add(image);
        setBounds(350,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
           String user= username.getText();
           String pass= password.getText();
           
           try{
               Conn c = new Conn();
               
               String query = "select * from login where username = '"+user+ "'and password='"+pass +"'";
               
              ResultSet rs = c.s.executeQuery(query);
           
           
           if (rs.next()){
               setVisible(false);
               new Dashboard();
           } 
           else{
               JOptionPane.showMessageDialog(null,"Invalid username or password");
               setVisible(false);
           }
           
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else if(ae.getSource()== cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}

