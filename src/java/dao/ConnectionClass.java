/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hilda
 */
public class ConnectionClass {
    
    public java.sql.Connection getConnection() throws SQLException{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/siak", "root", "");
    
    }
    
}
