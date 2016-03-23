package me.sschaeffner.abi.graph;

/**
 * @author sschaeffner
 */
public class GraphelementImpl implements Graphelement {
    private String name;

    public GraphelementImpl(String name) {
        this.name = name;
    }

    @Override
    public String nameGeben() {
        return this.name;
    }

    @Override
    public boolean istGleich(Graphelement element) {
        return this.name.equals(element.nameGeben());
    }
}
