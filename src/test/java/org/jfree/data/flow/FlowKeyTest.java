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
 * ----------------
 * FlowKeyTest.java
 * ----------------
 * (C) Copyright 2021-2022, by David Gilbert.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.flow;

import org.jfree.chart.TestUtils;

import org.junit.jupiter.api.Test;

import static org.jfree.chart.TestUtils.serialised;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link FlowKey} class.
 */
public class FlowKeyTest {

//    /**
//     * Confirm that the equals method can distinguish all the required fields.
//     */
//    @Test
//    public void testEquals() {
//        FlowKey<String> k1 = new FlowKey<>(0, "A", "B");
//        FlowKey<String> k2 = new FlowKey<>(0, "A", "B");
//        assertEquals(k1, k2);
//        assertEquals(k2, k1);
//
//        k1 = new FlowKey<>(1, "A", "B");
//        assertNotEquals(k1, k2);
//        k2 = new FlowKey<>(1, "A", "B");
//        assertEquals(k1, k2);
//
//        k1 = new FlowKey<>(1, "C", "B");
//        assertNotEquals(k1, k2);
//        k2 = new FlowKey<>(1, "C", "B");
//        assertEquals(k1, k2);
//    }
//
//    /**
//     * Confirm that cloning works.
//     */
//    @Test
//    public void testCloning() throws CloneNotSupportedException {
//        FlowKey<String> k1 = new FlowKey<>(0, "A", "B");
//        FlowKey<String> k2 = (FlowKey<String>) k1.clone();
//        assertNotSame(k1, k2);
//        assertSame(k1.getClass(), k2.getClass());
//        assertEquals(k1, k2);
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        FlowKey<String> k1 = new FlowKey<>(1, "S1", "D1");
//        FlowKey<String> k2 = serialised(k1);
//        assertEquals(k1, k2);
//    }

    //KItest
    @Test
    public void testEqualsTwo() {
        FlowKey<String> key1 = new FlowKey<>(1, "sourceA", "destinationA");
        FlowKey<String> key2 = new FlowKey<>(1, "sourceA", "destinationA");
        FlowKey<String> key3 = new FlowKey<>(2, "sourceB", "destinationB");

        // Teste, ob zwei identische Objekte als gleich erkannt werden
        assertEquals(key1, key2);

        // Teste, ob Objekte mit unterschiedlichen Feldern als ungleich erkannt werden
        assertNotEquals(key1, key3);

        // Teste, ob ein Objekt ungleich null ist
        assertNotEquals(key1, null);

        // Teste, ob ein Objekt ungleich einem Objekt eines anderen Typs ist
        assertNotEquals(key1, "ein anderer Typ");
    }

    @Test
    public void testCloningTwo() throws CloneNotSupportedException {
        FlowKey<String> original = new FlowKey<>(1, "sourceA", "destinationA");
        FlowKey<String> clone = (FlowKey<String>) original.clone();

        // Teste, ob das geklonte Objekt eine andere Instanz ist
        assertNotSame(original, clone);

        // Teste, ob das geklonte Objekt dieselben Eigenschaften wie das Original aufweist
        assertEquals(original, clone);
    }

    @Test
    public void testSerializationTwo() {
        FlowKey<String> original = new FlowKey<>(1, "sourceA", "destinationA");
        FlowKey<String> deserialized = serialised(original);

        // Teste, ob das deserialisierte Objekt dem ursprünglichen Objekt entspricht
        assertEquals(original, deserialized);
    }

    //Mini
    @Test
    public void testEqualsTwoMini() {
        FlowKey<String> key1 = new FlowKey<>(1, "source1", "dest1");
        FlowKey<String> key2 = new FlowKey<>(1, "source1", "dest1");
        FlowKey<String> key3 = new FlowKey<>(2, "source2", "dest2");

        assertTrue(key1.equals(key2), "Keys with same fields should be equal");
        assertFalse(key1.equals(key3), "Keys with different fields should not be equal");
        assertFalse(key1.equals(null), "Key should not be equal to null");
        assertFalse(key1.equals("Some String"), "Key should not be equal to an object of a different type");
    }
    @Test
    public void testCloningTwoMini() throws CloneNotSupportedException {
        FlowKey<String> original = new FlowKey<>(1, "source1", "dest1");
        FlowKey<String> cloned = (FlowKey<String>) original.clone();

        assertNotSame(original, cloned, "Cloned object should not be the same instance as the original");
        assertEquals(original, cloned, "Cloned object should have same properties as the original");
    }
    @Test
    public void testSerializationTwoMini() {
        FlowKey<String> original = new FlowKey<>(1, "source1", "dest1");
        FlowKey<String> deserialized = TestUtils.serialised(original);

        assertNotSame(original, deserialized, "Deserialized object should not be the same instance as the original");
        assertEquals(original, deserialized, "Deserialized object should be equal to the original");
    }

}
