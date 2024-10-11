package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class AllEmployes extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    // Constructor
    AllEmployes() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Column labels
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

        // Table setup
        table = new JTable();
        table.setBounds(0, 40, 1100, 300);
        table.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(table);

        // Populate the table with data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM Employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button setup
        back = new JButton("Back");
        back.setBounds(450, 420, 135, 30);
        add(back);
        back.addActionListener(this); // Add action listener

        // Frame properties
        setBounds(100, 100, 1100, 500);
        setVisible(true);
    }

    // Action listener
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            dispose(); // Use dispose() to close the window
            new Reception(); // Open the Reception window
        }
    }
    private static AllEmployes instance;

public static void open() {
    if (instance == null) {
        instance = new AllEmployes();
    } else {
        instance.setVisible(true); // Bring the existing window to the front
    }
}

// Call AllEmployes.open() instead of new AllEmployes() from Reception


    // Main method
    public static void main(String[] args) {
        new AllEmployes();
    }
}
