
import java.awt.*; // for swing
import java.sql.ResultSet;
import javax.swing.*; // for color class under awt package
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener{

    Choice cEmpId, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave() {

        setSize(500, 550);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(50, 30, 150, 70);
        heading.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Employee Id");
        lblrollno.setBounds(60, 110, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lblrollno);

        cEmpId = new Choice();
        cEmpId.setBounds(60, 130, 200, 20);
        add(cEmpId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 200, 200, 20);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 240, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 270, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String roll = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+roll+"', '"+date+"', '"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new TeacherLeave();
    }
}
