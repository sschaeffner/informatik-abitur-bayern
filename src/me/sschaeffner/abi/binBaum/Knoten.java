package me.sschaeffner.abi.binBaum;

/**
 * @author sschaeffner
 */
class Knoten extends Baumelement {
    private Datenelement daten;
    private Baumelement linkerNachfolger, rechterNachfolger;

    public Knoten(Datenelement daten, Baumelement linkerNachfolger, Baumelement rechterNachfolger) {
        this.daten = daten;
        this.linkerNachfolger = linkerNachfolger;
        this.rechterNachfolger = rechterNachfolger;
    }

    public Knoten(Datenelement daten) {
        this(daten, new Abschluss(), new Abschluss());
    }

    @Override
    Datenelement suchen(String schluessel) {
        if (this.daten.schluesselIstGleich(schluessel)) {
            return this.daten;
        } else if (this.daten.schluesselIstGroesserAls(schluessel)) {
            return this.linkerNachfolger.suchen(schluessel);
        } else {
            return this.rechterNachfolger.suchen(schluessel);
        }
    }

    @Override
    Baumelement einfuegen(Datenelement daten) {
        if (this.daten.istGleich(daten)) {
            System.err.println("Datenelement schon im Baum vorhanden. Kann nicht erneut eingefügt werden!");
        } else if (this.daten.istKleinerAls(daten)) {
            this.rechterNachfolger = this.rechterNachfolger.einfuegen(daten);
        } else {
            this.linkerNachfolger = this.linkerNachfolger.einfuegen(daten);
        }
        return this;
    }

    @Override
    String preorderAusgabe(int depth) {
        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "\t";
        }
        return tabs + this.daten.schluesselGeben() + System.lineSeparator() + this.linkerNachfolger.preorderAusgabe(depth + 1) + System.lineSeparator() + this.rechterNachfolger.preorderAusgabe(depth + 1);
    }

    @Override
    String inorderAusgabe() {
        return this.linkerNachfolger.inorderAusgabe() + " " + this.daten + " " + this.rechterNachfolger.inorderAusgabe();
    }

    @Override
    String postorderAusgabe() {
        return this.linkerNachfolger.postorderAusgabe() + " " + this.rechterNachfolger.postorderAusgabe() + " " + this.daten.schluesselGeben();
    }

    @Override
    public String toString() {
        return "Knoten(" + linkerNachfolger + "; " + daten + " ; " + rechterNachfolger + ") ";
    }
}
