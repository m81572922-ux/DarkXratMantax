package com.darkxrat.mantax.model;

public class Bug {
    private int id;
    private String nama;
    private String tipe;      // BUG, SADAP
    private String func;      // default, hard, ultra, gacor
    private String deskripsi;

    public Bug() {}

    public Bug(int id, String nama, String tipe, String func, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.tipe = tipe;
        this.func = func;
        this.deskripsi = deskripsi;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }

    public String getFunc() { return func; }
    public void setFunc(String func) { this.func = func; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}