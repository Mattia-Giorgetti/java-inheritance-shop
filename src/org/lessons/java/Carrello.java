package org.lessons.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sceltaOggetto;
        String nomeProdotto;
        String descrizioneProdotto;
        BigDecimal prezzo;
        int storage;
        BigDecimal dimensione;
        boolean isSmart;
        String colore;
        boolean wired;

        System.out.println("Quanti oggetti vuoi comprare?");
        int lunghezzacarrello = Integer.parseInt(scan.nextLine());
        Prodotto[] cart = new Prodotto[lunghezzacarrello];
        BigDecimal cartSum = new BigDecimal("0.00");



        for(int i = 0; i < lunghezzacarrello; i++){
            System.out.println("Cosa vuoi comprare? 1 Smartphone, 2 TV, 3 Cuffie");
            sceltaOggetto = Integer.parseInt(scan.nextLine());
            if (sceltaOggetto == 1){
                System.out.println("Inserisci Nome, Descrizione, Prezzo e Storage del prodotto");
                nomeProdotto = scan.nextLine();
                descrizioneProdotto = scan.nextLine();
                prezzo = new BigDecimal(scan.nextLine());
                storage = Integer.parseInt(scan.nextLine());
                Smartphone smartphone = new Smartphone(nomeProdotto, descrizioneProdotto,prezzo,storage);
                cart[i] = smartphone;
            } else if (sceltaOggetto == 2){
                System.out.println("Inserisci Nome, Descrizione, Prezzo, Dimensione in pollici e se la TV è smart");
                nomeProdotto = scan.nextLine();
                descrizioneProdotto = scan.nextLine();
                prezzo = new BigDecimal(scan.nextLine());
                dimensione = new BigDecimal(scan.nextLine());
                isSmart = scan.nextLine().equalsIgnoreCase("si") ? true : false;
                TV televisione = new TV(nomeProdotto, descrizioneProdotto,prezzo,dimensione,isSmart);
                cart[i] = televisione;
            } else if (sceltaOggetto == 3){
                System.out.println("Inserisci Nome, Descrizione, Prezzo, Colore e Tipo di connettività");
                nomeProdotto = scan.nextLine();
                descrizioneProdotto = scan.nextLine();
                prezzo = new BigDecimal(scan.nextLine());
                colore = scan.nextLine();
                wired = scan.nextLine().equalsIgnoreCase("wireless") ? false : true;
                Cuffie cuffie = new Cuffie(nomeProdotto, descrizioneProdotto,prezzo,colore,wired);
                cart[i] = cuffie;
            } else {
                System.out.println("Comando sconosciuto");
                i--;
            }
        }

        scan.close();
        System.out.println("Ecco i prodotti nel tuo carrello:");
        for (Prodotto product: cart) {
            System.out.println(product);
            cartSum = cartSum.add(product.computeDiscount());
        }
        System.out.println("Totale: " + cartSum + "€");



    }
}
