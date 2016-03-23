package me.sschaeffner.abi.erzeugerVerbraucher;

/**
 * @author sschaeffner
 */
public class Verbraucher {
    private final Speicher s;
    private final Thread t;
    private boolean running;

    public Verbraucher(Speicher s) {
        this.s = s;
        this.running = false;
        t = new Thread(() -> {
            while(this.running) {
                SpeicherbaresObjekt objekt = s.holen();
                System.out.println("Verbraucher: Objekt " + objekt.gibName() + " geholt");
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void start() {
        this.running = true;
        t.start();
    }

    public void stop() {
        this.running = false;
    }
}
