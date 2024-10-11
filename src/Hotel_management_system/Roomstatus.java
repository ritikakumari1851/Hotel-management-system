package Hotel_management_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Roomstatus extends JFrame implements ActionListener {
    JButton Update, Cancel;
    Choice croom, cavl, ccln;

    Roomstatus() {
        // Frame settings
        setBounds(180, 50, 900, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title label
        JLabel lb1 = new JLabel("Update Room Status");
        lb1.setBounds(80, 10, 300, 50);
        lb1.setForeground(Color.BLUE);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1);

        // Room Number label
        JLabel Lroom = new JLabel("Room No:");
        Lroom.setBounds(20, 150, 100, 30);
        add(Lroom);

        // Availability label
        JLabel Lavl = new JLabel("Availability");
        Lavl.setBounds(20, 210, 100, 30);
        add(Lavl);

        // Cleaning Status label
        JLabel clean = new JLabel("Cleaning status");
        clean.setBounds(20, 280, 100, 30);
        add(clean);

        // Choice component for Room Numbers
        croom = new Choice();
        croom.setBounds(150, 150, 150, 40);
        add(croom);

        // Populate the choice box with room numbers from the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM room";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                croom.add(rs.getString("roomNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Availability Choice component
        cavl = new Choice();
        cavl.setBounds(150, 210, 150, 30);
        cavl.add("Available");
        cavl.add("Not Available");
        add(cavl);

        // Cleaning Status Choice component
        ccln = new Choice();
        ccln.setBounds(150, 280, 150, 30);
        ccln.add("Cleaned");
        ccln.add("Dirty");
        add(ccln);

        // Add an ItemListener to handle room selection and populate the choices
        croom.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String selectedRoom = croom.getSelectedItem();
                try {
                    // Query to fetch room data based on the selected room number
                    Conn conn = new Conn();
                    String query = "SELECT * FROM room WHERE roomNumber = '" + selectedRoom + "'";
                    ResultSet rs = conn.s.executeQuery(query);

                    // Update the Choices with availability and cleaning status
                    if (rs.next()) {
                        String availableStatus = rs.getString("available");
                        String cleaningStatus = rs.getString("cleaningStatus");

                        // Set the selected value in the Availability Choice
                        if (availableStatus.equalsIgnoreCase("Available")) {
                            cavl.select("Available");
                        } else {
                            cavl.select("Not Available");
                        }

                        // Set the selected value in the Cleaning Status Choice
                        if (cleaningStatus.equalsIgnoreCase("Clean")) {
                            ccln.select("Clean");
                        } else {
                            ccln.select("Dirty");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Update button
        Update = new JButton("UPDATE");
        Update.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Update.setForeground(Color.WHITE);
        Update.setBackground(Color.BLACK);
        Update.setBounds(220, 370, 100, 30);
        Update.addActionListener(this);
        add(Update);

        // Cancel button
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.BLACK);
        Cancel.setBounds(100, 370, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        // Image component
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(440, 60, 520, 350);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Cancel) {
            setVisible(false);
            new Reception(); // Assuming Reception class exists
        }

        // Update room details in the database
        if (ae.getSource() == Update) {
            String roomNumber = croom.getSelectedItem();
            String availability = cavl.getSelectedItem();
            String cleaningStatus = ccln.getSelectedItem();

            try {
                // Update query to update availability and cleaning status based on room number
                Conn conn = new Conn();
                String query = "UPDATE room SET available = '" + availability + "', cleaningStatus = '" + cleaningStatus + "' WHERE roomNumber = '" + roomNumber + "'";
                conn.s.executeUpdate(query);
                setVisible(false);
                new Reception();

                JOptionPane.showMessageDialog(null, "Room status updated successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public static void main(String[] args) {
        new Roomstatus();
    }
}
