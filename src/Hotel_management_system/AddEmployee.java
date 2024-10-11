package Hotel_management_system;

import javax.swing.*;  // Needed for JFrame
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {  // Extend JFrame to use UI methods

    JTextField tname, tage, tsalary, tEmail, tphone, tadhar;
    JRadioButton btn1, btn2;
    JButton submit,cancel;
    JComboBox jobs;

    AddEmployee() {
        
        // Set layout and bounds for the JFrame
        setLayout(null);

        JLabel lname = new JLabel("NAME");
        lname.setBounds(60, 30, 120, 30);
        lname.setFont(new Font("serif", Font.PLAIN, 15));
        add(lname);

        tname = new JTextField();
        tname.setBounds(200, 30, 150, 25);
        add(tname);

        JLabel lage = new JLabel("AGE");
        lage.setBounds(60, 80, 120, 30);
        lage.setFont(new Font("serif", Font.PLAIN, 15));
        add(lage);

        tage = new JTextField();
        tage.setBounds(200, 80, 150, 25);
        add(tage);

        JLabel lGender = new JLabel("GENDER");
        lGender.setBounds(60, 130, 120, 30);
        lGender.setFont(new Font("serif", Font.PLAIN, 15));
        add(lGender);

        btn1 = new JRadioButton("Male");
        btn1.setBounds(200, 130, 70, 25);
        btn1.setFont(new Font("Tahuma", Font.BOLD, 14));
        btn1.setBackground(Color.WHITE);
        add(btn1);

        btn2 = new JRadioButton("Female");
        btn2.setBounds(280, 130, 90, 25);
        btn2.setFont(new Font("serif", Font.BOLD, 14));
        btn2.setBackground(Color.WHITE);
        add(btn2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(btn1);
        bg.add(btn2);

        JLabel ljob = new JLabel("JOB");
        ljob.setBounds(60, 180, 120, 30);
        ljob.setFont(new Font("serif", Font.PLAIN, 15));
        add(ljob);

        String str[] = { "Front Desk Clerks", "Porters", "HouseKeeping", "Kitchen staff", "Room Service", "Chefs", "Waiters", "Accountants","Manager" };

        jobs = new JComboBox(str);
        jobs.setBounds(200, 180, 150, 25);
        jobs.setFont(new Font("serif", Font.PLAIN, 15));
        jobs.setBackground(Color.WHITE);
        add(jobs);

        JLabel lSalary = new JLabel("SALARY");
        lSalary.setBounds(60, 230, 150, 30);
        lSalary.setFont(new Font("serif", Font.PLAIN, 15));
        add(lSalary);

        tsalary = new JTextField();
        tsalary.setBounds(200, 230, 150, 25);
        add(tsalary);

        JLabel LEmail = new JLabel("EMAIL");
        LEmail.setBounds(60, 290, 120, 30);
        LEmail.setFont(new Font("serif", Font.PLAIN, 15));
        add(LEmail);

        tEmail = new JTextField();
        tEmail.setBounds(200, 290, 150, 25);
        add(tEmail);

        JLabel Ladhar = new JLabel("ADHAR");
        Ladhar.setBounds(60, 400, 120, 30);
        Ladhar.setFont(new Font("serif", Font.PLAIN, 15));
        add(Ladhar);

        tadhar = new JTextField();
        tadhar.setBounds(200, 400, 150, 25);
        add(tadhar);

        JLabel Lphone = new JLabel("PHONE-NO");
        Lphone.setBounds(60, 350, 120, 30);
        Lphone.setFont(new Font("serif", Font.PLAIN, 15));
        add(Lphone);

        tphone = new JTextField();
        tphone.setBounds(200, 350, 150, 25);
        add(tphone);

        submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(200, 455, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
         cancel = new JButton("CANCEL");
        cancel.setBounds(30,455, 150, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/epy.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 360);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(250, 100, 900, 540);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent ae) {
    
    if(ae.getSource()==cancel){
    setVisible(false);
    
}else if(ae.getSource()==submit){
    String name = tname.getText();
    String age = tage.getText();
    String salary = tsalary.getText();
    String phone = tphone.getText();
    String email = tEmail.getText();
    String adhar = tadhar.getText();

    String gender = null;

    if (btn1.isSelected()) {
        gender = "Male";
    } else if (btn2.isSelected()) {
        gender = "Female";
    }

    String job = (String) jobs.getSelectedItem();

    // Validate if any field is empty
    if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name should not be empty");
        return;
    }

    if (age.equals("")) {
        JOptionPane.showMessageDialog(null, "Age should not be empty");
        return;
    }

    if (salary.equals("")) {
        JOptionPane.showMessageDialog(null, "Salary should not be empty");
        return;
    }

    if (phone.equals("")) {
        JOptionPane.showMessageDialog(null, "Phone number should not be empty");
        return;
    }

   if (email.equals("") || !email.contains("@") || !email.endsWith(".com")) {
    JOptionPane.showMessageDialog(null, "Please enter a valid email address (e.g., user@example.com)");
    return;
}

    if (adhar.equals("")) {
        JOptionPane.showMessageDialog(null, "Aadhar number should not be empty");
        return;
    }

    // Age validation: Must be a number and greater than 18
    try {
        int ageValue = Integer.parseInt(age);  // Convert age to an integer
        if (ageValue < 18) {
            JOptionPane.showMessageDialog(null, "Age must be greater than or equal to 18");
            return;  // Stop execution if age is less than 18
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid number for age");
        return;  // Stop execution if age is not a valid number
    }

    // Aadhar number validation: Must be exactly 12 characters
    if (adhar.length() != 12) {
        JOptionPane.showMessageDialog(null, "Aadhar number must be exactly 12 characters");
        return;
    }

    // Phone number validation: Must be exactly 10 numeric characters
    if (phone.length() != 10 || !phone.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits and contain only numbers");
        return;
    }

    // Email length validation
    if (email.length() > 255) {  // Assuming email field in the database allows 255 characters
        JOptionPane.showMessageDialog(null, "Email is too long. Please enter a valid email with fewer than 255 characters.");
        return;  // Stop execution if email is too long
    }

    try {
        Conn conn = new Conn();

        String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + adhar + "','" + email + "')";
        conn.s.executeUpdate(query);

        JOptionPane.showMessageDialog(null, "Employee added successfully!");
        setVisible(false);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
    public static void main(String[] args) {
        new AddEmployee();
    }
}
