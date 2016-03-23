package me.sschaeffner.abi.liste;

/**
 * @author sschaeffner
 */
abstract class Listenelement {
    abstract Listenelement hintenEinfuegen(Datenelement daten);
    abstract Listenelement einfuegenVor(Datenelement daten, Datenelement vor);
    abstract Listenelement sortiertEinfuegen(Datenelement daten);
    abstract Listenelement knotenEntfernen(Datenelement daten);
    abstract Datenelement endeGeben(Datenelement daten);
    abstract Listenelement endeEntfernen(Datenelement daten);
    abstract Datenelement datenelementGeben();
    abstract Listenelement nachfolgerGeben();
    abstract Datenelement suchen(String schluessel);
    abstract void informationAusgeben();
    abstract int restlaengeGeben();
    @Override
    abstract public String toString();
}
