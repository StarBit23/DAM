package com.pmdm.virgen.pueblosconnavigationdraweb.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {
    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("details")
    @Expose
    private String details;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
