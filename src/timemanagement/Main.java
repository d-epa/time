package timemanagement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.forName;
import static java.sql.DriverManager.getConnection;

public class Main {
    public Main(String text ) throws SQLException,ClassNotFoundException {
        String URL="jdbc:mysql://localhost:3307/time ";
        String username="root";
        String password="root";
        String query="Select * from tab";
        forName("com.mysql.cj.jdbc.Driver");
        Connection con= getConnection(URL,username,password);
        System.out.println("connection established successfully");
        String qu="insert into users(name)Value('"+ text+"');";
        Statement smt=con.createStatement();
        smt.execute(qu);
        con.close();
        System.out.println("connection closed");

    }
}
