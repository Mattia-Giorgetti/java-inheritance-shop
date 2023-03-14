package org.lessons.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
//    ATTRIBUTI
    private int codice;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;
    private BigDecimal iva = BigDecimal.valueOf(0.22);
    private  BigDecimal generalDiscount = new BigDecimal("0.02");


//    COSTRUTTORE
    public Prodotto(String nome, String descrizione, BigDecimal prezzo){
        Random rand = new Random();
        this.codice = rand.nextInt(1,1000);
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

//    GETTER SETTER


    public BigDecimal getGeneralDiscount() {
        return generalDiscount;
    }
    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public BigDecimal getIva() {
        return iva;
    }




    //    METODI
    public BigDecimal getPrezzoIvato(){
        return prezzo.add(prezzo.multiply(iva).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Override
    public String toString() {
        return "Prodotto: " +
                "codice: " + codice +
                ", nome: " + nome +
                ", descrizione: " + descrizione +
                ", prezzo: " + prezzo +
                ", iva: " + iva +
                ", prezzo ivato: " + getPrezzoIvato() +
                ", prezzo scontato: " + computeDiscount();
    }

    public BigDecimal computeDiscount() {
        return getPrezzoIvato().subtract(prezzo.multiply(generalDiscount).setScale(2, RoundingMode.HALF_EVEN));
    }
}
