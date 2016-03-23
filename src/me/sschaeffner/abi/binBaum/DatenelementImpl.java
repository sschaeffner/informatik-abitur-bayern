package me.sschaeffner.abi.binBaum;

/**
 * @author sschaeffner
 */
public class DatenelementImpl implements Datenelement {
    private String schluessel;

    public DatenelementImpl(String schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public void informationAusgeben() {
        System.out.println(this);
    }

    @Override
    public boolean istKleinerAls(Datenelement daten) {
        return this.schluessel.compareTo(daten.schluesselGeben()) < 0;
    }

    @Override
    public boolean istGroesserAls(Datenelement daten) {
        return this.schluessel.compareTo(daten.schluesselGeben()) > 0;
    }

    @Override
    public boolean schluesselIstGleich(String schluessel) {
        return this.schluessel.equals(schluessel);
    }

    @Override
    public boolean schluesselIstGroesserAls(String schluessel) {
        return this.schluessel.compareTo(schluessel) > 0;
    }

    @Override
    public boolean istGleich(Datenelement daten) {
        return this.schluesselIstGleich(daten.schluesselGeben());
    }

    @Override
    public String schluesselGeben() {
        return this.schluessel;
    }

    @Override
    public String toString() {
        return "DatenelementImpl(\"" + this.schluessel + "\")";
    }
}
