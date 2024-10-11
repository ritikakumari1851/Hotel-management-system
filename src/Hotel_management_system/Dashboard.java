package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton rcp, admin;
    
    Dashboard() {
        setLayout(null);
        
        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Set the frame size according to the screen size
        setBounds(0, 0, width, height);

        // Load and scale the image according to the screen size
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Paradise.png"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        // Set the bounds of the image to match the screen size
        image.setBounds(0, 0, width, height);
        add(image); // Add the image to the frame
        
        // Create buttons
        rcp = new JButton("Reception");
        rcp.setBounds(100, 600, 250, 60);
        rcp.setBackground(Color.BLACK);
        rcp.setForeground(Color.WHITE); 
        rcp.setFocusPainted(false);
        rcp.setFont(new Font("serif", Font.PLAIN, 20));
        rcp.addActionListener(this);
        image.add(rcp); // Add button to the image label to ensure correct rendering
        
        admin = new JButton("Admin");
        admin.setBounds(900, 600, 250, 60);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE); 
        admin.setFocusPainted(false);
        admin.setFont(new Font("serif", Font.PLAIN, 20));
        admin.addActionListener(this);
        image.add(admin); // Add button to the image label

        // Finalize JFrame settings
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application closes
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rcp) {
            setVisible(false);
            new Reception(); // Open Reception window
        } else if (ae.getSource() == admin) {
            setVisible(false);
            new AdminLogin(); // Open AdminLogin window
        }
    }

    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread (EDT)
        new Dashboard();
    }
}
