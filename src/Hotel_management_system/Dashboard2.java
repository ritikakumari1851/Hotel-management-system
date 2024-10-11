package Hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard2 extends JFrame {

    Dashboard2() {
        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Set the frame size according to the screen size
        setBounds(0, 0, width, height);
        setLayout(null);

        // Load and scale the image according to the screen size
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/4.jpg"));
        if (i1.getImage() == null) {
            System.out.println("Image not found.");
        }
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        // Set the bounds of the image to match the screen size
        image.setBounds(0, 0, width, height);
        add(image);

        // Create and configure the text label
        JLabel text = new JLabel("The Paradise Group Welcomes You");
        text.setBounds(300, 80, 1000, 50); // Adjust position and size
        text.setFont(new Font("serif", Font.ITALIC, 46)); // Set font and size
        text.setForeground(Color.WHITE); // Set text color

        // Add the text to the image JLabel
        image.add(text); // Add text label on top of the background image
        text.setOpaque(false); // Make sure the background of the text is transparent

     // Create a menu bar
// Create a menu bar
JMenuBar mb = new JMenuBar();
mb.setBounds(500, 300, 250, 80);
mb.setBackground(new Color(111, 99, 126)); // Set background color to #6f637e
image.add(mb);

// Admin menu
JMenu admin = new JMenu("Admin");
admin.setFont(new Font("SERIF", Font.BOLD, 25));
admin.setForeground(Color.WHITE);

// Set padding to simulate centering
admin.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 60)); // Top, Left, Bottom, Right padding

// Set preferred size of the menu so that padding takes effect properly
admin.setPreferredSize(new Dimension(250, 80));

mb.add(admin);


     // Create "ADD EMPLOYEE" menu item and increase its size
JMenuItem add_Employee = new JMenuItem("ADD EMPLOYEE");
add_Employee.setFont(new Font("SERIF", Font.PLAIN, 20)); // Set larger font
add_Employee.setPreferredSize(new Dimension(248, 40)); // Set preferred size
admin.add(add_Employee);

// Create "ADD DRIVERS" menu item and increase its size
JMenuItem add_Drivers = new JMenuItem("ADD DRIVERS");
add_Drivers.setFont(new Font("SERIF", Font.PLAIN, 20)); // Set larger font
add_Drivers.setPreferredSize(new Dimension(200, 40)); // Set preferred size
admin.add(add_Drivers);

// Create "ADD ROOM" menu item and increase its size
JMenuItem add_Room = new JMenuItem("ADD ROOM");
add_Room.setFont(new Font("SERIF", Font.PLAIN, 20)); // Set larger font
add_Room.setPreferredSize(new Dimension(200, 40)); // Set preferred size
admin.add(add_Room);


        // Add action listener for "ADD EMPLOYEE" menu item
        add_Employee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Open the AddEmployee frame when "ADD EMPLOYEE" is clicked
                AddEmployee addEmployeeFrame = new AddEmployee();
                addEmployeeFrame.setVisible(true); // Ensure the frame is visible
            }
        });

        // Add action listener for "ADD ROOM" menu item
        add_Room.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AddRooms addRoomFrame = new AddRooms();
                addRoomFrame.setVisible(true); // Ensure the frame is visible
            }
        });

        // Add action listener for "ADD DRIVERS" menu item
        add_Drivers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AddDriver addDriverFrame = new AddDriver();
                addDriverFrame.setVisible(true); // Ensure the frame is visible
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard2();
    }
}
