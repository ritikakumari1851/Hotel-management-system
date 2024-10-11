package Hotel_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Updatecheckout extends JFrame implements ActionListener {
    JButton search, ClearAc, Update, Cancel;
    JLabel lroom, lname, LTime, Ldur, Lpy, lPaid, Ldue;
    JTextField Tph, Tclear;
    JComboBox<String> cid;

    int dueAmount = 0;  // Track due amount for calculations

    Updatecheckout() {
        // Frame settings
        setBounds(150, 30, 1000, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title label
        JLabel lb1 = new JLabel("Update Status");
        lb1.setBounds(110, 10, 300, 50);
        lb1.setForeground(Color.BLUE);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1);

        JLabel lid = new JLabel("IDENTIFICATION ID");
        lid.setBounds(20, 80, 150, 40);
        add(lid);
        
        cid = new JComboBox<>(new String[]{"Passport", "Voter ID", "Driving License", "Adhar Card", "PAN Card", "Membership Card"});
        cid.setBounds(150, 100, 150, 25);
        cid.setBackground(Color.WHITE);
        add(cid);

        JLabel id = new JLabel("IDENTIFICATION NO");
        id.setBounds(20, 140, 150, 40);
        add(id);

        Tph = new JTextField();
        Tph.setBounds(150, 150, 150, 25);
        add(Tph);

        JLabel Lroom = new JLabel("Room No:");
        Lroom.setBounds(20, 200, 100, 30);
        add(Lroom);

        JLabel Lname = new JLabel("NAME:");
        Lname.setBounds(20, 250, 100, 30);
        add(Lname);

        JLabel Ltime = new JLabel("Check in time:");
        Ltime.setBounds(20, 300, 100, 30);
        add(Ltime);

        JLabel LDuration = new JLabel("Checkout After: ");
        LDuration.setBounds(20, 350, 100, 30);
        add(LDuration);

        JLabel LPay = new JLabel("Amount to be paid:");
        LPay.setBounds(20, 400, 150, 30);
        add(LPay);

        JLabel Lpaid = new JLabel("Amount paid:");
        Lpaid.setBounds(20, 450, 100, 30);
        add(Lpaid);

        JLabel Ldues = new JLabel("Due");
        Ldues.setBounds(20, 500, 100, 30);
        add(Ldues);

        Ldue = new JLabel("");
        Ldue.setBounds(150, 500, 100, 30);
        add(Ldue);

        JLabel Lclearac = new JLabel("Deposite");
        Lclearac.setBounds(20, 550, 100, 30);
        add(Lclearac);

        Tclear = new JTextField();
        Tclear.setBounds(150, 550, 150, 25);
        add(Tclear);

        lroom = new JLabel();
        lroom.setBounds(150, 200, 150, 30);
        add(lroom);

        lname = new JLabel();
        lname.setBounds(150, 250, 150, 30);
        add(lname);

        LTime = new JLabel();
        LTime.setBounds(150, 300, 180, 50);
        add(LTime);

        Ldur = new JLabel();
        Ldur.setBounds(150, 350, 150, 30);
        add(Ldur);

        Lpy = new JLabel();
        Lpy.setBounds(150, 400, 150, 30);
        add(Lpy);

        lPaid = new JLabel();
        lPaid.setBounds(150, 450, 150, 30);
        add(lPaid);

        search = new JButton("Search");
        search.setFont(new Font("Tahoma", Font.PLAIN, 10));
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.setBounds(320, 150, 70, 25);
        search.addActionListener(this);
        add(search);

        ClearAc = new JButton("Clear Account");
        ClearAc.setFont(new Font("Tahoma", Font.PLAIN, 10));
        ClearAc.setForeground(Color.WHITE);
        ClearAc.setBackground(Color.BLACK);
        ClearAc.setBounds(310, 550, 100, 25);
        ClearAc.addActionListener(this);
        add(ClearAc);

        Update = new JButton("UPDATE");
        Update.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Update.setForeground(Color.WHITE);
        Update.setBackground(Color.BLACK);
        Update.setBounds(600, 550, 100, 30);
        Update.addActionListener(this);
        add(Update);

        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.BLACK);
        Cancel.setBounds(720, 550, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(500, 90, 400, 350);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String id = Tph.getText();
            try {
                Conn conn = new Conn();

                // First query to get customer details
                String query = "SELECT * FROM customer WHERE num = '" + id + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    lroom.setText(rs.getString("room"));
                    lname.setText(rs.getString("name"));
                    LTime.setText(rs.getString("time"));
                    Ldur.setText(rs.getString("duration"));
                    lPaid.setText(rs.getString("deposite"));

                    String rm = rs.getString("room");

                    // Second query to get room price
                    String query2 = "SELECT * FROM room WHERE roomNumber = '" + rm + "'";
                    ResultSet r1 = conn.s2.executeQuery(query2);

                    if (r1.next()) {
                        String amountToBePaid = r1.getString("price");
                        Lpy.setText(amountToBePaid);

                        String amountPaid = rs.getString("deposite");

                        // Calculate due amount
                        dueAmount = Integer.parseInt(amountToBePaid) - Integer.parseInt(amountPaid);
                        Ldue.setText(String.valueOf(dueAmount));
                    }
                } else {
                    lroom.setText("Room not found");
                    lname.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       if (ae.getSource() == ClearAc) {
    try {
        // Get the deposit input from the user
        String clearAmountText = Tclear.getText();
        
        // Check if clearAmountText is not empty
        if (clearAmountText == null || clearAmountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an amount to clear.");
            return; // Stop further execution if empty
        }
        
        int clearAmount = Integer.parseInt(clearAmountText);
        
        // Get the previous paid amount from the UI
        String amountPaidText = lPaid.getText();
        int previousPaidAmount = amountPaidText.isEmpty() ? 0 : Integer.parseInt(amountPaidText);

        // Subtract clear amount from the due amount
        if (clearAmount >= dueAmount) {
            // If the clear amount is greater than or equal to the due amount
            Ldue.setText("0");
            Tclear.setText(""); // Clear the text box
            lPaid.setText(String.valueOf(previousPaidAmount + dueAmount)); // Update paid amount with total
            dueAmount = 0; 
            Conn conn = new Conn();
            String query = "UPDATE customer SET deposite = '" + (previousPaidAmount + clearAmount) + "' WHERE room = '" +lroom+ "'";
            conn.s.executeUpdate(query);

// Set due amount to zero as it's fully paid
        } else {
            // If the clear amount is less than the due amount
            dueAmount -= clearAmount; // Update due amount
            Ldue.setText(String.valueOf(dueAmount)); // Update UI to show remaining due
            lPaid.setText(String.valueOf(previousPaidAmount + clearAmount));
            
// Update paid amount
             Conn conn = new Conn();
            String query = "UPDATE customer SET deposite = '" + (previousPaidAmount + clearAmount) + "' WHERE room = '" + lroom.getText() + "'";
             JOptionPane.showMessageDialog(null, "Payment Updated Successfully");
            conn.s.executeUpdate(query);
            Tclear.setText("");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

       if (ae.getSource() == Update) {
    try {
        if(lname.getText()!=""){
        // Get the amount to be paid and amount paid from the labels
       String query1 = "UPDATE due SET dues = '" + dueAmount + "' WHERE id = '" +Tph.getText() + "'";

        Conn conn = new Conn();  // Create connection to the database
        int rowsUpdated = conn.s.executeUpdate(query1);  // Execute the update query

        // If no rows were updated, it means the id doesn't exist, so insert a new row
        if (rowsUpdated == 0) {
            String insertQuery = "INSERT INTO due (id, dues) VALUES ('" + Tph.getText() + "', '" + dueAmount + "')";
            conn.s.executeUpdate(insertQuery);  // Execute the insert query
           
        }
          JOptionPane.showMessageDialog(null, "Payment Updated Successfully");
        setVisible(false);
          new Reception();
        }else{
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Data");
        }
       

  
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    
    
}
       else if(ae.getSource() == Cancel){
            setVisible(false);
            new Reception();
        }

        
    }

    public static void main(String[] args) {
        new Updatecheckout();
    }
}
