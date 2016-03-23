package me.sschaeffner.abi.liste;

/**
 * @author sschaeffner
 */
class Abschluss extends Listenelement {
    @Override
    Listenelement hintenEinfuegen(Datenelement daten) {
        Knoten k = new Knoten(daten, this);
        return k;
    }

    @Override
    Listenelement einfuegenVor(Datenelement daten, Datenelement vor) {
        return this;
    }

    @Override
    Listenelement sortiertEinfuegen(Datenelement daten) {
        return new Knoten(daten, this);
    }

    @Override
    Listenelement knotenEntfernen(Datenelement daten) {
        return this;
    }

    @Override
    Datenelement endeGeben(Datenelement daten) {
        return daten;
    }

    @Override
    Listenelement endeEntfernen(Datenelement daten) {
        return this;
    }

    @Override
    Datenelement datenelementGeben() {
        return null;
    }

    @Override
    Listenelement nachfolgerGeben() {
        return this;
    }

    @Override
    Datenelement suchen(String schluessel) {
        return null;
    }

    @Override
    void informationAusgeben() {

    }

    @Override
    int restlaengeGeben() {
        return 0;
    }

    @Override
    public String toString() {
        return "Abschluss()";
    }
}
