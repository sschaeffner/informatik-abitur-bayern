package me.sschaeffner.abi.binBaum;

/**
 * Implementation eines Binärbaums im Kompositum.
 *
 * Methodennamen nach Brichzin, Freiberger, Reinold und Wiedemann, "Informatik - Oberstufe 1" (Oldenbourg, 2009)
 *
 * @author sschaeffner
 */
public class BinBaum {
    private Baumelement wurzel;

    /**
     * Konstruiert einen leeren Baum.
     */
    public BinBaum() {
        this.wurzel = new Abschluss();
    }

    /**
     * Sucht im Baum nach einem Datenelement mit einem gegebenen Schlüssel.
     *
     * @param schluessel    Schlüssel, nach dem gesucht werden soll
     * @return              Datenelement, das zum gegebenen Schlüssel passt, oder null
     *                          wenn kein Datenelement gefunden werden konnte
     */
    public Datenelement suchen(String schluessel) {
        return this.wurzel.suchen(schluessel);
    }

    /**
     * Fügt einen neuen Knoten mit einem gegebenen Datenelement in den Baum ein, so dass ein sortierter Baum entsteht.
     *
     * @param daten einzufügendes Datenelement
     */
    public void einfuegen(Datenelement daten) {
        this.wurzel = this.wurzel.einfuegen(daten);
    }

    /**
     * Gibt den Baum nach dem preorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach preorder Verfahren
     */
    public String preorderAusgabe() {
        return this.wurzel.preorderAusgabe(0);
    }

    /**
     * Gibt den Baum nach dem inorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach inorder Verfahren
     */
    public String inorderAusgabe() {
        return this.wurzel.inorderAusgabe();
    }

    /**
     * Gibt den Baum nach dem postorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach postorder Verfahren
     */
    public String postorderAusgabe() {
        return this.wurzel.postorderAusgabe();
    }

    @Override
    public String toString() {
        return "BinBaum(" + wurzel + ")";
    }
}
