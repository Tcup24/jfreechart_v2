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
 * ---------------------
 * HistogramBinTest.java
 * ---------------------
 * (C) Copyright 2004-2022, by David Gilbert.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.statistics;

import org.jfree.chart.TestUtils;
import org.jfree.chart.internal.CloneUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link HistogramBin} class.
 */
public class HistogramBinTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        double start = 10.0;
        double end = 20.0;
        HistogramBin b1 = new HistogramBin(start, end);
        HistogramBin b2 = new HistogramBin(start, end);
        assertEquals(b1, b2);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        double start = 10.0;
        double end = 20.0;
        HistogramBin b1 = new HistogramBin(start, end);
        HistogramBin b2 = CloneUtils.clone(b1);
        assertNotSame(b1, b2);
        assertSame(b1.getClass(), b2.getClass());
        assertEquals(b1, b2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        double start = 10.0;
        double end = 20.0;
        HistogramBin b1 = new HistogramBin(start, end);
        HistogramBin b2 = TestUtils.serialised(b1);
        assertEquals(b1, b2);
    }

    //Mini
    @Test
    public void testEqualsTwoMini() {
        HistogramBin bin1 = new HistogramBin(0.0, 1.0);
        HistogramBin bin2 = new HistogramBin(0.0, 1.0);
        HistogramBin bin3 = new HistogramBin(0.0, 2.0);

        assertTrue(bin1.equals(bin2), "Bins with same boundaries and count should be equal.");
        assertFalse(bin1.equals(bin3), "Bins with different end boundaries should not be equal.");
        assertFalse(bin1.equals(null), "A bin should not be equal to null.");
        assertFalse(bin1.equals(new Object()), "A bin should not be equal to a different object type.");
    }

    @Test
    public void testCloningTwoMini() throws CloneNotSupportedException {
        HistogramBin original = new HistogramBin(0.0, 5.0);
        original.incrementCount(); // Increment count to change the state

        HistogramBin cloned = (HistogramBin) original.clone();

        assertNotSame(original, cloned, "Cloned object should not be the same instance.");
        assertEquals(original, cloned, "Cloned object should be equal to the original.");
        assertEquals(original.getCount(), cloned.getCount(), "Cloned object should have the same count.");
    }

    @Test
    public void testSerializationTwoMini() {
        HistogramBin original = new HistogramBin(1.0, 3.0);
        original.incrementCount(); // Increment count to change the state

        // Serialize and deserialize the original object
        HistogramBin deserialized = TestUtils.serialised(original);

        assertNotSame(original, deserialized, "Deserialized object should not be the same instance.");
        assertEquals(original, deserialized, "Deserialized object should be equal to the original.");
        assertEquals(original.getCount(), deserialized.getCount(), "Deserialized object should have the same count.");
        assertEquals(original.getStartBoundary(), deserialized.getStartBoundary(), "Deserialized object should have the same start boundary.");
        assertEquals(original.getEndBoundary(), deserialized.getEndBoundary(), "Deserialized object should have the same end boundary.");
    }


    //KItest
    @Test
    public void testEqualsTwo() {
        HistogramBin bin1 = new HistogramBin(0.0, 1.0);
        HistogramBin bin2 = new HistogramBin(0.0, 1.0);

        assertTrue(bin1.equals(bin2), "Die Bins sollten gleich sein");

        bin1.incrementCount();
        assertFalse(bin1.equals(bin2), "Die Bins sollten nicht gleich sein, da die counts unterschiedlich sind");
    }

    @Test
    public void testCloningTwo() throws CloneNotSupportedException {
        HistogramBin bin1 = new HistogramBin(0.0, 1.0);
        bin1.incrementCount();
        HistogramBin bin2 = (HistogramBin) bin1.clone();

        assertFalse(bin1 == bin2, "Die geklonten Bins sollten nicht die gleiche Instanz sein");
        assertTrue(bin1.equals(bin2), "Die geklonten Bins sollten gleich sein");
    }

    @Test
    public void testSerializationTwo() {
        HistogramBin bin1 = new HistogramBin(0.0, 1.0);
        bin1.incrementCount();

        HistogramBin bin2 = TestUtils.serialised(bin1);

        assertFalse(bin1 == bin2, "Die deserialisierten Bins sollten nicht die gleiche Instanz sein");
        assertTrue(bin1.equals(bin2), "Die deserialisierten Bins sollten gleich sein");
    }


}
