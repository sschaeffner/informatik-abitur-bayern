package me.sschaeffner.abi.erzeugerVerbraucher.Test;

import me.sschaeffner.abi.erzeugerVerbraucher.Erzeuger;
import me.sschaeffner.abi.erzeugerVerbraucher.Speicher;
import me.sschaeffner.abi.erzeugerVerbraucher.Verbraucher;

/**
 * @author sschaeffner
 */
public class ErzeugerVerbraucherTest {
    public static void main(String[] args) {
        new ErzeugerVerbraucherTest().start(10000);
    }


    private final Speicher s;
    private final Erzeuger e;
    private final Verbraucher v;

    private ErzeugerVerbraucherTest() {
        s = new Speicher();
        e = new Erzeuger(s);
        v = new Verbraucher(s);
    }

    private void start(int time) {
        e.start();
        v.start();

        new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            e.stop();
            v.stop();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }).start();
    }
}