package com.darkxrat.mantax.model;

public class Role {
    private int id;
    private String nama;
    private int slot;         // -1 = unlimited
    private int level;        // makin tinggi = makin tinggi role nya

    public Role() {}

    public Role(int id, String nama, int slot, int level) {
        this.id = id;
        this.nama = nama;
        this.slot = slot;
        this.level = level;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public boolean isUnlimited() { return slot == -1; }
}