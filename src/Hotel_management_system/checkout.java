package Hotel_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class checkout extends JFrame implements ActionListener {
    JButton search, Update, Cancel,checkout;
    JLabel lroom, lname, LTime, ldue;
    JTextField Tph, Tco;

    checkout() {
        // Frame settings
        setBounds(180, 50, 900, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title label
        JLabel lb1 = new JLabel("Check Out");
        lb1.setBounds(150, 10, 300, 50);
        lb1.setForeground(Color.BLUE);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1);

        JLabel id = new JLabel("IDENTIFICATION NO");
        id.setBounds(20,100, 150, 40);
        add(id);

        Tph = new JTextField();
        Tph.setBounds(150, 100, 150, 25);
        add(Tph);

        JLabel Lroom = new JLabel("Room No:");
        Lroom.setBounds(20, 150, 100, 30);
        add(Lroom);

        JLabel Lname = new JLabel("NAME:");
        Lname.setBounds(20, 190, 100, 30);
        add(Lname);

        JLabel Ltime = new JLabel("Check in time:");
        Ltime.setBounds(20, 230, 100, 30);
        add(Ltime);

        JLabel LCheckout = new JLabel("Checkout Time");
        LCheckout.setBounds(20, 270, 100, 30);
        add(LCheckout);
        
        JLabel Ldue = new JLabel("Amount Due");
        Ldue.setBounds(20, 310, 100, 30);
        add(Ldue);
      
        Tco = new JTextField();
        Tco.setBounds(150, 270, 150, 25);
        add(Tco);

        lroom = new JLabel();
        lroom.setBounds(150, 150, 150, 30);
        add(lroom);

        lname = new JLabel();
        lname.setBounds(150, 190, 150, 30);
        add(lname);

        LTime = new JLabel();
        LTime.setBounds(150, 230, 180, 50);
        add(LTime);

        ldue = new JLabel();
        ldue.setBounds(150, 310, 150, 30);
        add(ldue);

        search = new JButton("Search");
        search.setFont(new Font("Tahoma", Font.PLAIN, 10));
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.setBounds(320, 100, 70, 25);
        search.addActionListener(this);
        add(search);

        Update = new JButton("UPDATE");
        Update.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Update.setForeground(Color.WHITE);
        Update.setBackground(Color.BLACK);
        Update.setBounds(320, 270, 70, 25);
        Update.addActionListener(this);
        add(Update);

         checkout = new JButton("Check Out");
        checkout.setFont(new Font("Tahoma", Font.PLAIN, 10));
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(50,400, 100, 30);
        checkout.addActionListener(this);
        add(checkout);

        
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.BLACK);
        Cancel.setBounds(200, 400, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.png"));
        Image i2 = i1.getImage().getScaledInstance(520, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(440, 60, 520, 350);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
         String id = Tph.getText();
         String dname= lname.getText();
         String droom= lroom.getText();
         String dtime= LTime.getText();
         String ddue= ldue.getText();
         String cout;
         
        if (ae.getSource() == search) {
            
            try {
                Conn conn = new Conn();

                // First query to get customer details
                String query = "SELECT * FROM customer WHERE num = '" + id + "'";
                
                ResultSet rs = conn.s.executeQuery(query);
                

                    // Second query to get room price
                    String query2 = "SELECT * FROM due WHERE id = '" + Tph.getText() + "'";
                    ResultSet r1 = conn.s2.executeQuery(query2);

                    if (r1.next()) {
                        ldue.setText(r1.getString("dues"));
                        
                      
                 
                if (rs.next()) {
                    lroom.setText(rs.getString("room"));
                    lname.setText(rs.getString("name"));
                    LTime.setText(rs.getString("time"));
                
                } else {
                    lroom.setText("Room not found");
                }
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ae.getSource() == Update) {
            try {
                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedNow = now.format(formatter);

                // Set the checkout time in the text field
                Tco.setText(formattedNow);
                
                // Optionally, you can update the checkout time in the database if needed
                // For example:
                // String query = "UPDATE bookings SET checkout_time = '" + formattedNow + "' WHERE id = '" + id + "'";
                // conn.s.executeUpdate(query);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         cout= Tco.getText();
        
        if (ae.getSource() == checkout) {
             int dueamt= Integer.parseInt(ldue.getText());
              Conn conn = new Conn();
            if(dueamt==0){
                String insertQuery = "INSERT INTO oldcustomers VALUES ('" +id+ "', '" + droom + "','" +dtime+ "','" +cout+ "','" +ddue+ "','" +dname+ "')";
                 String qury = "Delete from customer where num= '"+id+"'"; 
                try {
                     conn.s.executeUpdate(insertQuery);  // Execute the insert query
                     conn.s.executeUpdate(qury);
                      JOptionPane.showMessageDialog(null, "Cheked out Successfully");
                      
                      setVisible(false);
                      new Reception();
                 } catch (SQLException ex) {
                     Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
                     
                 }
                 
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Amount is Due ! Checkout After Clearing the Account");
            }

        }

        else if (ae.getSource() == Cancel) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new checkout();
        
    }
}
