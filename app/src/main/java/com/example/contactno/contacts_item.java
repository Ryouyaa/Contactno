package com.example.contactno;

public class contacts_item {
    private String mNama;
    private String mNomor;

    public contacts_item(String Nama, String Nomor) {
        mNama = Nama;
        mNomor = Nomor;
    }

    public contacts_item() {
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public void setmNomor(String mNomor) {
        this.mNomor = mNomor;
    }
    public String getNama() {
        return mNama;
    }

    public String getNomor() {
        return mNomor;
    }
}
