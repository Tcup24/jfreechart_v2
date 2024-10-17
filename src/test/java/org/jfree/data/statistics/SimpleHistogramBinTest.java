/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2022, by David Gilbert and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------------------
 * SimpleHistogramBinTest.java
 * ---------------------------
 * (C) Copyright 2005-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.statistics;

import org.jfree.chart.TestUtils;
import org.jfree.chart.internal.CloneUtils;
import org.junit.jupiter.api.Test;

import static org.jfree.chart.TestUtils.serialised;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link SimpleHistogramBin} class.
 */
public class SimpleHistogramBinTest {

//    /**
//     * Some checks for the accepts() method.
//     */
//    @Test
//    public void testAccepts() {
//        SimpleHistogramBin bin1 = new SimpleHistogramBin(1.0, 2.0);
//        assertFalse(bin1.accepts(0.0));
//        assertTrue(bin1.accepts(1.0));
//        assertTrue(bin1.accepts(1.5));
//        assertTrue(bin1.accepts(2.0));
//        assertFalse(bin1.accepts(2.1));
//        assertFalse(bin1.accepts(Double.NaN));
//
//        SimpleHistogramBin bin2
//            = new SimpleHistogramBin(1.0, 2.0, false, false);
//        assertFalse(bin2.accepts(0.0));
//        assertFalse(bin2.accepts(1.0));
//        assertTrue(bin2.accepts(1.5));
//        assertFalse(bin2.accepts(2.0));
//        assertFalse(bin2.accepts(2.1));
//        assertFalse(bin2.accepts(Double.NaN));
//    }
//
//    /**
//     * Some checks for the overlapsWith() method.
//     */
//    @Test
//    public void testOverlapsWidth() {
//        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0);
//        SimpleHistogramBin b2 = new SimpleHistogramBin(2.0, 3.0);
//        SimpleHistogramBin b3 = new SimpleHistogramBin(3.0, 4.0);
//        SimpleHistogramBin b4 = new SimpleHistogramBin(0.0, 5.0);
//        SimpleHistogramBin b5 = new SimpleHistogramBin(2.0, 3.0, false, true);
//        SimpleHistogramBin b6 = new SimpleHistogramBin(2.0, 3.0, true, false);
//        assertTrue(b1.overlapsWith(b2));
//        assertTrue(b2.overlapsWith(b1));
//        assertFalse(b1.overlapsWith(b3));
//        assertFalse(b3.overlapsWith(b1));
//        assertTrue(b1.overlapsWith(b4));
//        assertTrue(b4.overlapsWith(b1));
//        assertFalse(b1.overlapsWith(b5));
//        assertFalse(b5.overlapsWith(b1));
//        assertTrue(b1.overlapsWith(b6));
//        assertTrue(b6.overlapsWith(b1));
//    }
//
//    /**
//     * Ensure that the equals() method can distinguish all fields.
//     */
//    @Test
//    public void testEquals() {
//        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0);
//        SimpleHistogramBin b2 = new SimpleHistogramBin(1.0, 2.0);
//        assertEquals(b1, b2);
//        assertEquals(b2, b1);
//
//        b1 = new SimpleHistogramBin(1.1, 2.0, true, true);
//        assertNotEquals(b1, b2);
//        b2 = new SimpleHistogramBin(1.1, 2.0, true, true);
//        assertEquals(b1, b2);
//
//        b1 = new SimpleHistogramBin(1.1, 2.2, true, true);
//        assertNotEquals(b1, b2);
//        b2 = new SimpleHistogramBin(1.1, 2.2, true, true);
//        assertEquals(b1, b2);
//
//        b1 = new SimpleHistogramBin(1.1, 2.2, false, true);
//        assertNotEquals(b1, b2);
//        b2 = new SimpleHistogramBin(1.1, 2.2, false, true);
//        assertEquals(b1, b2);
//
//        b1 = new SimpleHistogramBin(1.1, 2.2, false, false);
//        assertNotEquals(b1, b2);
//        b2 = new SimpleHistogramBin(1.1, 2.2, false, false);
//        assertEquals(b1, b2);
//
//        b1.setItemCount(99);
//        assertNotEquals(b1, b2);
//        b2.setItemCount(99);
//        assertEquals(b1, b2);
//    }
//
//    /**
//     * Some checks for the clone() method.
//     */
//    @Test
//    public void testCloning() throws CloneNotSupportedException {
//        SimpleHistogramBin b1 = new SimpleHistogramBin(1.1, 2.2, false, true);
//        b1.setItemCount(99);
//        SimpleHistogramBin b2 = CloneUtils.clone(b1);
//        assertNotSame(b1, b2);
//        assertSame(b1.getClass(), b2.getClass());
//        assertEquals(b1, b2);
//
//        // check that clone is independent of the original
//        b2.setItemCount(111);
//        assertNotEquals(b1, b2);
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        SimpleHistogramBin b1 = new SimpleHistogramBin(1.0, 2.0, false, true);
//        b1.setItemCount(123);
//        SimpleHistogramBin b2 = serialised(b1);
//        assertEquals(b1, b2);
//    }

    //KItest
    @Test
    public void testAcceptsTwo() {
        SimpleHistogramBin bin = new SimpleHistogramBin(0.0, 10.0, true, false);

        assertTrue(bin.accepts(0.0));   // unterer Grenzwert eingeschlossen
        assertTrue(bin.accepts(5.0));   // innerhalb des Bereichs
        assertFalse(bin.accepts(10.0)); // oberer Grenzwert ausgeschlossen

        bin = new SimpleHistogramBin(0.0, 10.0, false, true);
        assertFalse(bin.accepts(0.0));  // unterer Grenzwert ausgeschlossen
        assertTrue(bin.accepts(10.0));  // oberer Grenzwert eingeschlossen

        bin = new SimpleHistogramBin(0.0, 10.0, false, false);
        assertFalse(bin.accepts(0.0));  // unterer Grenzwert ausgeschlossen
        assertFalse(bin.accepts(10.0)); // oberer Grenzwert ausgeschlossen
    }

    @Test
    public void testOverlapsWithTwo() {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0.0, 5.0, true, false);
        SimpleHistogramBin bin2 = new SimpleHistogramBin(5.0, 10.0, true, false);

        assertFalse(bin1.overlapsWith(bin2)); // Keine Überlappung

        bin2 = new SimpleHistogramBin(4.0, 10.0, true, false);
        assertTrue(bin1.overlapsWith(bin2));  // Überlappt sich

        bin1 = new SimpleHistogramBin(5.0, 10.0, true, true);
        bin2 = new SimpleHistogramBin(10.0, 15.0, true, true);
        assertTrue(bin1.overlapsWith(bin2));  // Überlappt an der Grenze
    }

    @Test
    public void testEqualsTwo() {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0.0, 10.0, true, true);
        SimpleHistogramBin bin2 = new SimpleHistogramBin(0.0, 10.0, true, true);
        SimpleHistogramBin bin3 = new SimpleHistogramBin(0.0, 10.0, false, true);

        assertEquals(bin1, bin2);    // Gleiche Objekte
        assertNotEquals(bin1, bin3); // Unterschiedliche Einstellungen

        bin1.setItemCount(5);
        bin2.setItemCount(5);
        assertEquals(bin1, bin2);    // Gleiche Objekte mit gleichem ItemCount

        bin2.setItemCount(10);
        assertNotEquals(bin1, bin2); // Unterschiedlicher ItemCount
    }

    @Test
    public void testCloningTwo() throws CloneNotSupportedException {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0.0, 10.0, true, true);
        SimpleHistogramBin bin2 = (SimpleHistogramBin) bin1.clone();

        assertEquals(bin1, bin2); // Anfangs gleich
        assertNotSame(bin1, bin2); // Unterschiedliche Referenzen

        bin2.setItemCount(5);
        assertNotEquals(bin1.getItemCount(), bin2.getItemCount()); // Änderungen sollten unabhängig sein
    }

    @Test
    public void testSerializationTwo() {
        SimpleHistogramBin original = new SimpleHistogramBin(0.0, 10.0, true, true);
        original.setItemCount(5);

        SimpleHistogramBin deserialized = serialised(original);

        assertEquals(original, deserialized); // Deserialisiertes Objekt sollte gleich sein
        assertNotSame(original, deserialized); // Unterschiedliche Referenzen
    }


    //Mini
    @Test
    void testAcceptsTwoMini() {
        SimpleHistogramBin bin = new SimpleHistogramBin(0, 10, true, false);

        // Accepts lower bound (inclusive)
        assertTrue(bin.accepts(0));

        // Does not accept upper bound (exclusive)
        assertFalse(bin.accepts(10));

        // Accepts value within range
        assertTrue(bin.accepts(5));

        // Does not accept value below range
        assertFalse(bin.accepts(-1));

        // Does not accept value above range
        assertFalse(bin.accepts(11));

        // Does not accept NaN
        assertFalse(bin.accepts(Double.NaN));
    }

    @Test
    void testOverlapsWithThreeMini() {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0, 10, true, true);
        SimpleHistogramBin bin2 = new SimpleHistogramBin(5, 15, true, true);
        SimpleHistogramBin bin3 = new SimpleHistogramBin(10, 20, false, true);

        // Overlaps
        assertTrue(bin1.overlapsWith(bin2), "bin1 should overlap with bin2");

        // Does not overlap (bin1 ends at 10 and bin3 starts at 10, which is exclusive)
        assertFalse(bin1.overlapsWith(bin3), "bin1 should not overlap with bin3");

        // Adding another test case for clarity: directly testing bounds
        SimpleHistogramBin bin4 = new SimpleHistogramBin(10, 20, true, true);
        // This should overlap because both are inclusive on 10
        assertTrue(bin1.overlapsWith(bin4), "bin1 should overlap with bin4");
    }

    @Test
    void testEqualsTwoMini() {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0, 10, true, true);
        SimpleHistogramBin bin2 = new SimpleHistogramBin(0, 10, true, true);
        SimpleHistogramBin bin3 = new SimpleHistogramBin(0, 10, false, true);

        assertTrue(bin1.equals(bin2)); // same properties
        assertFalse(bin1.equals(bin3)); // different includeLowerBound
        assertFalse(bin1.equals(null)); // compare with null
        assertFalse(bin1.equals(new Object())); // compare with different type
    }
    @Test
    void testCloningTwoMini() throws CloneNotSupportedException {
        SimpleHistogramBin bin1 = new SimpleHistogramBin(0, 10, true, true);
        SimpleHistogramBin bin2 = (SimpleHistogramBin) bin1.clone();

        // Check if the clone is equal to the original
        assertEquals(bin1, bin2);

        // Modifying the clone should not affect the original
        bin2.setItemCount(5);
        assertNotEquals(bin1.getItemCount(), bin2.getItemCount());
    }

    @Test
    void testSerializationTwoMini() {
        SimpleHistogramBin originalBin = new SimpleHistogramBin(0, 10, true, true);
        SimpleHistogramBin deserializedBin = serialised(originalBin);

        // Check if the deserialized object is equal to the original
        assertEquals(originalBin, deserializedBin);
    }

}
