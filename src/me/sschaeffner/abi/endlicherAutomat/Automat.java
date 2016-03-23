package me.sschaeffner.abi.endlicherAutomat;

/**
 * Implementation eines erkennenden endlichen Automaten.
 *
 * Methodennamen nach Brichzin, Freiberger, Reinold und Wiedemann, "Informatik - Oberstufe 2" (Oldenbourg, 2010)
 *
 * @author sschaeffner
 */
public class Automat {

    private int zustand;

    /**
     * Konstruiert einen Automaten in seinem Startzustand.
     */
    public Automat() {
        this.zustand = 1;
    }

    /**
     * Überprüft einen ganzen String darauf, ob er vom Automat akzeptiert wird.
     *
     * @param eingabe   zu überprüfender String
     * @return          ob die Eingabe akzeptiert wurde
     */
    public boolean istEingabeAkzeptiert(String eingabe) {
        char[] zeichen = eingabe.toCharArray();
        for (char c : zeichen) {
            zeicheneingabeWeiterleiten(c);
        }
        return istInEndzustand();
    }

    /**
     * Gibt den aktuellen Zustand zurück.
     * @return aktueller Zustand
     */
    public int gebeZustand() {
        return this.zustand;
    }

    /**
     * Setzt den Automat auf seinen Startzustand zurück.
     */
    public void zuruecksetzen() {
        this.zustand = 1;
    }

    private void zeicheneingabeWeiterleiten(char zeichen) {
        switch (this.zustand) {
            case 1:
                z1ZeicheneingabeBearbeiten(zeichen);
                break;
            case 2:
                z2ZeicheneingabeBearbeiten(zeichen);
                break;
            case 3:
                z3ZeicheneingabeBearbeiten(zeichen);
                break;
            case 4:
                z4ZeicheneingabeBearbeiten(zeichen);
                break;
            case 5:
                z5ZeicheneingabeBearbeiten(zeichen);
                break;
            case 6:
                z6ZeicheneingabeBearbeiten(zeichen);
                break;
            case 7:
                z7ZeicheneingabeBearbeiten(zeichen);
                break;
            default:
                throw new IllegalStateException("Automat ist im unbekannten Zustand " + this.zustand + " gefangen. Zeicheneingabe kann nicht weiter überprüft werden!");
        }
    }

    private void z1ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 2;
                break;
            case Ziffer:
                this.zustand = 3;
                break;
            case Punkt:
                this.zustand = 7;
                break;
        }
    }

    private void z2ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 7;
                break;
            case Ziffer:
                this.zustand = 4;
                break;
            case Punkt:
                this.zustand = 7;
                break;
        }
    }

    private void z3ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 5;
                break;
            case Ziffer:
                this.zustand = 7;
                break;
            case Punkt:
                this.zustand = 7;
                break;
        }
    }

    private void z4ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 4;//selbst
                break;
            case Ziffer:
                this.zustand = 7;
                break;
            case Punkt:
                this.zustand = 6;
                break;
        }
    }

    private void z5ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 7;
                break;
            case Ziffer:
                this.zustand = 5;//selbst
                break;
            case Punkt:
                this.zustand = 6;
                break;
        }
    }

    private void z6ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 7;
                break;
            case Ziffer:
                this.zustand = 7;
                break;
            case Punkt:
                this.zustand = 7;
                break;
        }
    }

    private void z7ZeicheneingabeBearbeiten(char zeichen) {
        switch (ZeichenTyp.gibZeichenTypFuer(zeichen)) {
            case Buchstabe:
                this.zustand = 7;
                break;
            case Ziffer:
                this.zustand = 7;
                break;
            case Punkt:
                this.zustand = 7;
                break;
        }
    }

    private boolean istInEndzustand() {
        return this.zustand == 6;
    }

    private enum ZeichenTyp {
        Buchstabe, Ziffer, Punkt, Anderes;

        public static ZeichenTyp gibZeichenTypFuer(char zeichen) {
            if (zeichen >= 'a' && zeichen <= 'z') {
                return Buchstabe;
            } else if (zeichen >= '0' && zeichen <= '1') {
                return Ziffer;
            } else if (zeichen == '.') {
                return Punkt;
            } else {
                return Anderes;
            }
        }
    }
}
