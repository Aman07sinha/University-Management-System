import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Marks extends JFrame implements ActionListener{
     
    String rollno;
    JButton cancel;

    Marks(String rollno) {
        this.rollno = rollno;

        setSize(500, 550);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("GITA AUTONOMOUS COLLEGE");
        heading.setBounds(90, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(100, 70, 500, 50);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(subheading);

         
        JLabel lblrollno = new JLabel("Roll Number " + rollno);
        lblrollno.setBounds(60, 120, 500, 50);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 150, 500, 50);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 220, 500, 50);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 250, 500, 50);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 280, 500, 50);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 310, 500, 50);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 340, 500, 50);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub5);

        try {

            Conn c = new Conn();

            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "---------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "---------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "---------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "---------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "---------" + rs2.getString("marks5"));
                lblsemester.setText("Semester " + rs2.getString("semester"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(280, 450, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}
