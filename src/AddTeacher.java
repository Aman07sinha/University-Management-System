
import java.awt.*; // For JFrame
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress,tfphone, tfemail, tfx, tfxii, tfaadhar ;
    JLabel labelempId;
    JDateChooser dcdob;

    // for drop down ke liye 
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    // random roll no
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {
          
        setSize(800, 600);
        setLocation(300, 60);

        setLayout(null);
        

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 150, 150, 30);
        add(tfname);

        
        JLabel lblfname = new JLabel("father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(550, 150, 150, 30);
        add(tffname);

        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblempId);

        labelempId = new JLabel("101" + first4);
        labelempId.setBounds(190, 200, 200, 30);
        labelempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(labelempId);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(550, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(190, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(550, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(190, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(550, 300, 150, 30);
        add(tfx);

        
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(190, 350, 150, 30);
        add(tfxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(550, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "Mcom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(190, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 100, 30);
        lblbranch.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"CS", "Electronics", "Mechanical", "IT", "Civil", "Metalurgy", "CSE-AI", "CSE-DS", "CSE-ML", "CSE-DS"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(550, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 480, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 481, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelempId.getText();
            String dob = ((JTextField).dcdob.getEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into teacher values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher's Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }  

            } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddTeacher();
    }
}

