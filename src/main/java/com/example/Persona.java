package com.example;
/**La classe Persona aiuta la sviluppatore a gestire dati di tipo Persona 
 * @since JDK1.0
*/
public class Persona {
    
    private String nome;
    private String cognome;
    private String codice;

    /**
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata un'eccezione.
     * <br>
     * <b>CONTROLLO sul CODICE FISCALE:</b>
     * <ul>
     *  <li>Il codice deve contenere 16 caratteri alfanumerici
     *  <li>Il codice non deve contenere spazi
     *  <li>I primi 6 caratteri devono essere delle consonanti
     *  <li>Settimo e ottavo carattere devono essere numeri
     * </ul>
     * Consulta <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html">la Documentazione ufficiale String</a>
     * @param nome stringa qualsiasi da assegnare come nome di un nuovo oggetto Persona
     * @param cognome stringa qualsiasi da assegnare come cognome di un nuovo oggetto Persona
     * @param codice stringa che rappresenta il nuovo codice fiscale dell'oggetto Persona
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

    /*
    Controlla che il codice fiscale sia lungo 16 caratteri, 
    che non contenga spazi, che i primi 6 caratteri siano consonanti 
    e che il settimo e ottavo carattere siano numeri
    */
    private boolean controlloCodiceFiscale(String codice){
        return codice.length() == 16 && !codice.contains(" ") && this.controlloConsonanti(codice) && this.controlloCarattereSetteEOtto(codice);
    }

    /*
    Metodo che controlla che i primi 6 caratteri siano consonanti
    */
    private boolean controlloConsonanti(String codice){
        for(int i = 0; i<6; i++){
            char ch = codice.charAt(i);
            if(!(ch >= 'a' && ch <= 'z' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'  && ch != 'y')){
                return false;
            }
        }
        return true;
    }

    /*
    Metodo che controlla che il settimo e ottavo carattere siano numeri
    */
    private boolean controlloCarattereSetteEOtto(String codice){
        for (int i = 6; i < 8; i++) {
            char ch = codice.charAt(i);
            if (!(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Restituisce una Stringa contenente il nome della persona
     * @return il nome di un oggetto Persona
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Assegna una Stringa come nome di una persona
     * @param nome Stringa da assegnare come nome
     */ 

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce una Stringa contenente il cognome della persona
     * @return il cognome di un oggetto Persona
     */
    public String getCognome(){
        return this.cognome;
    }

    /**
     * Assegna una Stringa come cognome di una persona
     * @param cognome nuova stringa da assegnare come cognome a un oggetto Persona gia'  esistente
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Il metodo stabilisce se due persone sono omonime; Restituisce un booleano: VERO se le due persone hanno lo stesso nome (senza distinzione di maiuscole e minuscole) altrimenti FALSO
     * @param p Oggetto Persona
     * @return Vero se le due persone confrontate hanno lo stesso nome, altrimenti falso
     */

    public boolean isOmonimo(Persona p){
        return this.nome.equalsIgnoreCase(p.getNome());
    }

    /**
     * Restituisce una rappresentazione testuale di un oggetto Persona, nel seguente formato "NOME:xx COGNOME:xx CF:xx"
     * @return La rappresentazione testuale di un oggetto Persona
     */
    @Override
    public String toString(){
        return "NOME: " + this.nome + "COGNOME: " + this.cognome + "CF: " + this.codice;
    }
    

}
