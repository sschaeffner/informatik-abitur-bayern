package me.sschaeffner.abi.binBaum;

/**
 * @author sschaeffner
 */
public interface Datenelement {
    void informationAusgeben();
    boolean istKleinerAls(Datenelement daten);
    boolean istGroesserAls(Datenelement daten);
    boolean schluesselIstGleich(String schluessel);
    boolean schluesselIstGroesserAls(String schluessel);
    boolean istGleich(Datenelement daten);
    String schluesselGeben();
}
