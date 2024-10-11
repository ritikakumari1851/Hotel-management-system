package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Department() {
        // Setting layout and background color
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Department label
        JLabel l1 = new JLabel("Department");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        // Budget label
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(370, 10, 100, 20);
        add(l2);

        // Table setup
        table = new JTable();
        table.setBounds(0, 40, 700, 250); // Adjusted height to make room for the button
        add(table);

        // Populating the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button setup
        back = new JButton("Back");
        back.setBounds(250, 300, 135, 30); // Positioned below the table
        add(back);
        back.addActionListener(this);

        // Frame properties
        setBounds(300, 100, 700, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added for proper exit behavior
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Department();
    }
}
