package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    ManagerInfo() {
        // Frame layout and background color
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Labels for table columns
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(0, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(150, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(280, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("JOB");
        l4.setBounds(440, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(560, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("PHONE NO");
        l6.setBounds(690, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("ADHAR");
        l7.setBounds(850, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("EMAIL");
        l8.setBounds(1000, 10, 100, 20);
        add(l8);

        // Table for displaying manager information
        table = new JTable();
        table.setBounds(0, 40, 1100, 300);
        table.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(table);

        // Query to populate the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM Employee WHERE job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button
        back = new JButton("Back");
        back.setBounds(450, 360, 135, 30); // Adjusted position to ensure visibility
        add(back);
        back.addActionListener(this);

        // Frame properties
        setBounds(100, 100, 1100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Proper exit behavior
        setVisible(true);
    }

    // Action listener for the back button
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception(); // Navigate back to Reception
    }

    // Main method to run the application
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
