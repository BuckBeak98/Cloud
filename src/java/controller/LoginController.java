package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class LoginController {

    private Connection con;
    private PreparedStatement pstm;

    @RequestMapping()
    public String checklogin(ModelMap model) {
        model.addAttribute("message", "Bạn gọi index()");
        return "index";
    }
       
    @RequestMapping(params = "btnLogin")
    public String checklogin(ModelMap model,
            @RequestParam("name") String name,
            @RequestParam("mark") int mark) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Assignment_Java5";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " SELECT * FROM Users WHERE Username = ? and Password = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, mark);
            ResultSet rs = stm.executeQuery();
            boolean exit = false;
            exit = rs.next();
            rs.close();
            stm.close();
            con.close();           
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "Insert success !!!");
        return "success";
    }
}
