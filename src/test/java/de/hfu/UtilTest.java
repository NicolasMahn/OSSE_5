package de.hfu;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {


    @Test
    public void testIstErstesHalbjahr() {
        assertEquals(true, Util.istErstesHalbjahr(6));
        assertEquals(false, Util.istErstesHalbjahr(7));
    }

    @Test
    public void testIstErstesHalbjahrKeinMonat() {
        try {
            Util.istErstesHalbjahr(1);
            Util.istErstesHalbjahr(12);
        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            Util.istErstesHalbjahr(0);
            fail();
        } catch (IllegalArgumentException e) {}
        try {
            Util.istErstesHalbjahr(13);
            fail();
        } catch (IllegalArgumentException e) {}
    }

}
