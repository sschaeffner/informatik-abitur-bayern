package me.sschaeffner.abi.erzeugerVerbraucher;

/**
 * @author sschaeffner
 */
public class SpeicherbaresObjektImpl implements SpeicherbaresObjekt {
    private final String name;

    public SpeicherbaresObjektImpl(String name) {
        this.name = name;
    }

    @Override
    public String gibName() {
        return this.name;
    }
}
