import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; //value ko direct table ke aandar insert ho jae ga


public class FeeStructure extends JFrame {
    
    FeeStructure() {
        setSize(1000, 600);
        setLocation(250, 50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JTable table = new JTable();

        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
             e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp); 

        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
    
}
