package model;

import bean.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginmodel {

    public static void checkLogin(login lg) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Assignment_Java5";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " SELECT * FROM Users WHERE Username = ? and Password = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, lg.getUsername());
            stm.setInt(2, lg.getPassword());
            ResultSet rs = stm.executeQuery();
            boolean exit = false;
            exit = rs.next();
            rs.close();
            stm.close();
            con.close();           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
