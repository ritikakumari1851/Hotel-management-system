package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Drivers extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox<String> carnum;

    Drivers() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title label
        JLabel text = new JLabel("Search For Car Information");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 300, 30);
        add(text);

        // Car number label and combo box
        JLabel lcar = new JLabel("Car Number");
        lcar.setBounds(50, 100, 100, 20);
        add(lcar);

        carnum = new JComboBox<>();
        carnum.setBounds(150, 100, 150, 25);
        carnum.setBackground(Color.WHITE);
        add(carnum);

        // Populate carnum combo box with car numbers from the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM driver";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                carnum.addItem(rs.getString("Car_num"));  // Assuming Car_num is a string
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table labels
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Car Model");
        l4.setBounds(400, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Car Number");
        l5.setBounds(510, 160, 100, 20); // Changed position for "Car Number"
        add(l5);
        
        JLabel l6 = new JLabel("Status");
        l6.setBounds(620, 160, 100, 20); // Updated position for "Status"
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(740, 160, 100, 20); // Updated position for "Location"
        add(l7);

        // Table for displaying data
        table = new JTable();
        table.setBounds(40, 200, 800, 200);
        add(table);

        // Back and Submit buttons
        back = new JButton("Back");
        back.setBounds(300, 400, 120, 30);
        add(back);
        back.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(500, 400, 120, 30);
        add(submit);
        submit.addActionListener(this);

        setBounds(300, 100, 900, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // Get the selected car number
            String selectedCarNum = (String) carnum.getSelectedItem();

            try {
                // Query to retrieve driver data based on the selected car number
                String query = "SELECT * FROM driver WHERE Car_num = '" + selectedCarNum + "'";
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);

                // Update table with the result set data
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();  // Assuming you have a Reception class for navigation
        }
    }

    public static void main(String[] args) {
        new Drivers();
    }
}
