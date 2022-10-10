package com.example.primeraapp;

public class claseA {
    public int i;
    public String n;

    public claseA(int i, String n) {
        this.i = i;
        this.n = n;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "claseA{" +
                "i=" + i +
                ", n='" + n + '\'' +
                '}';
    }
}
