import java.awt.*;
import javax.swing.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(300, 100);    
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Managment<br/>System</html>");
        heading.setBounds(80, 30, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Developed By: Aman Sinha");
        name.setBounds(50, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(name);
  
        JLabel rollno = new JLabel("Roll Number 2106009");
        rollno.setBounds(50, 270, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(rollno);

        JLabel contact = new JLabel("Contact: aman2001sinha@gmail.com");
        contact.setBounds(50, 310, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
    
        setLayout(null);
    
        setVisible(true);
    }
  
    public static void main(String[] args) {
        new About();
    }
}    


// after 15 min start
