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
 * ------------------------
 * TimePeriodValueTest.java
 * ------------------------
 * (C) Copyright 2003-2022, by David Gilbert.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.time;

import org.jfree.chart.TestUtils;
import org.jfree.chart.date.MonthConstants;
import org.jfree.chart.internal.CloneUtils;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A collection of test cases for the {@link TimePeriodValues} class.
 */
public class TimePeriodValuesTest {

    /**
     * Set up a quarter equal to Q1 1900.  Request the previous quarter, it 
     * should be null.
     */
//    @Test
//    public void testClone() throws CloneNotSupportedException {
//        TimePeriodValues<String> series = new TimePeriodValues<>("Test Series");
//        RegularTimePeriod jan1st2002 = new Day(1, MonthConstants.JANUARY, 2002);
//        series.add(jan1st2002, 42);
//        TimePeriodValues<String> clone = CloneUtils.clone(series);
//        clone.update(0, 10);
//
//        int seriesValue = series.getValue(0).intValue();
//        int cloneValue = clone.getValue(0).intValue();
//
//        assertEquals(42, seriesValue);
//        assertEquals(10, cloneValue);
//        assertEquals("Test Series", series.getKey());
//        assertEquals("Test Series", clone.getKey());
//    }
//
//    /**
//     * Add a value to series A for 1999.  It should be added at index 0.
//     */
//    @Test
//    public void testAddValue() {
//        TimePeriodValues<String> tpvs = new TimePeriodValues<>("Test");
//        tpvs.add(new Year(1999), 1);
//        int value = tpvs.getValue(0).intValue();
//        assertEquals(1, value);
//    }
//
//    /**
//     * Serialize an instance, restore it, and check for equality.
//     */
//    @Test
//    public void testSerialization() {
//        TimePeriodValues<String> s1 = new TimePeriodValues<>("A test");
//        s1.add(new Year(2000), 13.75);
//        s1.add(new Year(2001), 11.90);
//        s1.add(new Year(2002), null);
//        s1.add(new Year(2005), 19.32);
//        s1.add(new Year(2007), 16.89);
//        TimePeriodValues<String> s2 = TestUtils.serialised(s1);
//        assertEquals(s1, s2);
//    }
//
//    /**
//     * Tests the equals method.
//     */
//    @Test
//    public void testEquals() {
//        TimePeriodValues<String> s1 = new TimePeriodValues<>("Time Series 1");
//        TimePeriodValues<String> s2 = new TimePeriodValues<>("Time Series 1");
//        assertEquals(s1, s2);
//
//        RegularTimePeriod p1 = new Day();
//        RegularTimePeriod p2 = p1.next();
//        s1.add(p1, 100.0);
//        s1.add(p2, 200.0);
//        assertNotEquals(s1, s2);
//
//        s2.add(p1, 100.0);
//        s2.add(p2, 200.0);
//        assertEquals(s1, s2);
//
//    }
//
//    /**
//     * A test for bug report 1161329.
//     */
//    @Test
//    public void test1161329() {
//        TimePeriodValues<String> tpv = new TimePeriodValues<>("Test");
//        RegularTimePeriod t = new Day();
//        tpv.add(t, 1.0);
//        t = t.next();
//        tpv.add(t, 2.0);
//        tpv.delete(0, 1);
//        assertEquals(0, tpv.getItemCount());
//        tpv.add(t, 2.0);
//        assertEquals(1, tpv.getItemCount());
//    }
//
//    static final double EPSILON = 0.0000000001;
//
//    /**
//     * Some checks for the add() methods.
//     */
//    @Test
//    public void testAdd() {
//        TimePeriodValues<String> tpv = new TimePeriodValues<>("Test");
//        MySeriesChangeListener listener = new MySeriesChangeListener();
//        tpv.addChangeListener(listener);
//        tpv.add(new TimePeriodValue(new SimpleTimePeriod(new Date(1L),
//                new Date(3L)), 99.0));
//        assertEquals(99.0, tpv.getValue(0).doubleValue(), EPSILON);
//        assertEquals(tpv, listener.getLastEvent().getSource());
//
//        // a null item should throw an IllegalArgumentException
//        boolean pass = false;
//        try {
//            tpv.add((TimePeriodValue) null);
//        }
//        catch (IllegalArgumentException e) {
//            pass = true;
//        }
//        assertTrue(pass);
//    }
//
//    /**
//     * Some tests for the getMinStartIndex() method.
//     */
//    @Test
//    public void testGetMinStartIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMinStartIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMinStartIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(0, s.getMinStartIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(2, s.getMinStartIndex());
//    }
//
//    /**
//     * Some tests for the getMaxStartIndex() method.
//     */
//    @Test
//    public void testGetMaxStartIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMaxStartIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMaxStartIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(1, s.getMaxStartIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(1, s.getMaxStartIndex());
//    }
//
//    /**
//     * Some tests for the getMinMiddleIndex() method.
//     */
//    @Test
//    public void testGetMinMiddleIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMinMiddleIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMinMiddleIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(0, s.getMinMiddleIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(2, s.getMinMiddleIndex());
//    }
//
//    /**
//     * Some tests for the getMaxMiddleIndex() method.
//     */
//    @Test
//    public void testGetMaxMiddleIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMaxMiddleIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMaxMiddleIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(1, s.getMaxMiddleIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(1, s.getMaxMiddleIndex());
//        s.add(new SimpleTimePeriod(150L, 200L), 4.0);
//        assertEquals(1, s.getMaxMiddleIndex());
//    }
//
//    /**
//     * Some tests for the getMinEndIndex() method.
//     */
//    @Test
//    public void getMinEndIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMinEndIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMinEndIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(0, s.getMinEndIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(2, s.getMinEndIndex());
//    }
//
//    /**
//     * Some tests for the getMaxEndIndex() method.
//     */
//    @Test
//    public void getMaxEndIndex() {
//        TimePeriodValues<String> s = new TimePeriodValues<>("Test");
//        assertEquals(-1, s.getMaxEndIndex());
//        s.add(new SimpleTimePeriod(100L, 200L), 1.0);
//        assertEquals(0, s.getMaxEndIndex());
//        s.add(new SimpleTimePeriod(300L, 400L), 2.0);
//        assertEquals(1, s.getMaxEndIndex());
//        s.add(new SimpleTimePeriod(0L, 50L), 3.0);
//        assertEquals(1, s.getMaxEndIndex());
//    }
//
//    /**
//     * A listener used for detecting series change events.
//     */
//    static class MySeriesChangeListener implements SeriesChangeListener {
//
//        SeriesChangeEvent lastEvent;
//
//        /**
//         * Creates a new listener.
//         */
//        public MySeriesChangeListener() {
//            this.lastEvent = null;
//        }
//
//        /**
//         * Returns the last event.
//         *
//         * @return The last event (possibly {@code null}).
//         */
//        public SeriesChangeEvent getLastEvent() {
//            return this.lastEvent;
//        }
//
//        /**
//         * Clears the last event (sets it to {@code null}).
//         */
//        public void clearLastEvent() {
//            this.lastEvent = null;
//        }
//
//        /**
//         * Callback method for series change events.
//         *
//         * @param event  the event.
//         */
//        @Override
//        public void seriesChanged(SeriesChangeEvent event) {
//            this.lastEvent = event;
//        }
//    }



    //KItest
    private TimePeriodValues<String> timePeriodValues;

    @BeforeEach
    public void setUp() {
        timePeriodValues = new TimePeriodValues<>("Test Series");
    }
//
//    @Test
//    public void testCloneFunctionality() throws CloneNotSupportedException {
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        TimePeriodValues<?> clone = (TimePeriodValues<?>) timePeriodValues.clone();
//        clone.update(0, 200);
//        assertNotEquals(timePeriodValues.getValue(0), clone.getValue(0));
//    }
//
//    @Test
//    public void testAddValueTwo() {
//        Day day = new Day(1, 1, 2022);
//        TimePeriodValue tpv = new TimePeriodValue(day, 100);
//        timePeriodValues.add(tpv);
//        assertEquals(1, timePeriodValues.getItemCount());
//        assertEquals(tpv, timePeriodValues.getDataItem(0));
//    }
//
//    @Test
//    public void testSerializationTwo() throws IOException, ClassNotFoundException {
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream out = new ObjectOutputStream(bos);
//        out.writeObject(timePeriodValues);
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream in = new ObjectInputStream(bis);
//        TimePeriodValues<?> deserialized = (TimePeriodValues<?>) in.readObject();
//
//        assertEquals(timePeriodValues, deserialized);
//    }
//
//    @Test
//    public void testEqualsTwo() {
//        TimePeriodValues another = new TimePeriodValues<>("Test Series");
//        assertEquals(timePeriodValues, another);
//
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        another.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        assertEquals(timePeriodValues, another);
//
//        another.add(new TimePeriodValue(new Day(2, 1, 2022), 200));
//        assertNotEquals(timePeriodValues, another);
//    }
//
//    @Test
//    public void testDeleteValuesTwo() {
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        timePeriodValues.add(new TimePeriodValue(new Day(2, 1, 2022), 200));
//        timePeriodValues.delete(0, 0);
//        assertEquals(1, timePeriodValues.getItemCount());
//    }
//
//    @Test
//    public void testSeriesChangeListenerTwo() {
//        final boolean[] flag = {false};
//        timePeriodValues.addChangeListener(event -> flag[0] = true);
//
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 100));
//        assertTrue(flag[0]);
//    }
//
//    @Test
//    public void testMinMaxStartIndexTwo() {
//        timePeriodValues.add(new TimePeriodValue(new Day(2, 1, 2022), 100));
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 1, 2022), 200));
//        assertEquals(1, timePeriodValues.getMinStartIndex());
//        assertEquals(0, timePeriodValues.getMaxStartIndex());
//    }
//
//    @Test
//    public void testMinMaxMiddleIndexTwo() {
//        timePeriodValues.add(new TimePeriodValue(new Day(2, 1, 2022), 100));
//        timePeriodValues.add(new TimePeriodValue(new Day(1, 2, 2022), 200));
//        assertEquals(0, timePeriodValues.getMinMiddleIndex());
//        assertEquals(1, timePeriodValues.getMaxMiddleIndex());
//    }
//
//    @Test
//    public void testInvalidInputsTwo() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            timePeriodValues.add(null);
//        });
//    }



    //Mini

    //Versuch 3
    // Test zum Klonen der Zeitreihen-Datenstruktur
    @Test
    public void testCloneMini() throws CloneNotSupportedException {
        TimePeriodValue originalValue = new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10);
        timePeriodValues.add(originalValue);

        TimePeriodValues<String> clonedSeries = (TimePeriodValues<String>) timePeriodValues.clone();

        // Ändern Sie den geklonten Wert
        clonedSeries.update(0, 20);

        // Überprüfen Sie, ob das Original unverändert bleibt
        assertNotEquals(originalValue.getValue(), clonedSeries.getValue(0));
        assertEquals(originalValue.getValue(), timePeriodValues.getValue(0));
    }


    // Test zur Serialisierung der Zeitreihen-Datenstruktur
    @Test
    public void testSerializationMini() throws Exception {
        timePeriodValues.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10));

        // Serialisieren
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(timePeriodValues);
        oos.flush();
        oos.close();

        // Deserialisieren
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        TimePeriodValues<String> deserializedSeries = (TimePeriodValues<String>) ois.readObject();

        assertEquals(timePeriodValues, deserializedSeries);
    }

    // Test zur Prüfung der Gleichheit von zwei Zeitreihen-Datenstrukturen
    @Test
    public void testEqualsMini() {
        TimePeriodValues<String> anotherSeries = new TimePeriodValues<>("Test Series");
        anotherSeries.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10));
        timePeriodValues.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10));

        assertEquals(timePeriodValues, anotherSeries);

        // Verschiedene Werte hinzufügen
        anotherSeries.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 20));
        assertNotEquals(timePeriodValues, anotherSeries);
    }

    // Test zum Löschen von Werten aus der Zeitreihen-Datenstruktur
    @Test
    public void testDeleteValuesMini() {
        timePeriodValues.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10));
        timePeriodValues.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 20));

        assertEquals(2, timePeriodValues.getItemCount());

        timePeriodValues.delete(0, 1);

        assertEquals(0, timePeriodValues.getItemCount());
    }

    // Test, um sicherzustellen, dass beim Hinzufügen von Elementen ein Ereignis ausgelöst wird
    @Test
    public void testListenerTriggeredOnAddMini() {
        final boolean[] eventTriggered = {false};

        SeriesChangeListener listener = event -> eventTriggered[0] = true;
        timePeriodValues.addChangeListener(listener); // Ändere die Methode hier

        timePeriodValues.add(new TimePeriodValue(new SimpleTimePeriod(new Date(), new Date()), 10));

        assertTrue(eventTriggered[0]);
    }

    // Test zum Abrufen des niedrigsten und höchsten Startindex
    @Test
    public void testMinMaxStartIndexMini() {
        TimePeriod period1 = new SimpleTimePeriod(new Date(System.currentTimeMillis() - 10000), new Date());
        TimePeriod period2 = new SimpleTimePeriod(new Date(), new Date(System.currentTimeMillis() + 10000));

        timePeriodValues.add(new TimePeriodValue(period1, 10));
        timePeriodValues.add(new TimePeriodValue(period2, 20));

        assertEquals(0, timePeriodValues.getMinStartIndex());
        assertEquals(1, timePeriodValues.getMaxStartIndex());
    }

    // Test zum Abrufen des mittleren Indexes
    @Test
    public void testMiddleIndexMini() {
        TimePeriod period1 = new SimpleTimePeriod(new Date(System.currentTimeMillis() - 10000), new Date());
        TimePeriod period2 = new SimpleTimePeriod(new Date(), new Date(System.currentTimeMillis() + 10000));

        timePeriodValues.add(new TimePeriodValue(period1, 10));
        timePeriodValues.add(new TimePeriodValue(period2, 20));

        assertEquals(0, timePeriodValues.getMinMiddleIndex());
        assertEquals(1, timePeriodValues.getMaxMiddleIndex());
    }

    @Test
    public void testInvalidInputThrowsException() {
        // Erwarte, dass IllegalArgumentException bei null geworfen wird
        assertThrows(IllegalArgumentException.class, () -> timePeriodValues.add(null));
    }

    @Test
    public void testAddValueMini() {
        TimePeriod period = new SimpleTimePeriod(new Date(), new Date());
        timePeriodValues.add(period, 10.0); // Fügen Sie hier 10.0 hinzu, um mit Double übereinzustimmen

        assertEquals(1, timePeriodValues.getItemCount());
        assertEquals(10.0, timePeriodValues.getValue(0)); // Ändern Sie auch dies auf 10.0
    }

}
