package com.pmdm.virgen.pueblosconnavigationdraweb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRegister {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("insert_id")
    @Expose
    private Integer insertId;

    @SerializedName("details")
    @Expose
    private String details;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getInsertId() {
        return insertId;
    }

    public void setInsertId(Integer insertId) {
        this.insertId = insertId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
