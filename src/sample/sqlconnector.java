package sample;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class sqlconnector {

    Connection conn=null;
    public static Connection ConnectDb(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/result","root","");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"e");
            return null;
        }
    }
}
