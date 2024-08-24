// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JButton update,pay, back;
    
    StudentFeeForm() {
        setSize(850, 500);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 40, 400, 300);
        add(image);
 
        
        JLabel lblrollnumber = new JLabel("Select by Roll No");
        lblrollnumber.setBounds(40, 60, 150, 30);
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);

        try {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from student");
           while(rs.next()) {
             crollno.add(rs.getString("roll"));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }  

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 112, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(190, 112, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 150, 200, 30);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(190, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);

        try {
            Conn c = new Conn();
            String query = "select * from student where roll='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }                 
        } catch (Exception e) {
            e.printStackTrace();
        }

         // This is a interface
         crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where roll='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 190, 150, 30);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String course[] = {"BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "Mcom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(190, 200, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 240, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);

        String branch[] = {"CS", "Electronics", "Mechanical", "IT", "Civil", "Metalurgy", "CSE-AI", "CSE-DS", "CSE-ML", "CSE-DS"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(190, 240, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(40, 280, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(190, 280, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        
        JLabel lbltotal = new JLabel("Total payble");
        lbltotal.setBounds(40, 330, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(180, 315, 500, 50);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30, 370, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));

        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(160, 370, 120, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(300, 370, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollno =  crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();

            try {
                Conn c = new Conn();

                String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+semester+"', '"+branch+"', '"+total+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }    
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
