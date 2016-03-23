package me.sschaeffner.abi.binBaum;

/**
 * @author sschaeffner
 */
abstract class Baumelement {
    abstract Datenelement suchen(String schluessel);
    abstract Baumelement einfuegen(Datenelement daten);
    abstract String preorderAusgabe(int depth);
    abstract String inorderAusgabe();
    abstract String postorderAusgabe();
    @Override
    abstract public String toString();
}
