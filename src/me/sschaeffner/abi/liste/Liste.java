package me.sschaeffner.abi.liste;

/**
 * Implementation einer Liste im perfekten Kompositum.
 *
 * Methodennamen nach Brichzin, Freiberger, Reinold und Wiedemann, "Informatik - Oberstufe 1" (Oldenbourg, 2009)
 *
 * @author sschaeffner
 */
public class Liste {
    private Listenelement anfang;

    /**
     * Konstruiert eine leere Liste.
     */
    public Liste() {
        anfang = new Abschluss();
    }

    /**
     * Fügt einen neuen Knoten mit gegebenem Datenelement an die erste Stelle der Liste ein.
     *
     * @param daten einzufügendes Datenelement
     */
    public void vorneEinfuegen(Datenelement daten) {
        Listenelement alterAnfang = anfang;
        anfang = new Knoten(daten, alterAnfang);
    }

    /**
     * Fügt einen neuen Knoten mit gegebenem Datenelement an die letzte Stelle der Liste ein.
     *
     * @param daten einzufügendes Datenelement
     */
    public void hintenEinfuegen(Datenelement daten) {
        this.anfang = this.anfang.hintenEinfuegen(daten);
    }

    /**
     * Fügt einen neuen Knoten mit gegebenem Datenelement vor einen Knoten mit gegebenem Datenelement ein.
     *
     * @param daten einzufügendes Datenelement
     * @param vor   Datenelement, vor dessen Knoten der neue Knoten einzufügen ist
     */
    public void einfuegenVor(Datenelement daten, Datenelement vor) {
        this.anfang = this.anfang.einfuegenVor(daten, vor);
    }

    /**
     * Fügt einen neuen Knoten mit gegebenem Datenelement so ein, dass eine sortierte Liste entsteht,
     * wenn alle Datenelemente auf diese Weise eingefügt werden.
     *
     * @param daten einzufügendes Datenelement
     */
    public void sortiertEinfuegen(Datenelement daten) {
        this.anfang = this.anfang.sortiertEinfuegen(daten);
    }

    /**
     * Entfernt einen Knoten mit einem gegebenem Datenelement.
     *
     * Diese Methode entfernt nur das erste Vorkommnis eines Knoten mit dem gegebenen Datenelement.
     *
     * @param daten Datenelement, dessen Knoten zu entfernen ist
     */
    public void knotenEntfernen(Datenelement daten) {
        this.anfang = this.anfang.knotenEntfernen(daten);
    }

    /**
     * Entfernt den ersten Knoten der Liste und gibt dessen Datenelement zurück.
     *
     * @return Datenelement des ersten Knoten der Liste oder null wenn die Liste leer war
     */
    public Datenelement anfangEntfernen() {
        Listenelement alterAnfang = anfang;
        this.anfang = alterAnfang.nachfolgerGeben();

        return alterAnfang.datenelementGeben();
    }

    /**
     * Entfernt den letzten Knoten der Liste und gibt dessen Datenelement zurück.
     *
     * @return Datenelement des letzten Knoten der Liste oder null wenn die Liste leer war
     */
    public Datenelement endeEntfernen() {
        Datenelement datenEnde = this.anfang.endeGeben(null);
        this.anfang = this.anfang.endeEntfernen(datenEnde);

        return datenEnde;
    }

    /**
     * Sucht ein Datenelement mit einem gegebenen Schlüssel in der Liste und gibt das Datenelement gegebenenfalls zurück.
     *
     * @param schluessel    Schlüssel, nach dem gesucht werden soll
     * @return              Datenelement, das zum gegebenen Schlüssel passt, oder null
     *                          wenn kein passendes Datenelement gefunden werden konnte
     */
    public Datenelement suchen(String schluessel) {
        return this.anfang.suchen(schluessel);
    }

    /**
     * Gibt Informationen über sich selbst auf der Standardausgabe aus.
     */
    public void informationAusgeben() {
        System.out.println(this);
    }

    /**
     * Gibt die Länge der Liste bzw. die Anzahl aller Knoten in der Liste zurück.
     *
     * @return die Länge der Liste
     */
    public int laengeGeben() {
        return this.anfang.restlaengeGeben();
    }

    @Override
    public String toString() {
        return "Liste(" + anfang + ")";
    }
}
