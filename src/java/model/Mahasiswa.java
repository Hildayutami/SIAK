/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hilda
 */
public class Mahasiswa {
    private int npm;
    private String nama;
    private int angkatan;
    private String fakultas;
    private int ipk;

    public Mahasiswa() {
    }
    
    

    public int getNpm() {
        return npm;
    }

    public void setNpm(int npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public int getIpk() {
        return ipk;
    }

    public void setIpk(int ipk) {
        this.ipk = ipk;
    }
    
    
    
}
