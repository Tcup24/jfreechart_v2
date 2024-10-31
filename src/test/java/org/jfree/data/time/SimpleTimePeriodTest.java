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
 * -------------------------
 * SimpleTimePeriodTest.java
 * -------------------------
 * (C) Copyright 2003-2022, by David Gilbert.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.time;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.jfree.chart.TestUtils;
import org.junit.jupiter.api.Test;

import static org.jfree.chart.TestUtils.serialised;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link SimpleTimePeriod} class.
 */
public class SimpleTimePeriodTest {

    /**
     * Check that an instance is equal to itself.
     *
     * SourceForge Bug ID: 558850.
     */
//    @Test
//    public void testEqualsSelf() {
//        SimpleTimePeriod p = new SimpleTimePeriod(new Date(1000L),
//                new Date(1001L));
//        assertEquals(p, p);
//    }
//
//    /**
//     * Test the equals() method.
//     */
//    @Test
//    public void testEquals() {
//        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(1000L),
//                new Date(1004L));
//        SimpleTimePeriod p2 = new SimpleTimePeriod(new Date(1000L),
//                new Date(1004L));
//        assertEquals(p1, p2);
//        assertEquals(p2, p1);
//
//        p1 = new SimpleTimePeriod(new Date(1002L), new Date(1004L));
//        assertNotEquals(p1, p2);
//        p2 = new SimpleTimePeriod(new Date(1002L), new Date(1004L));
//        assertEquals(p1, p2);
//
//        p1 = new SimpleTimePeriod(new Date(1002L), new Date(1003L));
//        assertNotEquals(p1, p2);
//        p2 = new SimpleTimePeriod(new Date(1002L), new Date(1003L));
//        assertEquals(p1, p2);
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(1000L),
//                new Date(1001L));
//        SimpleTimePeriod p2 = serialised(p1);
//        assertEquals(p1, p2);
//    }
//
//    /**
//     * Two objects that are equal are required to return the same hashCode.
//     */
//    @Test
//    public void testHashcode() {
//        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        SimpleTimePeriod s2 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        assertEquals(s1, s2);
//        int h1 = s1.hashCode();
//        int h2 = s2.hashCode();
//        assertEquals(h1, h2);
//    }
//
//    /**
//     * This class is immutable, so it should not implement Cloneable.
//     */
//    @Test
//    public void testClone() {
//        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L),
//                new Date(20));
//        assertFalse(s1 instanceof Cloneable);
//    }
//
//    /**
//     * Some simple checks for immutability.
//     */
//    @Test
//    public void testImmutable() {
//        SimpleTimePeriod p1 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        SimpleTimePeriod p2 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        assertEquals(p1, p2);
//        p1.getStart().setTime(11L);
//        assertEquals(p1, p2);
//
//        Date d1 = new Date(10L);
//        Date d2 = new Date(20L);
//        p1 = new SimpleTimePeriod(d1, d2);
//        d1.setTime(11L);
//        assertEquals(new Date(10L), p1.getStart());
//    }
//
//    /**
//     * Some checks for the compareTo() method.
//     */
//    @Test
//    public void testCompareTo() {
//        SimpleTimePeriod s1 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        SimpleTimePeriod s2 = new SimpleTimePeriod(new Date(10L),
//                new Date(20L));
//        assertEquals(0, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(9L), new Date(21L));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(-1, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(11L), new Date(19L));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(1, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(9L), new Date(19L));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(-1, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(11L), new Date(21));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(1, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(10L), new Date(18));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(-1, s1.compareTo(s2));
//
//        s1 = new SimpleTimePeriod(new Date(10L), new Date(22));
//        s2 = new SimpleTimePeriod(new Date(10L), new Date(20L));
//        assertEquals(1, s1.compareTo(s2));
//    }

    //KItest
//    @Test
//    void testEqualsSelfTwo() {
//        SimpleTimePeriod period = new SimpleTimePeriod(1000L, 2000L);
//        assertEquals(period, period, "Ein Objekt sollte gleich zu sich selbst sein.");
//    }
//
//    @Test
//    void testEqualsTwo() {
//        SimpleTimePeriod period1 = new SimpleTimePeriod(1000L, 2000L);
//        SimpleTimePeriod period2 = new SimpleTimePeriod(1000L, 2000L);
//        SimpleTimePeriod period3 = new SimpleTimePeriod(1500L, 2500L);
//
//        assertEquals(period1, period2, "Zwei Objekte mit denselben Attributen sollten gleich sein.");
//        assertNotEquals(period1, period3, "Zwei Objekte mit unterschiedlichen Attributen sollten ungleich sein.");
//    }
//
//    @Test
//    void testSerializationTwo() throws IOException, ClassNotFoundException {
//        SimpleTimePeriod original = new SimpleTimePeriod(1000L, 2000L);
//        SimpleTimePeriod deserialized = serialised(original);
//
//        assertEquals(original, deserialized, "Die deserialisierte Instanz sollte gleich der originalen Instanz sein.");
//    }
//
//    @Test
//    void testHashcodeTwo() {
//        SimpleTimePeriod period1 = new SimpleTimePeriod(1000L, 2000L);
//        SimpleTimePeriod period2 = new SimpleTimePeriod(1000L, 2000L);
//
//        assertEquals(period1.hashCode(), period2.hashCode(), "Gleichwertige Objekte sollten denselben Hashcode haben.");
//    }




    // -----------------
//    @Test
//    void testCloneTwo() {
//        assertThrows(CloneNotSupportedException.class, () -> {
//            SimpleTimePeriod period = new SimpleTimePeriod(1000L, 2000L);
//            period.clone();
//        }, "Die Klasse sollte nicht klonbar sein, da sie unveränderlich ist.");
//    }

//    @Test
//    void testClone2() {
//        SimpleTimePeriod period = new SimpleTimePeriod(1000L, 2000L);
//        assertThrows(CloneNotSupportedException.class, () -> {
//            Method cloneMethod = Object.class.getDeclaredMethod("clone");
//            cloneMethod.setAccessible(true);
//            cloneMethod.invoke(period);
//        }, "Die Klasse sollte nicht klonbar sein, da sie nicht Cloneable implementiert.");
//    }
    // ----------------------




//    @Test
//    void testImmutableTwo() {
//        Date start = new Date(1000L);
//        Date end = new Date(2000L);
//        SimpleTimePeriod period = new SimpleTimePeriod(start, end);
//
//        start.setTime(3000L);
//        end.setTime(4000L);
//
//        assertEquals(new Date(1000L), period.getStart(), "Änderungen an externen Daten sollten die Objekte nicht beeinflussen.");
//        assertEquals(new Date(2000L), period.getEnd(), "Änderungen an externen Daten sollten die Objekte nicht beeinflussen.");
//    }
//
//    @Test
//    void testCompareToTwo() {
//        SimpleTimePeriod period1 = new SimpleTimePeriod(1000L, 2000L);
//        SimpleTimePeriod period2 = new SimpleTimePeriod(1500L, 2500L);
//        SimpleTimePeriod period3 = new SimpleTimePeriod(1000L, 2000L);
//
//        assertTrue(period1.compareTo(period2) < 0, "Ein früheres Objekt sollte als kleiner betrachtet werden.");
//        assertTrue(period2.compareTo(period1) > 0, "Ein späteres Objekt sollte als größer betrachtet werden.");
//        assertTrue(period1.compareTo(period3) == 0, "Gleiche Objekte sollten 0 zurückgeben.");
//    }


    //Mini
    @Test
    void testEqualsSelfTwoMini() {
        SimpleTimePeriod timePeriod = new SimpleTimePeriod(1000L, 2000L);
        assertEquals(timePeriod, timePeriod, "An object should be equal to itself.");
    }

    @Test
    void testEqualsTwoMini() {
        SimpleTimePeriod timePeriod1 = new SimpleTimePeriod(1000L, 2000L);
        SimpleTimePeriod timePeriod2 = new SimpleTimePeriod(1000L, 2000L);
        SimpleTimePeriod timePeriod3 = new SimpleTimePeriod(3000L, 4000L);

        assertEquals(timePeriod1, timePeriod2, "Two time periods with the same start and end should be equal.");
        assertNotEquals(timePeriod1, timePeriod3, "Two time periods with different times should not be equal.");
    }

    @Test
    void testSerializationTwoMini() {
        SimpleTimePeriod original = new SimpleTimePeriod(1000L, 2000L);
        SimpleTimePeriod deserialized = serialised(original);

        assertEquals(original, deserialized, "Deserialized object should be equal to original.");
    }

    @Test
    void testHashcodeTwoMini() {
        SimpleTimePeriod timePeriod1 = new SimpleTimePeriod(1000L, 2000L);
        SimpleTimePeriod timePeriod2 = new SimpleTimePeriod(1000L, 2000L);

        assertEquals(timePeriod1.hashCode(), timePeriod2.hashCode(), "Equal objects should have the same hashcode.");
    }

    @Test
    void testCloneNotSupportedTwoMini() {
        SimpleTimePeriod timePeriod = new SimpleTimePeriod(1000L, 2000L);
        // Überprüfen, dass die Klasse nicht Cloneable ist, könnte wie folgt aussehen
        assertFalse(SimpleTimePeriod.class.isAssignableFrom(Cloneable.class),
                "SimpleTimePeriod should not implement Cloneable and should not be cloneable.");
    }

    @Test
    void testImmutableTwoMini() {
        SimpleTimePeriod timePeriod = new SimpleTimePeriod(1000L, 2000L);
        Date startDate = timePeriod.getStart();
        Date endDate = timePeriod.getEnd();

        // Modifying external Date objects shouldn't affect the time period
        startDate.setTime(500L);
        endDate.setTime(1500L);

        assertEquals(1000L, timePeriod.getStartMillis(), "Modification of external Date should not affect time period.");
        assertEquals(2000L, timePeriod.getEndMillis(), "Modification of external Date should not affect time period.");
    }

    @Test
    void testCompareToTwoMini() {
        SimpleTimePeriod timePeriod1 = new SimpleTimePeriod(1000L, 2000L);
        SimpleTimePeriod timePeriod2 = new SimpleTimePeriod(2000L, 3000L);
        SimpleTimePeriod timePeriod3 = new SimpleTimePeriod(1000L, 2000L);

        assertTrue(timePeriod1.compareTo(timePeriod2) < 0, "timePeriod1 should be less than timePeriod2.");
        assertTrue(timePeriod2.compareTo(timePeriod1) > 0, "timePeriod2 should be greater than timePeriod1.");
        assertEquals(0, timePeriod1.compareTo(timePeriod3), "timePeriod1 should be equal to timePeriod3.");
    }



}
