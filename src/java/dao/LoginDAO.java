/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

/**
 *
 * @author hilda
 */
public class LoginDAO {

    private Connection connection;

    public LoginDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String authenticateUser(Login login) {
        String userNameDB;
        String passwordDB;
        
        String userName = login.getUsername(); //Keeping user entered values in temporary variables.
        String password = login.getPassword();
        try {
            String query = "select users.username, users.password, users.role from users";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) // Until next row is present otherwise it return false
            {
                userNameDB = res.getString("username"); //fetch the values present in database
                passwordDB = res.getString("password");
                String roleDB = res.getString("role");

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin")) {
                    return "Admin_Role";
                } 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return "Invalid user credentials"; // Just returning appropriate message otherwise
    }
}
