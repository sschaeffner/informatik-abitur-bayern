package me.sschaeffner.abi.binBaum;

/**
 * @author sschaeffner
 */
class Abschluss extends Baumelement {
    @Override
    Datenelement suchen(String schluessel) {
        return null;
    }

    @Override
    Baumelement einfuegen(Datenelement daten) {
        return new Knoten(daten, this, this);
    }

    @Override
    String preorderAusgabe(int depth) {
        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "\t";
        }
        return tabs + "Abschluss";
    }

    @Override
    String inorderAusgabe() {
        return "";
    }

    @Override
    String postorderAusgabe() {
        return "";
    }

    @Override
    public String toString() {
        return "Abschluss() ";
    }
}
