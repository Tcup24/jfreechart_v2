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
 * ------------------------------
 * PolynomialFunction2DTests.java
 * ------------------------------
 * (C) Copyright 2009-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.function;

import java.io.*;
import java.util.Arrays;
import org.jfree.chart.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link PolynomialFunction2D} class.
 */
public class PolynomialFunction2DTest {

//    /**
//     * Some tests for the constructor.
//     */
//    @Test
//    public void testConstructor() {
//        PolynomialFunction2D f = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        assertArrayEquals(new double[]{1.0, 2.0}, f.getCoefficients());
//
//        boolean pass = false;
//        try {
//            f = new PolynomialFunction2D(null);
//        }
//        catch (IllegalArgumentException e) {
//            pass = true;
//        }
//        assertTrue(pass);
//    }
//
//    /**
//     * Some checks for the getCoefficients() method.
//     */
//    @Test
//    public void testGetCoefficients() {
//        PolynomialFunction2D f = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        double[] c = f.getCoefficients();
//        assertArrayEquals(new double[]{1.0, 2.0}, c);
//
//        // make sure that modifying the returned array doesn't change the
//        // function
//        c[0] = 99.9;
//        assertArrayEquals(new double[]{1.0, 2.0}, f.getCoefficients());
//    }
//
//    /**
//     * Some checks for the getOrder() method.
//     */
//    @Test
//    public void testGetOrder() {
//        PolynomialFunction2D f = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        assertEquals(1, f.getOrder());
//    }
//
//    /**
//     * For datasets, the equals() method just checks keys and values.
//     */
//    @Test
//    public void testEquals() {
//        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        PolynomialFunction2D f2 = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        assertEquals(f1, f2);
//        f1 = new PolynomialFunction2D(new double[] {2.0, 3.0});
//        assertNotEquals(f1, f2);
//        f2 = new PolynomialFunction2D(new double[] {2.0, 3.0});
//        assertEquals(f1, f2);
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        PolynomialFunction2D f2 = TestUtils.serialised(f1);
//        assertEquals(f1, f2);
//    }
//
//    /**
//     * Objects that are equal should have the same hash code otherwise FindBugs
//     * will tell on us...
//     */
//    @Test
//    public void testHashCode() {
//        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        PolynomialFunction2D f2 = new PolynomialFunction2D(new double[] {1.0,
//                2.0});
//        assertEquals(f1.hashCode(), f2.hashCode());
//    }

    //KItest

    @Test
    public void testConstructor_initializationAndExceptionThree() {
        // Test korrekte Initialisierung
        double[] coefficients = {1.0, 2.0, 3.0};
        PolynomialFunction2D poly = new PolynomialFunction2D(coefficients);
        assertArrayEquals(coefficients, poly.getCoefficients(), 0.001);

        // Test Ausnahme für null Eingaben
        try {
            new PolynomialFunction2D(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'coefficients' argument.", e.getMessage());
        }
    }

    @Test
    public void testGetCoefficients_returnValuesAndIsolationTwo() {
        double[] coefficients = {1.0, 2.0, 3.0};
        PolynomialFunction2D poly = new PolynomialFunction2D(coefficients);

        double[] returnedCoeffs = poly.getCoefficients();
        assertArrayEquals(coefficients, returnedCoeffs, 0.001);

        // Test Isolation
        returnedCoeffs[0] = 99.0;
        assertArrayEquals(coefficients, poly.getCoefficients(), 0.001);
    }

    @Test
    public void testGetOrder_correctOrderTwo() {
        double[] coefficients = {1.0, 2.0, 3.0};
        PolynomialFunction2D poly = new PolynomialFunction2D(coefficients);
        assertEquals(2, poly.getOrder());
    }

    @Test
    public void testEquals_correctEqualityTwo() {
        double[] coefficients1 = {1.0, 2.0, 3.0};
        double[] coefficients2 = {1.0, 2.0, 3.0};
        double[] coefficients3 = {1.0, 2.0};

        PolynomialFunction2D poly1 = new PolynomialFunction2D(coefficients1);
        PolynomialFunction2D poly2 = new PolynomialFunction2D(coefficients2);
        PolynomialFunction2D poly3 = new PolynomialFunction2D(coefficients3);

        assertTrue(poly1.equals(poly2));
        assertFalse(poly1.equals(poly3));
    }

    @Test
    public void testSerialization_correctSerializationTwo() throws IOException, ClassNotFoundException {
        double[] coefficients = {1.0, 2.0, 3.0};
        PolynomialFunction2D poly = new PolynomialFunction2D(coefficients);

        // Serialisieren
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(poly);
        out.close();

        // Deserialisieren
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        PolynomialFunction2D deserializedPoly = (PolynomialFunction2D) in.readObject();
        in.close();

        assertEquals(poly, deserializedPoly);
    }

    @Test
    public void testHashCode_equalObjectsEqualHashCodesTwo() {
        double[] coefficients1 = {1.0, 2.0, 3.0};
        double[] coefficients2 = {1.0, 2.0, 3.0};

        PolynomialFunction2D poly1 = new PolynomialFunction2D(coefficients1);
        PolynomialFunction2D poly2 = new PolynomialFunction2D(coefficients2);

        assertEquals(poly1.hashCode(), poly2.hashCode());
    }

    //Mini
//    @Test
//    public void testConstructorValidInputTwoMini() {
//        double[] coefficients = {1.0, 2.0, 3.0};
//        PolynomialFunction2D function = new PolynomialFunction2D(coefficients);
//        Assertions.assertArrayEquals(coefficients, function.getCoefficients());
//    }
//
//    @Test
//    public void testConstructorNullInputTwoMini() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            new PolynomialFunction2D(null);
//        });
//    }
//    @Test
//    public void testGetCoefficientsTwoMini() {
//        double[] coefficients = {1.0, 2.0, 3.0};
//        PolynomialFunction2D function = new PolynomialFunction2D(coefficients);
//        double[] returnedCoefficients = function.getCoefficients();
//
//        Assertions.assertArrayEquals(coefficients, returnedCoefficients);
//
//        // Änderungen am zurückgegebenen Array haben keine Auswirkungen auf die interne Speicherung
//        returnedCoefficients[0] = 99.0;
//        Assertions.assertNotEquals(99.0, function.getCoefficients()[0]);
//    }
//    @Test
//    public void testGetOrderTwoMini() {
//        double[] coefficients = {1.0, 2.0, 3.0};
//        PolynomialFunction2D function = new PolynomialFunction2D(coefficients);
//        Assertions.assertEquals(2, function.getOrder()); // Grad = Anzahl der Koeffizienten - 1
//    }
//    @Test
//    public void testEqualsTwoMini() {
//        double[] coefficients1 = {1.0, 2.0, 3.0};
//        double[] coefficients2 = {1.0, 2.0, 3.0};
//        double[] coefficients3 = {1.0, 2.0, 4.0};
//
//        PolynomialFunction2D function1 = new PolynomialFunction2D(coefficients1);
//        PolynomialFunction2D function2 = new PolynomialFunction2D(coefficients2);
//        PolynomialFunction2D function3 = new PolynomialFunction2D(coefficients3);
//
//        Assertions.assertTrue(function1.equals(function2));
//        Assertions.assertFalse(function1.equals(function3));
//    }
//    @Test
//    public void testSerializationTwoMini() {
//        double[] coefficients = {1.0, 2.0, 3.0};
//        PolynomialFunction2D originalFunction = new PolynomialFunction2D(coefficients);
//        PolynomialFunction2D deserializedFunction = TestUtils.serialised(originalFunction);
//
//        Assertions.assertEquals(originalFunction, deserializedFunction);
//    }
//    @Test
//    public void testHashCodeTwoMini() {
//        double[] coefficients1 = {1.0, 2.0, 3.0};
//        double[] coefficients2 = {1.0, 2.0, 3.0};
//
//        PolynomialFunction2D function1 = new PolynomialFunction2D(coefficients1);
//        PolynomialFunction2D function2 = new PolynomialFunction2D(coefficients2);
//
//        Assertions.assertEquals(function1.hashCode(), function2.hashCode());
//    }


}

