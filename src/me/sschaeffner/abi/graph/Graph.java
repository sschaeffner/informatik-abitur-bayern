package me.sschaeffner.abi.graph;

/**
 * Implementation eines Graphen mithilfe einer Adjazenzmatrix.
 *
 * Methodennamen nach Brichzin, Freiberger, Reinold und Wiedemann, "Informatik - Oberstufe 1" (Oldenbourg, 2009)
 *
 * @author sschaeffner
 */
public class Graph {
    private int anzahlKnoten;
    private Graphelement[] knotenListe;
    private int[][] matrix;

    /**
     * Konstruiert einen leeren Graphen.
     *
     * Jeder Knoten hat eine Kante zu sich selbst mit dem Gewicht 0.
     */
    public Graph(int groesse) {
        this.anzahlKnoten = groesse;
        this.knotenListe = new Graphelement[this.anzahlKnoten];
        this.matrix = new int[this.anzahlKnoten][this.anzahlKnoten];

        for (int i1 = 0; i1 < this.anzahlKnoten; i1++) {
            for (int i2 = 0; i2 < this.anzahlKnoten; i2++) {
                this.matrix[i1][i2] = -1;
            }
        }

        for (int i = 0; i < this.anzahlKnoten; i++) {
            this.matrix[i][i] = 0;
        }
    }

    /**
     * Fügt einen neuen Knoten ein.
     *
     * @param knoten einzufügender Knoten
     */
    public void knotenEinfuegen(Graphelement knoten) {
        int ersterFreierPlatz = -1;
        for (int i = 0; i < knotenListe.length; i++) {
            if (ersterFreierPlatz == -1 && knotenListe[i] == null) ersterFreierPlatz = i;
        }

        if (ersterFreierPlatz >= 0) {
            knotenListe[ersterFreierPlatz] = knoten;
        } else {
            System.err.println("Kein freier Platz im Graphen mehr. Knoten (\"" + knoten.nameGeben() + "\") kann nicht hinzugefügt werden!");
        }
    }

    /**
     * Fügt eine Kante von einem zu einem anderen Knoten mit einem bestimmten Gewicht ein.
     *
     * @param von       der Knoten, von dem die Kante ausgehen soll
     * @param nach      der Knoten, zu dem die Kante hingehen soll
     * @param gewicht   das Gewicht der zu erstellenden Kante
     */
    public void kanteEinfuegen(Graphelement von, Graphelement nach, int gewicht) {
        int nrVon = knotenNummer(von);
        int nrNach = knotenNummer(nach);
        if (nrVon >= 0 && nrNach >= 0) {
            this.matrix[nrVon][nrNach] = gewicht;
        } else {
            System.err.println("Graphenelemente nicht gefunden. Kann Kante (" + von.nameGeben() + " -> " + nach.nameGeben() + ": " + gewicht + ") nicht einfügen.");
        }
    }

    /**
     * Fügt eine Kante mit einem bestimmten Gewicht symmetrisch ein, so dass die Kante bidirektional gilt.
     *
     * @param element1  einer der Knoten, zwischen denen die Kante erstellt werden soll
     * @param element2  der andere Knoten, zwischen denen die Kante erstellt werden soll
     * @param gewicht   das Gewicht der zu erstellenden Kante
     */
    public void kanteSymmetrischEinfuegen(Graphelement element1, Graphelement element2, int gewicht) {
        this.kanteEinfuegen(element1, element2, gewicht);
        this.kanteEinfuegen(element2, element1, gewicht);
    }

    /**
     * Gibt das Gewicht einer Kante zwischen zwei Knoten zurück.
     *
     * Besteht keine Kante zwischen den angegebenen Knoten, wird -1 zurückgegeben.
     * Können einer oder beide Graphenelemente nicht als Knoten gefunden werden, wird -2 zurückgegeben.
     *
     * @param von   Knoten, von dem die Kante ausgeht
     * @param nach  Knoten, zu den die Kante hingeht
     * @return      Gewicht der Kante, -1 wenn keine Kante existiert oder -2 wenn die Graphenelemente unbekannt sind
     */
    public int kantenGewichtGeben(Graphelement von, Graphelement nach) {
        int nrVon = knotenNummer(von);
        int nrNach = knotenNummer(nach);
        if (nrVon >= 0 && nrNach >= 0) {
            return this.matrix[nrVon][nrNach];
        } else {
            System.err.println("Graphenelemente (" + von.nameGeben() + " -> " + nach.nameGeben() + ") nicht gefunden. Kann keine Kante finden und kein Gewicht zurückgeben.");
            return -2;
        }
    }

    /**
     * Gibt den Graphen als Adjanzenmatrix aus.
     */
    public void ausgeben() {
        System.out.println(this);
    }

    /**
     * Gibt die Anzahl der maximalen Knoten zurück.
     *
     * @return Anzahl der maximalen Knoten
     */
    public int knotenAnzahlGeben() {
        return anzahlKnoten;
    }

    /**
     * Gibt das Graphenelement für eine bestimmte Knotennummer zurück.
     *
     * @param knotenNummer  Knotennummer des zurückzugebenden Graphenelements
     * @return              Graphenelement mit bestimmter Knotennummer
     */
    public Graphelement knotenGeben(int knotenNummer) {
        return knotenListe[knotenNummer];
    }

    /**
     * Führt eine Tiefensuche mit einem gegebenen Startelement durch.
     *
     * @param start Knoten, bei dem die Tiefensuche gestartet wird
     * @return      welche Knoten alle besucht wurden
     */
    public boolean[] tiefensuche(Graphelement start) {
        int knotenAnzahl = 0;
        for (Graphelement g : knotenListe) {
            knotenAnzahl++;
        }
        boolean[] besucht = new boolean[knotenAnzahl];

        int startNr = knotenNummer(start);
        tiefensucheRekursion(startNr, besucht, knotenAnzahl);

        return besucht;
    }

    private void tiefensucheRekursion(int aktuellerKnoten, boolean[] besucht, int knotenAnzahl) {
        besucht[aktuellerKnoten] = true;

        for (int iNach = 0; iNach < knotenAnzahl; iNach++) {
            int gewicht = this.matrix[aktuellerKnoten][iNach];

            if (gewicht >= 0 && !besucht[iNach]) {
                tiefensucheRekursion(iNach, besucht, knotenAnzahl);
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        int knotenAnzahl = 0;

        int maxNameLength = 0;
        for (Graphelement g : knotenListe) {
            if (g != null) {
                if (g.nameGeben().length() > maxNameLength) maxNameLength = g.nameGeben().length();
                knotenAnzahl++;
            }
        }

        for (int i = 0; i <= maxNameLength; i++) {
            output += " ";
        }

        for (int i = 0; i < knotenAnzahl; i++) {
            output += appendSpacesToLength(knotenListe[i].nameGeben(), maxNameLength) + " ";
        }
        output += System.lineSeparator();

        for (int iVon = 0; iVon < knotenAnzahl; iVon++) {
            output += appendSpacesToLength(knotenListe[iVon].nameGeben(), maxNameLength) + " ";

            for (int iNach = 0; iNach < knotenAnzahl; iNach++) {
                output += prependSpacesToLength(this.matrix[iVon][iNach] + "", maxNameLength) + " ";
            }
            output += System.lineSeparator();
        }

        return output;
    }

    private static String appendSpacesToLength(String s, int length) {
        for (int i = s.length(); i < length; i++) {
            s += " ";
        }
        return s;
    }

    private static String prependSpacesToLength(String s, int length) {
        for (int i = s.length(); i < length; i++) {
            s = " " + s;
        }
        return s;
    }

    private int knotenNummer(Graphelement knoten) {
        for (int i = 0; i < knotenListe.length; i++) {
            if (knotenListe[i].istGleich(knoten)) return i;
        }
        return -1;
    }
}
