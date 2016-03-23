package me.sschaeffner.abi.erzeugerVerbraucher;

/**
 * Implementation eines Speichers mit einer einzigen Speicherzelle (Erzeuger-Verbraucher-Problem).
 *
 * Die ablegen() und holen() Methoden blockieren so lange bis sie ihre Aufgabe erfüllen können.
 *
 * @author sschaeffner
 */
public class Speicher {
    private SpeicherbaresObjekt speicher;

    public Speicher() {
        this.speicher = null;
    }

    /**
     * Legt ein SpeicherbaresObjekt im Speicher ab.
     *
     * Blockiert solange, bis das Objekt abgelegt werden kann, also der Speicher leer war.
     *
     * @param speicher abzulegendes Objekt
     */
    public synchronized void ablegen(SpeicherbaresObjekt speicher) {
        while (speicherIstVoll()) {
            System.out.println("Speicher: voll -> wait()");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.speicher = speicher;
        this.notifyAll();
    }

    /**
     * Holt ein SpeicherbaresObjekt aus dem Speicher.
     *
     * Blockiert solange, bis ein Objekt geholt werden kann, also bis der Speicher gefüllt war.
     *
     * @return geholtes Objekt
     */
    public synchronized SpeicherbaresObjekt holen() {
        while (speicherIstLeer()) {
            System.out.println("Speicher: leer -> wait()");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SpeicherbaresObjekt speicher = this.speicher;
        this.speicher = null;
        this.notifyAll();

        return speicher;
    }

    private boolean speicherIstLeer() {
        return this.speicher == null;
    }

    private boolean speicherIstVoll() {
        return this.speicher != null;
    }
}
