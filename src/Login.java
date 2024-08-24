// JFrame ko import krne ke liye
import java.awt.*;
import java.awt.event.*;
import java.sql.*; // for ResultSet
import javax.swing.*; 


    public class Login extends JFrame implements ActionListener {

        // globally declare kr diya
        JButton login, cancel; 
        JTextField tfusername, tfpassword;

        Login() {
           getContentPane().setBackground(Color.WHITE);
           setLayout(null);

           JLabel  lblusername = new JLabel("username");
           // explicity place krne ke liye JBound use
           // 1 left 2 Top 3 label width 4 label height
           lblusername.setBounds(40, 20, 100, 20);
           add(lblusername);

           tfusername = new JTextField();
           tfusername.setBounds(150, 20, 150, 20);
           add(tfusername);

           // for password
           
           JLabel  lblpassword = new JLabel("password");
           lblpassword.setBounds(40, 70, 100, 20);
           add(lblpassword);

           // PasswordField fn h password ko show nhi kre ga
           tfpassword = new JPasswordField();
           tfpassword.setBounds(150, 70, 150, 20);
           add(tfpassword);

           // Button
           login = new JButton("Login");
           login.setBounds(40, 140, 120, 30);
           login.setBackground(Color.BLACK);
           login.setForeground(Color.WHITE);
           // kisi bhi button pe event performed krna h tb actionListener lgana h
           login.addActionListener(this);
           login.setFont(new Font("Tahoma", Font.BOLD, 15));
           add(login);

           cancel = new JButton("Cancel");
           cancel.setBounds(180, 140, 120, 30);
           cancel.setBackground(Color.BLACK);
           cancel.setForeground(Color.WHITE);
           cancel.addActionListener(this);
           cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
           add(cancel);

           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
           Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(350, 0, 200, 200);
           add(image);

           setSize(600, 300);
           setLocation(500, 250);
           setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == login) {

               // yaha se mujhe username or password nikalna h
               String username = tfusername.getText();
               String password = tfpassword.getText();

               // Step - 4 Make the MySql Query
               String query = "select * from login where username = '"+username+"' and password = '"+password+"'"; 
            
               // execute my sql query
               try {
                   
                    // Step - 5 open / create  connection with mysql
                    Conn c = new Conn();

                    // login folder me statement ki help se mysql query execute kr skte ho
                    // resultset ke object(rs) ke aandar mysql ka data store karaenge 
                    ResultSet rs = c.s.executeQuery(query);

                    if (rs.next()) {
                        setVisible(false);
                        new Project().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                        setVisible(false);
                    }
                    //step -5 close the connection
                    c.s.close();


               } catch (Exception e) {
                   e.printStackTrace();
            }

            } else if (ae.getSource() == cancel) {
                setVisible(false);
            }
        }

        public static void main(String[] args) {
            new Login();
        }
    }    
