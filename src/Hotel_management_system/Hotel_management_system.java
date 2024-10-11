package Hotel_management_system;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

public class Hotel_management_system extends JFrame implements ActionListener{

    // Constructor
    Hotel_management_system() {
        
        
        // Set size and location of the window
        setBounds(100, 100, 1100, 550);
        setLayout(null);

        // Load image using ClassLoader and scale it to fit the frame
        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("icons/three.png"));
        Image scaledImage = i1.getImage().getScaledInstance(1100, 550, Image.SCALE_SMOOTH);  // Scale image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);  // Create a new ImageIcon with the scaled image
        // Add image to a JLabel
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 1100, 550);
        add(image);
        
        JLabel text = new JLabel("Management System");
        text.setBounds(550,50,800,100);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD, 55));
        image.add(text);
        
        JLabel text2 = new JLabel("The Royal Paradise Hotel");
        text2.setBounds(580,130,800,100);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Sanchez", Font.PLAIN, 36));
        image.add(text2);
        
        JLabel text3 = new JLabel("visit us at");
        text3.setBounds(770,200,800,100);
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("Sanchez", Font.PLAIN, 15));
        image.add(text3);
        
         JLabel text4 = new JLabel("212 new Delhi West gurgao sector 22");
        text4.setBounds(700,220,800,100);
        text4.setForeground(Color.BLACK);
        text4.setFont(new Font("Sanchez", Font.BOLD, 12));
        image.add(text4);

        
         JLabel text5 = new JLabel("Admin Contact: 878787878");
        text5.setBounds(700,250,800,100);
        text5.setForeground(Color.BLACK);
        text5.setFont(new Font("Sanchez", Font.BOLD, 16));
        image.add(text5);

        
        JButton next= new JButton("Next");
        next.setBounds(690,400,280,50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE); 
        next.setFocusPainted(false);
        next.setFont(new Font("serif", Font.PLAIN,25 ));
        
        next.addActionListener(this);
        image.add(next);
        // Make the window visible
       Timer timer = new Timer(500, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setVisible(visible);
                visible = !visible;
            }
        });
        timer.start();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        // Create the JFrame window
        new Hotel_management_system();
    }
}
