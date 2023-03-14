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
    private List<JuegoParaApi> pueblos;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<JuegoParaApi> getPueblos() {
        return pueblos;
    }

    public void setPueblos(List<JuegoParaApi> pueblos) {
        this.pueblos = pueblos;
    }
}

