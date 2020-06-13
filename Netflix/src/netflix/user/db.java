
package netflix.user;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class db {
    
        static Connection conn = null;
         private static String url="jdbc:sqlite";
         private static String dbName=":db/netflix1.db";   
         private static String driver="org.sqlite.JDBC";
         
    public static Connection java_db(){
  
        try{
            Class.forName(driver).newInstance();
           conn=DriverManager.getConnection(url+dbName);
             System.out.println("Basarili");
            
        }
         catch (Exception e) {
       JOptionPane.showMessageDialog(null, e);
              System.out.println("Basarisiz");  
             
    }  
        return conn;
   
    }
    
}
