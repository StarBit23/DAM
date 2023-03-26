package com.pmdm.virgen.pueblosconnavigationdraweb.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pmdm.virgen.pueblosconnavigationdraweb.JuegoParaApi;
import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Juego;

import java.util.List;

public class ResponseListadoJuegos {
    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("pueblos")
    @Expose
    private List<Juego> pueblos;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Juego> getPueblos() {
        return pueblos;
    }

    public void setPueblos(List<Juego> pueblos) {
        this.pueblos = pueblos;
    }
}

