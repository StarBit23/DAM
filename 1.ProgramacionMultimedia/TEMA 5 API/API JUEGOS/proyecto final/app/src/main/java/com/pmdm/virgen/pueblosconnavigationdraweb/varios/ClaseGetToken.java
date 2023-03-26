package com.pmdm.virgen.pueblosconnavigationdraweb.varios;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClaseGetToken{
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClaseGetToken() {
    }

    public ClaseGetToken(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
