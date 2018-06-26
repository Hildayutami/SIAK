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
import java.util.ArrayList;

import model.Mahasiswa;

/**
 *
 * @author hilda
 */
public class MahasiswaDAO {

    private Connection connection;

    public MahasiswaDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMahasiswa(Mahasiswa mhs) {
        try {
            String query = "insert into mahasiswa values('" + mhs.getNpm()+ "','" + mhs.getNama() + "','" + mhs.getAngkatan() + "', '" + mhs.getFakultas() + "','" + mhs.getIpk() + "')";
            //String query = "insert into siak.mahasiswa values(123,hilda,2017,fasilkom,4)";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removeMahasiswa(int npm) {
        String query = "delete from mahasiswa where mahasiswa.npm = " + npm + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMahasiswa(Mahasiswa mhs) {
        String query = "update mahasiswa set mahasiswa.npm='"+ mhs.getNpm()
                + "', mahasiswa.nama='" + mhs.getNama()
                + "', mahasiswa.angkatan='" + mhs.getAngkatan()
                + "', mahasiswa.fakultas='" + mhs.getFakultas()
                + "', mahasiswa.ipk='" + mhs.getIpk()
                + "' where mahasiswa.npm = " + mhs.getNpm() + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<Mahasiswa> getMahasiswa() throws SQLException {
        String query = "select * from mahasiswa";
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(res.getInt("npm"));
            mhs.setNama(res.getString("nama"));
            mhs.setAngkatan(res.getInt("angkatan"));
            mhs.setFakultas(res.getString("fakultas"));
            mhs.setIpk(res.getInt("ipk"));
            mahasiswa.add(mhs);
        }
        return mahasiswa;
    }

    public Mahasiswa getMahasiswaByNpm(int npm) throws SQLException {
        Mahasiswa mhs = new Mahasiswa();
        String query = "select * from mahasiswa where mahasiswa.npm = " + npm + " ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        if (res.next()) {
            mhs.setNpm(res.getInt("npm"));
            mhs.setNama(res.getString("nama"));
            mhs.setAngkatan(res.getInt("angkatan"));
            mhs.setFakultas(res.getString("fakultas"));
            mhs.setIpk(res.getInt("ipk"));
        }
        return mhs;
    }

}
