/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MahasiswaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mahasiswa;

/**
 *
 * @author hilda
 */
@WebServlet(name = "MahasiswaController", urlPatterns = {"/MahasiswaController"})
public class MahasiswaController extends HttpServlet {
private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/Mahasiswa.jsp";
    private static String list_mahasiswa = "/ListMahasiswa.jsp";
    private MahasiswaDAO mahasiswaDAO;

    public MahasiswaController() {
        super();
        mahasiswaDAO = new MahasiswaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            // the other page is sending the npm , so we can get here and
            // call the remove method
            int npm = Integer.parseInt(request.getParameter("npm"));
            // we remove the mhs from the database
            mahasiswaDAO.removeMahasiswa(npm);
            // set the forward string to list and put all mahasiswa in request
            // attribute so we can use them inside the other page
            forward = list_mahasiswa;
            try {
                request.setAttribute("mahasiswa", mahasiswaDAO.getMahasiswa());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // if the user is trying to edit a mhs
        } else if (action.equalsIgnoreCase("edit")) {
            forward = insert_or_edit;
            int npm = Integer.parseInt(request.getParameter("npm"));
            try {
                Mahasiswa mhs = mahasiswaDAO.getMahasiswaByNpm(npm);
                request.setAttribute("mahasiswa", mhs);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("listmahasiswa")) {
            forward = list_mahasiswa;
            try {
                request.getParameter("username");  
                request.setAttribute("mahasiswa", mahasiswaDAO.getMahasiswa());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forward = insert_or_edit;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mahasiswa mhs = new Mahasiswa();
        
        String npm = request.getParameter("npm");
        
        mhs.setNpm(Integer.parseInt(request.getParameter("npm")));
        mhs.setNama(request.getParameter("nama"));
        mhs.setAngkatan(Integer.parseInt(request.getParameter("angkatan")));
        mhs.setFakultas(request.getParameter("fakultas"));
        mhs.setIpk(Integer.parseInt(request.getParameter("ipk")));
        
        //mahasiswaDAO.addMahasiswa(mhs);
        
        //System.out.println("ola");
        //System.out.println(npm);
        // what i'm trying to mean here is: if the npm coming from the
        // request is null
        // then, the user is trying to add someone, otherwise, he's trying to
        // update someone
        if (npm != null || !npm.isEmpty()) {
            mhs.setNpm(Integer.parseInt(npm));
            mahasiswaDAO.updateMahasiswa(mhs);
        } 
        mahasiswaDAO.addMahasiswa(mhs);
        
        response.sendRedirect(request.getContextPath() + "/Index.jsp");
    }

}