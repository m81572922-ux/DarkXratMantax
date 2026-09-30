package com.darkxrat.mantax.model;

public class Sender {
    private int id;
    private String nomor;
    private String kode;
    private String tipe;       // PRIVATE, GLOBAL, PRIVATE_USER
    private String ownerUser;  // username pemilik sender
    private boolean isOnline;

    public Sender() {}

    public Sender(int id, String nomor, String kode, String tipe, String ownerUser) {
        this.id = id;
        this.nomor = nomor;
        this.kode = kode;
        this.tipe = tipe;
        this.ownerUser = ownerUser;
        this.isOnline = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomor() { return nomor; }
    public void setNomor(String nomor) { this.nomor = nomor; }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }

    public String getOwnerUser() { return ownerUser; }
    public void setOwnerUser(String ownerUser) { this.ownerUser = ownerUser; }

    public boolean isOnline() { return isOnline; }
    public void setOnline(boolean online) { isOnline = online; }
}