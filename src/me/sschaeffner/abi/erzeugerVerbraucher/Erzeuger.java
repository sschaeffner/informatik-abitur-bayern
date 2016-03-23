package me.sschaeffner.abi.erzeugerVerbraucher;

/**
 * @author sschaeffner
 */
public class Erzeuger {

    private final Speicher s;
    private final Thread t;
    private boolean running;

    public Erzeuger(Speicher s) {
        this.s = s;
        this.running = false;
        t = new Thread(() -> {
            while(this.running) {
                String name = "S" + (int)(Math.random() * 999);
                s.ablegen(new SpeicherbaresObjektImpl(name));
                System.out.println("Erzeuger: " + name + " abgelegt");
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
