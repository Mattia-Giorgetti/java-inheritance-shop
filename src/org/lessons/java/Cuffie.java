package org.lessons.java;

import java.math.BigDecimal;

public class Cuffie extends Prodotto{
    private String colore;
    private boolean wired;

    public Cuffie(String nome, String descrizione, BigDecimal prezzo, String colore, boolean wired) {
        super(nome, descrizione, prezzo);
        this.colore = colore;
        this.wired = wired;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public boolean isWired() {
        return wired;
    }

    public void setWired(boolean wired) {
        this.wired = wired;
    }

    @Override
    public String toString() {
        return super.toString() + ", colore: " + colore + ", connettività: " + (wired ? "wired" : "wireless");
    }

    @Override
    public BigDecimal computeDiscount() {
        if (!wired){
            return getPrezzoIvato().subtract(getPrezzoIvato().multiply(new BigDecimal("0.07")));
        } else {
            return super.computeDiscount();
        }

    }
}

