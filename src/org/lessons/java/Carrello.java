package org.lessons.java;

import java.math.BigDecimal;
import java.util.Arrays;
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
        String[] cart = new String[lunghezzacarrello];



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
                cart[i] = String.valueOf(smartphone);
            } else if (sceltaOggetto == 2){
                System.out.println("Inserisci Nome, Descrizione, Prezzo, Dimensione in pollici e se la TV è smart");
                nomeProdotto = scan.nextLine();
                descrizioneProdotto = scan.nextLine();
                prezzo = new BigDecimal(scan.nextLine());
                dimensione = new BigDecimal(scan.nextLine());
                isSmart = scan.nextLine().equalsIgnoreCase("si") ? true : false;
                TV televisione = new TV(nomeProdotto, descrizioneProdotto,prezzo,dimensione,isSmart);
                cart[i] = String.valueOf(televisione);
            } else if (sceltaOggetto == 3){
                System.out.println("Inserisci Nome, Descrizione, Prezzo, Colore e Tipo di connettività");
                nomeProdotto = scan.nextLine();
                descrizioneProdotto = scan.nextLine();
                prezzo = new BigDecimal(scan.nextLine());
                colore = scan.nextLine();
                wired = scan.nextLine().equalsIgnoreCase("wireless") ? false : true;
                Cuffie cuffie = new Cuffie(nomeProdotto, descrizioneProdotto,prezzo,colore,wired);
                cart[i] = String.valueOf(cuffie);
            } else {
                System.out.println("Comando sconosciuto");
            }
        }

        scan.close();
        System.out.println(Arrays.toString(cart));
    }
}
