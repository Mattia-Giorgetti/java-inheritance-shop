package org.lessons.java;

import java.math.BigDecimal;

public class TV extends Prodotto{
    private BigDecimal dimensione;
    private boolean smartTV;

    public TV(String nome, String descrizione, BigDecimal prezzo, BigDecimal dimensione, boolean smartTV) {
        super(nome, descrizione, prezzo);
        this.dimensione = dimensione;
        this.smartTV = smartTV;
    }

    public BigDecimal getDimensione() {
        return dimensione;
    }

    public void setDimensione(BigDecimal dimensione) {
        this.dimensione = dimensione;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    public void setSmartTV(boolean smartTV) {
        this.smartTV = smartTV;
    }

    @Override
    public String toString() {
        return super.toString() + ", dimensioni: " + dimensione + " pollici" + " , smart: " + (smartTV ? "si" : "no");
    }

    @Override
    public BigDecimal computeDiscount() {
        if (!smartTV){
            return getPrezzoIvato().subtract(getPrezzoIvato().multiply(new BigDecimal("0.01")));
        } else {
            return super.computeDiscount();
        }

    }
}
