package com.example.mympvpjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WisataResponse {
    @SerializedName("wisata")
    private List<WisataItem> wisata = null;

    public List<WisataItem> getWisata() {
        return wisata;
    }

    public void setWisata(List<WisataItem> wisata) {
        this.wisata = wisata;
    }
}
