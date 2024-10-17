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
 * --------------
 * RangeTest.java
 * --------------
 * (C) Copyright 2003-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   Sergei Ivanov;
 * 
 */

package org.jfree.data;

import org.jfree.chart.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link Range} class.
 */
public class RangeTest {

//    /**
//     * Confirm that the constructor initializes all the required fields.
//     */
//    @Test
//    public void testConstructor() {
//        Range r1 = new Range(0.1, 1000.0);
//        assertEquals(r1.getLowerBound(), 0.1, 0.0d);
//        assertEquals(r1.getUpperBound(), 1000.0, 0.0d);
//
//        try {
//            Range r2 = new Range(10.0, 0.0);
//            fail("Lower bound cannot be greater than the upper");
//        }
//        catch (Exception e) {
//            // expected
//        }
//    }
//
//    /**
//     * Confirm that the equals method can distinguish all the required fields.
//     */
//    @Test
//    public void testEquals() {
//        Range r1 = new Range(0.0, 1.0);
//        Range r2 = new Range(0.0, 1.0);
//        assertEquals(r1, r2);
//        assertEquals(r2, r1);
//
//        r1 = new Range(0.0, 1.0);
//        r2 = new Range(0.5, 1.0);
//        assertNotEquals(r1, r2);
//
//        r1 = new Range(0.0, 1.0);
//        r2 = new Range(0.0, 2.0);
//        assertNotEquals(r1, r2);
//
//        // a Range object cannot be equal to a different object type
//        assertFalse(r1.equals(0.0));
//    }
//
//    /**
//     * Two objects that are equal are required to return the same hashCode.
//     */
//    @Test
//    public void testHashCode() {
//        Range a1 = new Range(1.0, 100.0);
//        Range a2 = new Range(1.0, 100.0);
//        assertEquals(a1.hashCode(), a2.hashCode());
//
//        a1 = new Range(-100.0, 2.0);
//        a2 = new Range(-100.0, 2.0);
//        assertEquals(a1.hashCode(), a2.hashCode());
//    }
//
//    /**
//     * Simple tests for the contains() method.
//     */
//    @Test
//    public void testContains() {
//        Range r1 = new Range(0.0, 1.0);
//        assertFalse(r1.contains(Double.NaN));
//        assertFalse(r1.contains(Double.NEGATIVE_INFINITY));
//        assertFalse(r1.contains(-1.0));
//        assertTrue(r1.contains(0.0));
//        assertTrue(r1.contains(0.5));
//        assertTrue(r1.contains(1.0));
//        assertFalse(r1.contains(2.0));
//        assertFalse(r1.contains(Double.POSITIVE_INFINITY));
//    }
//
//    /**
//     * Tests the constrain() method for various values.
//     */
//    @Test
//    public void testConstrain() {
//        Range r1 = new Range(0.0, 1.0);
//
//        double d = r1.constrain(0.5);
//        assertEquals(0.5, d, 0.0000001);
//
//        d = r1.constrain(0.0);
//        assertEquals(0.0, d, 0.0000001);
//
//        d = r1.constrain(1.0);
//        assertEquals(1.0, d, 0.0000001);
//
//        d = r1.constrain(-1.0);
//        assertEquals(0.0, d, 0.0000001);
//
//        d = r1.constrain(2.0);
//        assertEquals(1.0, d, 0.0000001);
//
//        d = r1.constrain(Double.POSITIVE_INFINITY);
//        assertEquals(1.0, d, 0.0000001);
//
//        d = r1.constrain(Double.NEGATIVE_INFINITY);
//        assertEquals(0.0, d, 0.0000001);
//
//        d = r1.constrain(Double.NaN);
//        assertTrue(Double.isNaN(d));
//    }
//
//    /**
//     * Simple tests for the intersects() method.
//     */
//    @Test
//    public void testIntersects() {
//        Range r1 = new Range(0.0, 1.0);
//        assertFalse(r1.intersects(-2.0, -1.0));
//        assertFalse(r1.intersects(-2.0, 0.0));
//        assertTrue(r1.intersects(-2.0, 0.5));
//        assertTrue(r1.intersects(-2.0, 1.0));
//        assertTrue(r1.intersects(-2.0, 1.5));
//        assertTrue(r1.intersects(0.0, 0.5));
//        assertTrue(r1.intersects(0.0, 1.0));
//        assertTrue(r1.intersects(0.0, 1.5));
//        assertTrue(r1.intersects(0.5, 0.6));
//        assertTrue(r1.intersects(0.5, 1.0));
//        assertTrue(r1.intersects(0.5, 1.5));
//        assertFalse(r1.intersects(1.0, 1.1));
//        assertFalse(r1.intersects(1.5, 2.0));
//    }
//
//    /**
//     * A simple test for the expand() method.
//     */
//    @Test
//    public void testExpand() {
//        Range r1 = new Range(0.0, 100.0);
//        Range r2 = Range.expand(r1, 0.10, 0.10);
//        assertEquals(-10.0, r2.getLowerBound(), 0.001);
//        assertEquals(110.0, r2.getUpperBound(), 0.001);
//
//        // Expand by 0% does not change the range
//        r2 = Range.expand(r1, 0.0, 0.0);
//        assertEquals(r1, r2);
//
//        try {
//            Range.expand(null, 0.1, 0.1);
//            fail("Null value is accepted");
//        }
//        catch (Exception e) {
//            // expected
//        }
//
//        // Lower > upper: mid-point is used
//        r2 = Range.expand(r1, -0.8, -0.5);
//        assertEquals(65.0, r2.getLowerBound(), 0.001);
//        assertEquals(65.0, r2.getUpperBound(), 0.001);
//    }
//
//    /**
//     * A simple test for the scale() method.
//     */
//    @Test
//    public void testShift() {
//        Range r1 = new Range(10.0, 20.0);
//        Range r2 = Range.shift(r1, 20.0);
//        assertEquals(30.0, r2.getLowerBound(), 0.001);
//        assertEquals(40.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(0.0, 100.0);
//        r2 = Range.shift(r1, -50.0, true);
//        assertEquals(-50.0, r2.getLowerBound(), 0.001);
//        assertEquals(50.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(-10.0, 20.0);
//        r2 = Range.shift(r1, 20.0, true);
//        assertEquals(10.0, r2.getLowerBound(), 0.001);
//        assertEquals(40.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(-10.0, 20.0);
//        r2 = Range.shift(r1, -30.0, true);
//        assertEquals(-40.0, r2.getLowerBound(), 0.001);
//        assertEquals(-10.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(-10.0, 20.0);
//        r2 = Range.shift(r1, 20.0, false);
//        assertEquals(0.0, r2.getLowerBound(), 0.001);
//        assertEquals(40.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(-10.0, 20.0);
//        r2 = Range.shift(r1, -30.0, false);
//        assertEquals(-40.0, r2.getLowerBound(), 0.001);
//        assertEquals(0.0, r2.getUpperBound(), 0.001);
//
//        // Shifting with a delta of 0 does not change the range
//        r2 = Range.shift(r1, 0.0);
//        assertEquals(r1, r2);
//
//        try {
//            Range.shift(null, 0.1);
//            fail("Null value is accepted");
//        } catch (Exception e) {
//            // expected
//        }
//    }
//
//    /**
//     * A simple test for the scale() method.
//     */
//    @Test
//    public void testScale() {
//        Range r1 = new Range(0.0, 100.0);
//        Range r2 = Range.scale(r1, 0.10);
//        assertEquals(0.0, r2.getLowerBound(), 0.001);
//        assertEquals(10.0, r2.getUpperBound(), 0.001);
//
//        r1 = new Range(-10.0, 100.0);
//        r2 = Range.scale(r1, 2.0);
//        assertEquals(-20.0, r2.getLowerBound(), 0.001);
//        assertEquals(200.0, r2.getUpperBound(), 0.001);
//
//        // Scaling with a factor of 1 does not change the range
//        r2 = Range.scale(r1, 1.0);
//        assertEquals(r1, r2);
//
//        try {
//            Range.scale(null, 0.1);
//            fail("Null value is accepted");
//        } catch (Exception e) {
//            // expected
//        }
//
//        try {
//            Range.scale(r1, -0.5);
//            fail("Negative factor accepted");
//        } catch (Exception e) {
//            // expected
//        }
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        Range r1 = new Range(25.0, 133.42);
//        Range r2 = TestUtils.serialised(r1);
//        assertEquals(r1, r2);
//    }
//
//    private static final double EPSILON = 0.0000000001;
//
//    /**
//     * Some checks for the combine method.
//     */
//    @Test
//    public void testCombine() {
//        Range r1 = new Range(1.0, 2.0);
//        Range r2 = new Range(1.5, 2.5);
//
//        assertNull(Range.combine(null, null));
//        assertEquals(r1, Range.combine(r1, null));
//        assertEquals(r2, Range.combine(null, r2));
//        assertEquals(new Range(1.0, 2.5), Range.combine(r1, r2));
//
//        Range r3 = new Range(Double.NaN, 1.3);
//        Range rr = Range.combine(r1, r3);
//        assertTrue(Double.isNaN(rr.getLowerBound()));
//        assertEquals(2.0, rr.getUpperBound(), EPSILON);
//
//        Range r4 = new Range(1.7, Double.NaN);
//        rr = Range.combine(r4, r1);
//        assertEquals(1.0, rr.getLowerBound(), EPSILON);
//        assertTrue(Double.isNaN(rr.getUpperBound()));
//    }
//
//    /**
//     * Some checks for the combineIgnoringNaN() method.
//     */
//    @Test
//    public void testCombineIgnoringNaN() {
//        Range r1 = new Range(1.0, 2.0);
//        Range r2 = new Range(1.5, 2.5);
//
//        assertNull(Range.combineIgnoringNaN(null, null));
//        assertEquals(r1, Range.combineIgnoringNaN(r1, null));
//        assertEquals(r2, Range.combineIgnoringNaN(null, r2));
//        assertEquals(new Range(1.0, 2.5), Range.combineIgnoringNaN(r1, r2));
//
//        Range r3 = new Range(Double.NaN, 1.3);
//        Range rr = Range.combineIgnoringNaN(r1, r3);
//        assertEquals(1.0, rr.getLowerBound(), EPSILON);
//        assertEquals(2.0, rr.getUpperBound(), EPSILON);
//
//        Range r4 = new Range(1.7, Double.NaN);
//        rr = Range.combineIgnoringNaN(r4, r1);
//        assertEquals(1.0, rr.getLowerBound(), EPSILON);
//        assertEquals(2.0, rr.getUpperBound(), EPSILON);
//    }
//
//    /**
//     * Tests for the isNaNRange() method.
//     */
//    @Test
//    public void testIsNaNRange() {
//        assertTrue(new Range(Double.NaN, Double.NaN).isNaNRange());
//        assertFalse(new Range(1.0, 2.0).isNaNRange());
//        assertFalse(new Range(Double.NaN, 2.0).isNaNRange());
//        assertFalse(new Range(1.0, Double.NaN).isNaNRange());
//    }


//    //KItest
//    @Test
//    public void testConstructorTwo() {
//        // Test, dass der Konstruktor korrekt initialisiert
//        Range range = new Range(0.0, 10.0);
//        assertEquals(0.0, range.getLowerBound());
//        assertEquals(10.0, range.getUpperBound());
//
//        // Test, dass eine Ausnahme bei ungültiger Reihenfolge geworfen wird
//        assertThrows(IllegalArgumentException.class, () -> {
//            new Range(10.0, 0.0);
//        });
//    }
//
//    @Test
//    public void testEqualsTwo() {
//        Range range1 = new Range(0.0, 10.0);
//        Range range2 = new Range(0.0, 10.0);
//        Range range3 = new Range(5.0, 15.0);
//
//        assertEquals(range1, range2);
//        assertNotEquals(range1, range3);
//        assertNotEquals(range1, "Not a Range");
//    }
//
//    @Test
//    public void testHashCodeTwo() {
//        Range range1 = new Range(0.0, 10.0);
//        Range range2 = new Range(0.0, 10.0);
//        assertEquals(range1.hashCode(), range2.hashCode());
//    }
//
//    @Test
//    public void testContainsTwo() {
//        Range range = new Range(0.0, 10.0);
//        assertTrue(range.contains(5.0));
//        assertFalse(range.contains(-1.0));
//        assertFalse(range.contains(15.0));
//    }
//
//    @Test
//    public void testConstrainTwo() {
//        Range range = new Range(0.0, 10.0);
//        assertEquals(5.0, range.constrain(5.0));
//        assertEquals(10.0, range.constrain(15.0));
//        assertEquals(0.0, range.constrain(-1.0));
//    }
//
//    @Test
//    public void testIntersectsThree() {
//        Range range1 = new Range(0.0, 10.0);
//        Range range2 = new Range(5.0, 15.0);
//        Range range3 = new Range(10.0, 20.0);
//        Range range4 = new Range(15.0, 25.0);
//
//        assertTrue(range1.intersects(range2));  // Diese Bereiche überschneiden sich
//        assertFalse(range1.intersects(range3)); // Anpassung: Keine Überschneidung, wenn die Ränder nur berühren sollten
//        assertFalse(range1.intersects(range4)); // Keine Überschneidung
//    }
//
//    @Test
//    public void testExpandTwo() {
//        Range range = new Range(0.0, 10.0);
//        Range expandedRange = Range.expand(range, 0.1, 0.1);
//        assertEquals(-1.0, expandedRange.getLowerBound());
//        assertEquals(11.0, expandedRange.getUpperBound());
//    }
//
//    @Test
//    public void testShiftTwo() {
//        Range range = new Range(0.0, 10.0);
//        Range shiftedRange = Range.shift(range, 5.0);
//        assertEquals(5.0, shiftedRange.getLowerBound());
//        assertEquals(15.0, shiftedRange.getUpperBound());
//    }
//
//    @Test
//    public void testScaleTwo() {
//        Range range = new Range(0.0, 10.0);
//        Range scaledRange = Range.scale(range, 2.0);
//        assertEquals(0.0, scaledRange.getLowerBound());
//        assertEquals(20.0, scaledRange.getUpperBound());
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            Range.scale(range, -1.0);
//        });
//    }
//
//    @Test
//    public void testSerializationTwo() {
//        try {
//            Range range = new Range(0.0, 10.0);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            oos.writeObject(range);
//            oos.close();
//
//            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            Range deserializedRange = (Range) ois.readObject();
//            ois.close();
//
//            assertEquals(range, deserializedRange);
//        } catch (IOException | ClassNotFoundException e) {
//            fail("Exception thrown during serialization/deserialization: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void testCombineTwo() {
//        Range range1 = new Range(0.0, 10.0);
//        Range range2 = new Range(5.0, 15.0);
//        Range combinedRange = Range.combine(range1, range2);
//
//        assertEquals(0.0, combinedRange.getLowerBound());
//        assertEquals(15.0, combinedRange.getUpperBound());
//    }
//
//    @Test
//    public void testCombineIgnoringNaNTwo() {
//        Range range1 = new Range(0.0, Double.NaN);
//        Range range2 = new Range(Double.NaN, 15.0);
//        Range combinedRange = Range.combineIgnoringNaN(range1, range2);
//
//        assertEquals(0.0, combinedRange.getLowerBound());
//        assertEquals(15.0, combinedRange.getUpperBound());
//    }
//
//    @Test
//    public void testIsNaNRangeTwo() {
//        Range range1 = new Range(Double.NaN, Double.NaN);
//        Range range2 = new Range(0.0, Double.NaN);
//        Range range3 = new Range(Double.NaN, 10.0);
//
//        assertTrue(range1.isNaNRange());
//        assertFalse(range2.isNaNRange());
//        assertFalse(range3.isNaNRange());
//    }

//Mini
// Test für den Konstruktor
@Test
void testConstructorTwoMini() {
    // Gültige Eingabewerte
    Range range = new Range(1.0, 5.0);
    assertEquals(1.0, range.getLowerBound());
    assertEquals(5.0, range.getUpperBound());

    // Ungültige Eingabewerte
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new Range(5.0, 1.0);
    });
    assertEquals("Range(double, double): require lower (5.0) <= upper (1.0).", exception.getMessage());
}

    // Test für die equals-Methode
    @Test
    void testEqualsTwoMini() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        Range range3 = new Range(2.0, 6.0);

        assertEquals(range1, range2); // gleiche Werte
        assertNotEquals(range1, range3); // unterschiedliche Werte
        assertNotEquals(range1, null); // null sollte ungleich sein
        assertNotEquals(range1, "Not a Range"); // anderer Typ
    }

    // Test für die hashCode-Methode
    @Test
    void testHashCodeTwoMini() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);

        assertEquals(range1.hashCode(), range2.hashCode()); // gleiche Objekte, gleicher Hashcode
    }

    // Test für die contains-Methode
    @Test
    void testContainsTwoMini() {
        Range range = new Range(1.0, 5.0);
        assertTrue(range.contains(1.0));
        assertTrue(range.contains(3.0));
        assertTrue(range.contains(5.0));
        assertFalse(range.contains(0.0));
        assertFalse(range.contains(6.0));
    }

    // Test für die constrain-Methode
    @Test
    void testConstrainTwoMini() {
        Range range = new Range(1.0, 5.0);
        assertEquals(3.0, range.constrain(3.0));
        assertEquals(1.0, range.constrain(0.0)); // unterer Grenzwert
        assertEquals(5.0, range.constrain(6.0)); // oberer Grenzwert
        assertEquals(Double.NaN, range.constrain(Double.NaN)); // NaN sollte NaN zurückgeben
    }

    // Test für die intersects-Methode
    @Test
    void testIntersectsTwoMini() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(4.0, 6.0);
        Range range3 = new Range(6.0, 8.0);

        assertTrue(range1.intersects(range2)); // überlappen
        assertFalse(range1.intersects(range3)); // keine Überlappung
    }

    // Test für die expand-Methode
    @Test
    void testExpandThreeMini() {
        Range range = new Range(1.0, 5.0);

        // Länge des Bereichs: 5.0 - 1.0 = 4.0
        // Untere Grenze nach Erweiterung um 10%: 1.0 - (0.1 * 4.0) = 1.0 - 0.4 = 0.6
        // Obere Grenze nach Erweiterung um 20%: 5.0 + (0.2 * 4.0) = 5.0 + 0.8 = 5.8
        Range expandedRange = Range.expand(range, 0.1, 0.2);
        assertEquals(0.6, expandedRange.getLowerBound(), 0.0001); // Erwartet: 0.6
        assertEquals(5.8, expandedRange.getUpperBound(), 0.0001); // Erwartet: 5.8

        // Überprüfung eines ungültigen Bereichs
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(2.0, 1.0); // Dies ist ein ungültiger Bereich
        });

        // Test mit einem anderen gültigen Range
        Range validRange = new Range(2.0, 3.0);
        // Die Länge beträgt hier 1.0, denn 3.0 - 2.0 = 1.0
        // Untere Grenze nach Erweiterung um 10%: 2.0 - (0.1 * 1.0) = 2.0 - 0.1 = 1.9
        // Obere Grenze nach Erweiterung um 20%: 3.0 + (0.2 * 1.0) = 3.0 + 0.2 = 3.2
        Range expandedValidRange = Range.expand(validRange, 0.1, 0.2);
        assertEquals(1.9, expandedValidRange.getLowerBound(), 0.0001); // Erwartet: 1.9
        assertEquals(3.2, expandedValidRange.getUpperBound(), 0.0001); // Erwartet: 3.2
    }

    // Test für die shift-Methode
    @Test
    void testShiftTwoMini() {
        Range range = new Range(1.0, 5.0);
        Range shiftedRange = Range.shift(range, 2.0);

        assertEquals(3.0, shiftedRange.getLowerBound());
        assertEquals(7.0, shiftedRange.getUpperBound());
    }

    // Test für die scale-Methode
    @Test
    void testScaleTwoMini() {
        Range range = new Range(1.0, 5.0);
        Range scaledRange = Range.scale(range, 2.0);

        assertEquals(2.0, scaledRange.getLowerBound());
        assertEquals(10.0, scaledRange.getUpperBound());

        assertThrows(IllegalArgumentException.class, () -> {
            Range.scale(range, -1.0);
        });
    }

    // Test für die Serialization
    @Test
    void testSerializationTwoMini() {
        Range originalRange = new Range(1.0, 5.0);
        Range deserializedRange = TestUtils.serialised(originalRange);

        assertEquals(originalRange, deserializedRange);
    }


    @Test
    void testCombineTwoRangesThreeMini() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(3.0, 6.0);

        Range combinedRange = Range.combine(range1, range2);

        assertEquals(1.0, combinedRange.getLowerBound());
        assertEquals(6.0, combinedRange.getUpperBound());

        // Tests für null-Werte
        assertSame(range1, Range.combine(range1, null)); // range1 sollte zurückgegeben werden
        assertSame(range2, Range.combine(null, range2)); // range2 sollte zurückgegeben werden
        assertNull(Range.combine(null, null)); // null sollte zurückgegeben werden, wenn beide null sind
    }

    // Test für die combineIgnoringNaN-Methode
    @Test
    void testCombineIgnoringNaNTwoMini() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(3.0, 6.0);

        Range combinedRange = Range.combineIgnoringNaN(range1, range2);
        assertEquals(range2, combinedRange);

        combinedRange = Range.combineIgnoringNaN(null, range2);
        assertEquals(range2, combinedRange);
    }

    // Test für die isNaNRange-Methode
    @Test
    void testIsNaNRangeTwoMini() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(1.0, 5.0);

        assertTrue(range1.isNaNRange());
        assertFalse(range2.isNaNRange());
    }


}
