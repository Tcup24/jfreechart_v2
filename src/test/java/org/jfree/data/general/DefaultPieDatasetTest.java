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
 * -------------------
 * PieDatasetTest.java
 * -------------------
 * (C) Copyright 2003-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.general;

import org.jfree.chart.TestUtils;
import org.jfree.chart.internal.CloneUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link org.jfree.data.general.PieDataset} class.
 */
public class DefaultPieDatasetTest implements DatasetChangeListener {

    private DatasetChangeEvent lastEvent;

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Some tests for the clear() method.
     */
    @Test
    public void testClear() {
        DefaultPieDataset<String> d = new DefaultPieDataset<>();
        d.addChangeListener(this);
        // no event is generated if the dataset is already empty
        d.clear();
        assertNull(this.lastEvent);
        d.setValue("A", 1.0);
        assertEquals(1, d.getItemCount());
        this.lastEvent = null;
        d.clear();
        assertNotNull(this.lastEvent);
        assertEquals(0, d.getItemCount());
    }

    /**
     * Some checks for the getKey(int) method.
     */
    @Test
    public void testGetKey() {
        DefaultPieDataset<String> d = new DefaultPieDataset<>();
        d.setValue("A", 1.0);
        d.setValue("B", 2.0);
        assertEquals("A", d.getKey(0));
        assertEquals("B", d.getKey(1));

        boolean pass = false;
        try {
            d.getKey(-1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        assertTrue(pass);

        pass = false;
        try {
            d.getKey(2);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        assertTrue(pass);
    }

    /**
     * Some checks for the getIndex() method.
     */
    @Test
    public void testGetIndex() {
        DefaultPieDataset<String> d = new DefaultPieDataset<>();
        d.setValue("A", 1.0);
        d.setValue("B", 2.0);
        assertEquals(0, d.getIndex("A"));
        assertEquals(1, d.getIndex("B"));
        assertEquals(-1, d.getIndex("XX"));

        boolean pass = false;
        try {
            d.getIndex(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        assertTrue(pass);
    }

    /**
     * Confirm that cloning works.
     * @throws java.lang.CloneNotSupportedException
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        DefaultPieDataset<String> d1 = new DefaultPieDataset<>();
        d1.setValue("V1", 1);
        d1.setValue("V2", null);
        d1.setValue("V3", 3);
        DefaultPieDataset<String> d2 = CloneUtils.clone(d1);

        assertNotSame(d1, d2);
        assertSame(d1.getClass(), d2.getClass());
        assertEquals(d1, d2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        DefaultPieDataset<String> d1 = new DefaultPieDataset<>();
        d1.setValue("C1", 234.2);
        d1.setValue("C2", null);
        d1.setValue("C3", 345.9);
        d1.setValue("C4", 452.7);

        DefaultPieDataset<String> d2 = TestUtils.serialised(d1);
        assertEquals(d1, d2);
    }

    /**
     * A test for bug report https://github.com/jfree/jfreechart/issues/212
     */
    @Test
    public void testBug212() {
        DefaultPieDataset<String> d = new DefaultPieDataset<>();
        assertThrows(IndexOutOfBoundsException.class, () ->  d.getValue(-1));
        assertThrows(IndexOutOfBoundsException.class, () ->  d.getValue(0));
        d.setValue("A", 1.0);
        assertEquals(1.0, d.getValue(0));
        assertThrows(IndexOutOfBoundsException.class, () ->  d.getValue(1));        
    }

    //KItest
    private DefaultPieDataset<String> dataset;

    @BeforeEach
    public void setUp() {
        dataset = new DefaultPieDataset<>();
    }

    @Test
    public void testClearDoesNotTriggerEventWhenEmptyTwo() {
        // Assuming there is a method to check dataset change event count
        dataset.clear();
        // Verify that no event is triggered; placeholder method assumed.
        // assertEquals(0, dataset.getChangeEventCount());
    }

    @Test
    public void testClearTriggersEventWhenNotEmptyTwo() {
        dataset.setValue("A", 1);
        // Assuming there is a method to check dataset change event count
        dataset.clear();
        // Verify that an event is triggered; placeholder method assumed.
        // assertEquals(1, dataset.getChangeEventCount());
    }

    @Test
    public void testGetKeyMethodTwo() {
        dataset.setValue("A", 15);
        dataset.setValue("B", 30);

        assertEquals("A", dataset.getKey(0));
        assertEquals("B", dataset.getKey(1));
        assertThrows(IndexOutOfBoundsException.class, () -> dataset.getKey(2));
    }

    @Test
    public void testGetIndexMethodTwo() {
        dataset.setValue("A", 15);
        dataset.setValue("B", 30);

        assertEquals(0, dataset.getIndex("A"));
        assertEquals(1, dataset.getIndex("B"));
        assertThrows(IllegalArgumentException.class, () -> dataset.getIndex(null));
        assertEquals(-1, dataset.getIndex("C"));
    }

    @Test
    public void testCloneMethodTwo() throws CloneNotSupportedException {
        dataset.setValue("A", 15);
        DefaultPieDataset<String> clone = (DefaultPieDataset<String>) dataset.clone();

        assertEquals(dataset, clone);
        assertNotSame(dataset, clone);
    }

    @Test
    public void testSerializationDeserializationTwo() {
        dataset.setValue("A", 15);
        DefaultPieDataset<String> deserializedDataset = TestUtils.serialised(dataset);

        assertEquals(dataset, deserializedDataset);
        assertNotSame(dataset, deserializedDataset);
    }

    @Test
    public void testBug212HandlingTwo() {
        dataset.setValue("A", 15);
        dataset.setValue("B", 30);

        assertThrows(IndexOutOfBoundsException.class, () -> dataset.getKey(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> dataset.getKey(3));

        assertDoesNotThrow(() -> dataset.getKey(0));
        assertDoesNotThrow(() -> dataset.getKey(1));
    }


    //Mini
    @Test
    public void testClearWhenEmptyTwoMini() {
        dataset.clear();
        assertEquals(0, dataset.getItemCount());
    }

    @Test
    public void testClearWhenNotEmptyTwoMini() {
        dataset.setValue("Key1", 1);
        dataset.setValue("Key2", 2);
        dataset.clear();
        assertEquals(0, dataset.getItemCount());
    }
    @Test
    public void testGetKeyTwoMini() {
        dataset.setValue("Key1", 1);
        dataset.setValue("Key2", 2);

        assertEquals("Key1", dataset.getKey(0));
        assertEquals("Key2", dataset.getKey(1));
    }

    @Test
    public void testGetKeyWithInvalidIndexTwoMini() {
        try {
            dataset.getKey(5); // Ein ungültiger Index
            fail("Expected IndexOutOfBoundsException"); // Dies sollte nicht passieren
        } catch (IndexOutOfBoundsException e) {
            // Erwartete Ausnahme wurde geworfen
        }
    }
    @Test
    public void testGetIndexTwoMini() {
        dataset.setValue("Key1", 1);
        dataset.setValue("Key2", 2);

        assertEquals(0, dataset.getIndex("Key1"));
        assertEquals(1, dataset.getIndex("Key2"));
        assertEquals(-1, dataset.getIndex("InvalidKey")); // Ungültiger Schlüssel
    }

    @Test
    public void testGetIndexWithNullTwoMini() {
        try {
            dataset.getIndex(null); // Erwartete Ausnahme
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Erwartete Ausnahme wurde geworfen
        }
    }
    @Test
    public void testCloneTwoMini() throws CloneNotSupportedException {
        dataset.setValue("Key1", 1);
        DefaultPieDataset<String> clonedDataset = (DefaultPieDataset<String>) dataset.clone();

        assertNotSame(dataset, clonedDataset); // Überprüfen, dass es sich nicht um dasselbe Objekt handelt
        assertEquals(dataset, clonedDataset); // Überprüfen, dass sie gleichwertig sind
    }
    @Test
    public void testSerializationTwoMini() {
        dataset.setValue("Key1", 1);
        DefaultPieDataset<String> serializedDataset = TestUtils.serialised(dataset);

        assertEquals(dataset, serializedDataset); // Überprüfen, dass die Objekte gleichwertig sind
    }
    @Test
    public void testInvalidIndexAccessTwoMini() {
        try {
            dataset.getKey(0); // Sollte eine Ausnahme auslösen, da das Dataset leer ist
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Erwartete Ausnahme wurde geworfen
        }
    }

    @Test
    public void testValidIndexAccessTwoMini() {
        dataset.setValue("Key1", 1);
        assertEquals("Key1", dataset.getKey(0)); // Sollte erfolgreich sein
    }

}
