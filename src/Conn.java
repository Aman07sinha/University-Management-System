// sql package ke aandar interface hota h jo connection ke aandar h
import java.sql.*;
public class Conn {

    // Interface ka ref var h
    // connection aata h sql package se  

    // step 2 create Connection
    Connection c;

    // step 3 create Statement
    Statement s;

    Conn () {
        try {
            // Step -1 Register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 3306 default port hota h usko likhne ka jarurat hota nhi h
            // agar 3306 nhi rha tb pura local host likhna pde ga
           // c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagmentsystem");

           // connection
           c = DriverManager.getConnection("jdbc:mysql:///universitymanagmentsystem", "root", "1234");

           // statement
           // my sql query execute
           s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
