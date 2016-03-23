package me.sschaeffner.abi.graph.test;

import me.sschaeffner.abi.graph.Graph;
import me.sschaeffner.abi.graph.Graphelement;
import me.sschaeffner.abi.graph.GraphelementImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sschaeffner
 */
public class GraphTest {

    @Test
    public void constructionTest() {
        Graph g = new Graph(5);
        Assert.assertNotNull(g);
        Assert.assertEquals(5, g.knotenAnzahlGeben());
    }

    @Test
    public void knotenEinfuegenTest() {
        Graph g = new Graph(5);
        Graphelement element1 = new GraphelementImpl("1");
        Graphelement element2 = new GraphelementImpl("2");
        Graphelement element3 = new GraphelementImpl("3");
        Graphelement element4 = new GraphelementImpl("4");
        Graphelement element5 = new GraphelementImpl("5");
        Graphelement element6 = new GraphelementImpl("6");
        g.knotenEinfuegen(element1);
        g.knotenEinfuegen(element2);
        g.knotenEinfuegen(element3);
        g.knotenEinfuegen(element4);
        g.knotenEinfuegen(element5);

        Assert.assertEquals(element1, g.knotenGeben(0));
        Assert.assertEquals(element2, g.knotenGeben(1));
        Assert.assertEquals(element3, g.knotenGeben(2));
        Assert.assertEquals(element4, g.knotenGeben(3));
        Assert.assertEquals(element5, g.knotenGeben(4));

        System.err.println("--- Fehler beabsichtigt ---");
        g.knotenEinfuegen(element6);
        System.err.println("--- Ende Fehler beabsichtigt ---");
    }

    @Test
    public void kanteEinfuegenTest() {
        Graph g = new Graph(5);
        Graphelement element1 = new GraphelementImpl("1");
        Graphelement element2 = new GraphelementImpl("2");
        Graphelement element3 = new GraphelementImpl("3");
        Graphelement element4 = new GraphelementImpl("4");
        Graphelement element5 = new GraphelementImpl("5");
        g.knotenEinfuegen(element1);
        g.knotenEinfuegen(element2);
        g.knotenEinfuegen(element3);
        g.knotenEinfuegen(element4);
        g.knotenEinfuegen(element5);

        g.kanteEinfuegen(element1, element2, 1);
        Assert.assertEquals(1, g.kantenGewichtGeben(element1, element2));
        Assert.assertEquals(-1, g.kantenGewichtGeben(element2, element1));
    }

    @Test
    public void kanteSymmetrischEinfuegenTest() {
        Graph g = new Graph(5);
        Graphelement element1 = new GraphelementImpl("1");
        Graphelement element2 = new GraphelementImpl("2");
        Graphelement element3 = new GraphelementImpl("3");
        Graphelement element4 = new GraphelementImpl("4");
        Graphelement element5 = new GraphelementImpl("5");
        g.knotenEinfuegen(element1);
        g.knotenEinfuegen(element2);
        g.knotenEinfuegen(element3);
        g.knotenEinfuegen(element4);
        g.knotenEinfuegen(element5);

        g.kanteSymmetrischEinfuegen(element1, element2, 1);
        Assert.assertEquals(1, g.kantenGewichtGeben(element1, element2));
        Assert.assertEquals(1, g.kantenGewichtGeben(element2, element1));
    }

    @Test
    public void ausgabeTest() {
        Graph g = new Graph(5);
        Graphelement element1 = new GraphelementImpl("element1");
        Graphelement element2 = new GraphelementImpl("element2");
        Graphelement element3 = new GraphelementImpl("element3");
        Graphelement element4 = new GraphelementImpl("element4");
        g.knotenEinfuegen(element1);
        g.knotenEinfuegen(element2);
        g.knotenEinfuegen(element3);
        g.knotenEinfuegen(element4);

        g.kanteEinfuegen(element1, element2, 1);

        Assert.assertEquals("         element1 element2 element3 element4 \n" +
                "element1        0        1       -1       -1 \n" +
                "element2       -1        0       -1       -1 \n" +
                "element3       -1       -1        0       -1 \n" +
                "element4       -1       -1       -1        0 \n", g.toString());
    }

    @Test
    public void tiefensucheTest() {
        Graph g = new Graph(5);
        Graphelement element1 = new GraphelementImpl("element1");
        Graphelement element2 = new GraphelementImpl("element2");
        Graphelement element3 = new GraphelementImpl("element3");
        Graphelement element4 = new GraphelementImpl("element4");
        Graphelement element5 = new GraphelementImpl("element5");
        g.knotenEinfuegen(element1);
        g.knotenEinfuegen(element2);
        g.knotenEinfuegen(element3);
        g.knotenEinfuegen(element4);
        g.knotenEinfuegen(element5);

        g.kanteEinfuegen(element1, element2, 1);
        g.kanteEinfuegen(element2, element3, 2);
        g.kanteEinfuegen(element1, element5, 42);
        g.kanteEinfuegen(element3, element2, 1);

        boolean[] besucht = g.tiefensuche(element1);
        Assert.assertTrue(besucht[0]);
        Assert.assertTrue(besucht[1]);
        Assert.assertTrue(besucht[2]);
        Assert.assertFalse(besucht[3]);
        Assert.assertTrue(besucht[4]);
    }
}