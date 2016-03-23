package me.sschaeffner.abi.liste.test;

import me.sschaeffner.abi.liste.Datenelement;
import me.sschaeffner.abi.liste.DatenelementImpl;
import me.sschaeffner.abi.liste.Liste;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit4 Tests für alle von außen sichtbaren Methoden der Liste.
 *
 * @author sschaeffner
 */
public class ListeTest {

    @Test
    public void constructionTest() {
        Liste l = new Liste();
        Assert.assertNotNull(l);
        Assert.assertEquals("Liste(Abschluss())", l.toString());
    }

    @Test
    public void vorneEinfuegenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");
        l.vorneEinfuegen(daten1);
        l.vorneEinfuegen(daten2);
        l.vorneEinfuegen(daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"3\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"1\")) Abschluss())", l.toString());
    }

    @Test
    public void hintenEinfuegenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");
        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten2);
        l.hintenEinfuegen(daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());
    }

    @Test
    public void laengeGebenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");

        Assert.assertEquals(0, l.laengeGeben());

        l.hintenEinfuegen(daten1);
        Assert.assertEquals(1, l.laengeGeben());

        l.hintenEinfuegen(daten2);
        Assert.assertEquals(2, l.laengeGeben());

        l.hintenEinfuegen(daten3);
        Assert.assertEquals(3, l.laengeGeben());
    }

    @Test
    public void suchenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");

        Assert.assertNull(l.suchen("0"));
        Assert.assertNull(l.suchen("1"));

        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten2);
        l.hintenEinfuegen(daten3);

        Assert.assertNull(l.suchen("0"));
        Assert.assertEquals(daten1, l.suchen("1"));
        Assert.assertEquals(daten2, l.suchen("2"));
        Assert.assertEquals(daten3, l.suchen("3"));
    }

    @Test
    public void anfangEntfernenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");

        Assert.assertNull(l.anfangEntfernen());
        Assert.assertNull(l.anfangEntfernen());

        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten2);
        l.hintenEinfuegen(daten3);

        Assert.assertEquals(daten1, l.anfangEntfernen());
        Assert.assertEquals(daten2, l.anfangEntfernen());
        Assert.assertEquals(daten3, l.anfangEntfernen());
        Assert.assertNull(l.anfangEntfernen());
        Assert.assertNull(l.anfangEntfernen());
        Assert.assertNull(l.anfangEntfernen());
    }

    @Test
    public void endeEntfernenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");

        Assert.assertNull(l.endeEntfernen());
        Assert.assertNull(l.endeEntfernen());

        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten2);
        l.hintenEinfuegen(daten3);

        Assert.assertEquals(daten3, l.endeEntfernen());
        Assert.assertEquals(daten2, l.endeEntfernen());
        Assert.assertEquals(daten1, l.endeEntfernen());
        Assert.assertNull(l.endeEntfernen());
        Assert.assertNull(l.endeEntfernen());
        Assert.assertNull(l.endeEntfernen());
    }

    @Test
    public void knotenEntfernenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");

        Assert.assertEquals("Liste(Abschluss())", l.toString());

        l.knotenEntfernen(daten1);
        Assert.assertEquals("Liste(Abschluss())", l.toString());

        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten2);
        l.hintenEinfuegen(daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.knotenEntfernen(daten2);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.knotenEntfernen(daten1);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.knotenEntfernen(daten3);
        Assert.assertEquals("Liste(Abschluss())", l.toString());
    }

    @Test
    public void einfuegenVorTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");
        Datenelement daten4 = new DatenelementImpl("4");
        Assert.assertEquals("Liste(Abschluss())", l.toString());

        l.einfuegenVor(daten1, daten2);
        Assert.assertEquals("Liste(Abschluss())", l.toString());

        l.hintenEinfuegen(daten1);
        l.hintenEinfuegen(daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.einfuegenVor(daten2, daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.einfuegenVor(daten4, daten2);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"4\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());
    }

    @Test
    public void sortiertEinfuegenTest() {
        Liste l = new Liste();
        Datenelement daten1 = new DatenelementImpl("1");
        Datenelement daten2 = new DatenelementImpl("2");
        Datenelement daten3 = new DatenelementImpl("3");
        Datenelement daten4 = new DatenelementImpl("4");
        Assert.assertEquals("Liste(Abschluss())", l.toString());

        l.sortiertEinfuegen(daten3);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.sortiertEinfuegen(daten1);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"3\")) Abschluss())", l.toString());

        l.sortiertEinfuegen(daten4);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"3\")) Knoten(DatenelementImpl(\"4\")) Abschluss())", l.toString());

        l.sortiertEinfuegen(daten2);
        Assert.assertEquals("Liste(Knoten(DatenelementImpl(\"1\")) Knoten(DatenelementImpl(\"2\")) Knoten(DatenelementImpl(\"3\")) Knoten(DatenelementImpl(\"4\")) Abschluss())", l.toString());
    }
}