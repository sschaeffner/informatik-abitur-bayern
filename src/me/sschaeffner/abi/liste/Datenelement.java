package me.sschaeffner.abi.liste;

/**
 * @author sschaeffner
 */
public interface Datenelement {
    void informationAusgeben();
    boolean istKleinerAls(Datenelement daten);
    boolean schluesselIstGleich(String schluessel);
    String schluesselGeben();
}
