import java.awt.*;
import javax.swing.*;

// swing ke aandar ek cls hoti h JFrame
public class Roll extends JFrame implements Runnable{

    // frame ki saare coding const ke aandar hogi
    // frame made by using swing
    Thread t;
    Roll () {

        //frame ke upar ek img dalni h
        //clsLoader ke andar ek static method hota h get system
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        // i2 ke aandar scaled image h
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        // JLabel ke aandar image cls ka obj pass nhi kr skte 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        // start method automatically run method ko cl kr dega
        t.start();

        setVisible(true);

        int x=1;
        for(int i=2;i <= 600; i+=8, x+=2){
            setLocation(550 - ((i+x)/2), 325 - (i/2));
            setSize(i + 3*x, i+x/2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }  
    }

    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);

            // Next Frame
            new Login();
        } catch(Exception e) {

        }
    }
    public static void main(String[] args) {
        // actual object / ananomous object
        // class obj bnate ke sath constructor cl hota h
        new Roll();
    }
}