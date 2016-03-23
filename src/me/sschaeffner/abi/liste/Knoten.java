package me.sschaeffner.abi.liste;

/**
 * @author sschaeffner
 */
class Knoten extends Listenelement {
    private Datenelement daten;
    private Listenelement nachfolger;

    Knoten(Datenelement daten, Listenelement nachfolger) {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    @Override
    Listenelement hintenEinfuegen(Datenelement daten) {
        this.nachfolger = this.nachfolger.hintenEinfuegen(daten);
        return this;
    }

    @Override
    Listenelement einfuegenVor(Datenelement daten, Datenelement vor) {
        if (this.daten.schluesselIstGleich(vor.schluesselGeben())) {
            return new Knoten(daten, this);
        } else {
            this.nachfolger = this.nachfolger.einfuegenVor(daten, vor);
            return this;
        }
    }

    @Override
    Listenelement sortiertEinfuegen(Datenelement daten) {
        if (this.daten.istKleinerAls(daten)) {
            this.nachfolger = this.nachfolger.sortiertEinfuegen(daten);
            return this;
        } else {
            return new Knoten(daten, this);
        }
    }

    @Override
    Listenelement knotenEntfernen(Datenelement daten) {
        if (this.daten.schluesselIstGleich(daten.schluesselGeben())) {
            return this.nachfolger;
        } else {
            this.nachfolger = this.nachfolger.knotenEntfernen(daten);
            return this;
        }
    }

    @Override
    Datenelement endeGeben(Datenelement daten) {
        return this.nachfolger.endeGeben(this.daten);
    }

    @Override
    Listenelement endeEntfernen(Datenelement daten) {
        if (this.daten.schluesselIstGleich(daten.schluesselGeben())) {
            return this.nachfolger;
        } else {
            this.nachfolger = this.nachfolger.endeEntfernen(daten);
            return this;
        }
    }

    @Override
    Datenelement datenelementGeben() {
        return this.daten;
    }

    @Override
    Listenelement nachfolgerGeben() {
        return this.nachfolger;
    }

    @Override
    Datenelement suchen(String schluessel) {
        if (this.daten.schluesselIstGleich(schluessel)) {
            return this.daten;
        } else {
            return this.nachfolger.suchen(schluessel);
        }
    }

    @Override
    void informationAusgeben() {
        System.out.println(this);
    }

    @Override
    int restlaengeGeben() {
        return this.nachfolger.restlaengeGeben() + 1;
    }

    @Override
    public String toString() {
        return "Knoten(" + this.daten + ") " + nachfolger;
    }
}
