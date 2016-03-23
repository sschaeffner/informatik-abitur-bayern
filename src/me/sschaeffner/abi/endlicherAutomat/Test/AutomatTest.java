package me.sschaeffner.abi.endlicherAutomat.Test;

import me.sschaeffner.abi.endlicherAutomat.Automat;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sschaeffner
 */
public class AutomatTest {

    @Test
    public void constructionTest() {
        Automat a = new Automat();
        Assert.assertNotNull(a);
        Assert.assertEquals(1, a.gebeZustand());
    }

    @Test
    public void istEingabeAkzeptiertTest() {
        Automat a = new Automat();
        Assert.assertTrue(a.istEingabeAkzeptiert("a0aa."));
        a.zuruecksetzen();
        Assert.assertTrue(a.istEingabeAkzeptiert("0a0."));
        a.zuruecksetzen();
        Assert.assertFalse(a.istEingabeAkzeptiert("."));
        a.zuruecksetzen();
        Assert.assertFalse(a.istEingabeAkzeptiert("..a0"));
    }
}