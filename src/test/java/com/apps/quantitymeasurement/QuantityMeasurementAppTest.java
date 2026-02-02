package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    /* ---------- Feet Tests ---------- */

    @Test
    void testFeetEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testFeetEquality_NullComparison() {
        Feet f = new Feet(1.0);

        assertFalse(f.equals(null));
    }

    @Test
    void testFeetEquality_DifferentClass() {
        Feet f = new Feet(1.0);
        Inches i = new Inches(12.0);

        assertFalse(f.equals(i));
    }

    @Test
    void testFeetEquality_SameReference() {
        Feet f = new Feet(1.0);

        assertTrue(f.equals(f));
    }

    /* ---------- Inches Tests ---------- */

    @Test
    void testInchesEquality_SameValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    void testInchesEquality_NullComparison() {
        Inches i = new Inches(1.0);

        assertFalse(i.equals(null));
    }

    @Test
    void testInchesEquality_DifferentClass() {
        Inches i = new Inches(1.0);
        Feet f = new Feet(1.0);

        assertFalse(i.equals(f));
    }

    @Test
    void testInchesEquality_SameReference() {
        Inches i = new Inches(1.0);

        assertTrue(i.equals(i));
    }
}