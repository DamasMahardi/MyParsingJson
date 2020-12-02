package com.example.mympvpjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WisataItem {
    @SerializedName("id")

    private Integer id;
    @SerializedName("nama")

    private String nama;
    @SerializedName("gambar_url")

    private String gambarUrl;
    @SerializedName("kategori")
    private String kategori;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambarUrl() {
        return gambarUrl;
    }

    public void setGambarUrl(String gambarUrl) {
        this.gambarUrl = gambarUrl;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
