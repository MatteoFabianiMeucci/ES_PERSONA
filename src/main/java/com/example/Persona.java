package com.example;
public class Persona {
    /**La classe Persona aiuta la sviluppatore a gestire dati di tipo Persona */
    private String nome;
    private String cognome;
    private String codice;

    /**
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata un'eccezione.
     * <b>CONTROLLO sul CODICE FISCALE:</b>
     * <ul>
     *  <li>Il codice deve contenere 16 caratteri alfanumerici
     *  <li>Il codice non deve contenere spazi
     *  <li>I primi 6 caratteri devono essere delle consonanti
     *  <li>Settimo e ottavo carattere devono essere numeri
     * </ul>
     * @param nome stringa qualsiasi da assegnare come nome di un nuovo oggetto Persona
     * @param cognome stringa qualsiasi da assegnare come cognome di un nuovo oggetto Persona
     * @param codice stringa che rappresenta il nuovo codice fiscale dell'oggetto Persona
     * Consulta <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html">la Documentazione ufficiale String</a>
     * @throws IllegalArgumentException Se il codice fiscale fornito non e' valido
     */

    public Persona(String nome, String cognome, String codice){
        this.nome = nome;
        this.cognome = cognome;
        if (controlloCodiceFiscale(codice.toLowerCase())) {
            this.codice = codice.toUpperCase();
        }else{
            IllegalArgumentException e = new IllegalArgumentException();
            throw e;
        }
        
    }

    private boolean controlloCodiceFiscale(String codice){
        return codice.length() == 16 && !codice.contains(" ") && this.controlloConsonanti(codice) && this.controlloCarattereSetteEOtto(codice);
    }

    private boolean controlloConsonanti(String codice){
        for(int i = 0; i<6; i++){
            char ch = codice.charAt(i);
            if(!(ch >= 'a' && ch <= 'z' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'  && ch != 'y')){
                return false;
            }
        }
        return true;
    }

    private boolean controlloCarattereSetteEOtto(String codice){
        for (int i = 6; i < 8; i++) {
            char ch = codice.charAt(i);
            if (!(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9')) {
                return false;
            }
        }
        return true;
    }
}
