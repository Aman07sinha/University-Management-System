import java.awt.*;
import javax.swing.*; // for JFrame
import java.sql.*;
import net.proteanit.sql.DbUtils; // for table make 
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails() {
        setSize(1000, 500);
        setLocation(300, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check result");
        heading.setBounds(50, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        search = new JTextField();
        search.setBounds(45, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(280, 92, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(450, 92, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);


        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 10 ));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 1000, 350);
        add(jsp);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
             
            // setmodel means yaha pe model ko set kra hu
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                // set model means value ko model se nikal rha hu
                int row = table.getSelectedRow();

                // kis row se nikal rha hu
                search.setText(table.getModel().getValueAt(row, 2).toString());



            }

        });



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            setVisible(false);
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
