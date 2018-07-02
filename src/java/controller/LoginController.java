/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;

/**
 *
 * @author hilda
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("ini username "+userName);

        Login login = new Login();

        login.setUsername(userName);
        login.setPassword(password);

        LoginDAO loginDao = new LoginDAO();

        try {
            String user = loginDao.authenticateUser(login);

            if (user.equals("Admin_Role")) {

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", userName); //setting session attribute
                //request.setAttribute("username", userName);
                
                response.sendRedirect(request.getContextPath() + "/MahasiswaController?action=listmahasiswa");
                //request.getRequestDispatcher("/Index.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/Hello.jsp");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    } //End of doPost()

}
