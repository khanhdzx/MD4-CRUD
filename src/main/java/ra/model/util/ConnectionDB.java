package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URl = "jdbc:mysql://localhost:3306/Catalog_MVC";
    private static final String USER = "root";
    private static final String PASS = "123456789";
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URl,USER,PASS);
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }catch (ClassNotFoundException ex2){
            ex2.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn , CallableStatement callSt){
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }
        if (callSt!=null){
            try {
                callSt.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
