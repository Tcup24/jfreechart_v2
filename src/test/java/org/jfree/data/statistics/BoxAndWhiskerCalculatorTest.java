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
 * --------------------------------
 * BoxAndWhiskerCalculatorTest.java
 * --------------------------------
 * (C) Copyright 2003-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link BoxAndWhiskerCalculator} class.
 */
public class BoxAndWhiskerCalculatorTest {

    /**
     * Some checks for the calculateBoxAndWhiskerStatistics() method.
     */
    @Test
    public void testCalculateBoxAndWhiskerStatistics() {

        // try null list
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        assertTrue(pass);

        // try a list containing a single value
        List<Number> values = new ArrayList<>();
        values.add(1.1);
        BoxAndWhiskerItem item
            = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values);
        assertEquals(1.1, item.getMean().doubleValue(), EPSILON);
        assertEquals(1.1, item.getMedian().doubleValue(), EPSILON);
        assertEquals(1.1, item.getQ1().doubleValue(), EPSILON);
        assertEquals(1.1, item.getQ3().doubleValue(), EPSILON);
    }

    private static final double EPSILON = 0.000000001;

    /**
     * Tests the Q1 calculation.
     */
    @Test
    public void testCalculateQ1() {

        // try null argument
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateQ1(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        assertTrue(pass);

        List<Double> values = new ArrayList<>();
        double q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertTrue(Double.isNaN(q1));
        values.add(1.0);
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(q1, 1.0, EPSILON);
        values.add(2.0);
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(q1, 1.0, EPSILON);
        values.add(3.0);
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(q1, 1.5, EPSILON);
        values.add(4.0);
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(q1, 1.5, EPSILON);
    }

    /**
     * Tests the Q3 calculation.
     */
    @Test
    public void testCalculateQ3() {
        // try null argument
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateQ3(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        assertTrue(pass);

        List<Number> values = new ArrayList<>();
        double q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertTrue(Double.isNaN(q3));
        values.add(1.0);
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertEquals(q3, 1.0, EPSILON);
        values.add(2.0);
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertEquals(q3, 2.0, EPSILON);
        values.add(3.0);
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertEquals(q3, 2.5, EPSILON);
        values.add(4.0);
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertEquals(q3, 3.5, EPSILON);
    }

    /**
     * The test case included in bug report 1593149.
     */
    @Test
    public void test1593149Two() {
        List<Double> list = new ArrayList<>(5);
        list.add(0, 1.0);
        list.add(1, 2.0);
        list.add(2, Double.NaN);
        list.add(3, 3.0);
        list.add(4, 4.0);
        BoxAndWhiskerItem item 
                = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list);
        assertEquals(1.0, item.getMinRegularValue().doubleValue(), EPSILON);
        assertEquals(4.0, item.getMaxRegularValue().doubleValue(), EPSILON);
    }

    //KItest

    @Test
    public void testCalculateBoxAndWhiskerStatistics_SingleElementThree() {
        // Test: Method should correctly calculate statistics for a list with one element
        List<Number> data = Collections.singletonList(5);
        BoxAndWhiskerItem result = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(data);

        assertEquals(5.0, result.getMean().doubleValue(), EPSILON);
        assertEquals(5.0, result.getMedian().doubleValue(), EPSILON);
        assertEquals(5.0, result.getQ1().doubleValue(), EPSILON);
        assertEquals(5.0, result.getQ3().doubleValue(), EPSILON);
    }

    @Test
    public void testCalculateBoxAndWhiskerStatistics_InvalidInputThree() {
        try {
            BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Überprüfen Sie die Fehlermeldung, um sicherzustellen, dass es die richtige Ausnahme ist
            assertEquals("Null 'values' argument.", e.getMessage());
        }
    }

    @Test
    public void testCalculateQ1_InvalidInputThree() {
        try {
            BoxAndWhiskerCalculator.calculateQ1(null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'values' argument.", e.getMessage());
        }
    }

    @Test
    public void testCalculateQ3_InvalidInputTwo() {
        try {
            BoxAndWhiskerCalculator.calculateQ3(null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'values' argument.", e.getMessage());
        }
    }

    @Test
    public void testCalculateQ1_ValidInputsTwo() {
        List<Number> emptyList = Collections.emptyList();
        assertTrue(Double.isNaN(BoxAndWhiskerCalculator.calculateQ1(emptyList)));

        List<Number> singleElement = Collections.singletonList(5);
        assertEquals(5.0, BoxAndWhiskerCalculator.calculateQ1(singleElement), EPSILON);

        List<Number> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(3.0, BoxAndWhiskerCalculator.calculateQ1(data), EPSILON);
    }

    @Test
    public void testCalculateQ3_ValidInputsTwo() {
        List<Number> emptyList = Collections.emptyList();
        assertTrue(Double.isNaN(BoxAndWhiskerCalculator.calculateQ3(emptyList)));

        List<Number> singleElement = Collections.singletonList(5);
        assertEquals(5.0, BoxAndWhiskerCalculator.calculateQ3(singleElement), EPSILON);

        List<Number> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(7.0, BoxAndWhiskerCalculator.calculateQ3(data), EPSILON);
    }

    @Test
    public void test1593149Three() {
        List<Number> data = Arrays.asList(1, 2, Double.NaN, 4, 5, Double.NaN, 7);
        BoxAndWhiskerItem result = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(data);

        assertEquals(1.0, result.getMinRegularValue().doubleValue(), EPSILON);
        assertEquals(7.0, result.getMaxRegularValue().doubleValue(), EPSILON);
    }

    //Mini


    @Test
    public void testCalculateBoxAndWhiskerStatistics_singleElementTwoMini() {
        List<Double> values = Arrays.asList(5.0);
        BoxAndWhiskerItem result = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values);

        assertEquals(5.0, result.getMean().doubleValue(), 0.0001);
        assertEquals(5.0, result.getMedian().doubleValue(), 0.0001);
        assertEquals(5.0, result.getQ1().doubleValue(), 0.0001);
        assertEquals(5.0, result.getQ3().doubleValue(), 0.0001);
        assertEquals(5.0, result.getMinRegularValue().doubleValue(), 0.0001);
        assertEquals(5.0, result.getMaxRegularValue().doubleValue(), 0.0001);
    }


    @Test
    public void testCalculateQ12ThreeMini() {
        // Test für mehrere Werte
        assertEquals(1.5, BoxAndWhiskerCalculator.calculateQ1(Arrays.asList(1, 2, 3, 4)), 0.0001); // Q1 für [1,2,3,4]
        assertEquals(2.0, BoxAndWhiskerCalculator.calculateQ1(Arrays.asList(1, 2, 3, 4, 5)), 0.0001); // Q1 für [1,2,3,4,5]

        // Test für leere Liste
        assertEquals(Double.NaN, BoxAndWhiskerCalculator.calculateQ1(Arrays.asList()), 0.0001); // Q1 für leere Liste

        // Test für Liste mit nur einem Element
        assertEquals(5.0, BoxAndWhiskerCalculator.calculateQ1(Arrays.asList(5)), 0.0001); // Q1 für [5]

        // Test für Liste mit zwei Elementen (Q1 ist der Median der ersten Hälfte)
        assertEquals(1.0, BoxAndWhiskerCalculator.calculateQ1(Arrays.asList(1, 2)), 0.0001); // Q1 für [1,2]
    }


    @Test
    public void test1593149ThreeMini() {
        List<Double> values = Arrays.asList(1.0, Double.NaN, 2.0, 3.0, 4.0, Double.NaN);
        BoxAndWhiskerItem result = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values);

        assertEquals(2.5, result.getMean().doubleValue(), 0.0001);
        assertEquals(2.5, result.getMedian().doubleValue(), 0.0001);
        assertEquals(1.5, result.getQ1().doubleValue(), 0.0001);
        assertEquals(3.5, result.getQ3().doubleValue(), 0.0001);
        assertEquals(1.0, result.getMinRegularValue().doubleValue(), 0.0001);
        assertEquals(4.0, result.getMaxRegularValue().doubleValue(), 0.0001);
    }

    @Test
    public void testCalculateBoxAndWhiskerStatistics_nullInputThreeMini() {
        try {
            BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Der Test ist erfolgreich, wenn die Ausnahme geworfen wird
        }
    }

    @Test
    public void testCalculateQ3_nullInputThreeMini() {
        try {
            BoxAndWhiskerCalculator.calculateQ3(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Der Test ist erfolgreich, wenn die Ausnahme geworfen wird
        }
    }

    @Test
    public void testCalculateQ1_nullInputThreeMini() {
        try {
            BoxAndWhiskerCalculator.calculateQ1(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Der Test ist erfolgreich, wenn die Ausnahme geworfen wird
        }
    }

}
