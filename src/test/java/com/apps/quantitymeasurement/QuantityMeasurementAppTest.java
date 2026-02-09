package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testFeetToInches() {
        double result = QuantityMeasurementApp.convert(1.0,
                LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPS);
    }

    @Test
    void testYardsToInches() {
        double result = QuantityMeasurementApp.convert(1.0,
                LengthUnit.YARDS, LengthUnit.INCHES);
        assertEquals(36.0, result, EPS);
    }

    @Test
    void testCentimetersToInches() {
        double result = QuantityMeasurementApp.convert(1.0,
                LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertEquals(0.393701, result, EPS);
    }

    @Test
    void testInstanceConversion() {
        Length length = new Length(3.0, LengthUnit.FEET);
        Length converted = length.convertTo(LengthUnit.INCHES);
        assertEquals(new Length(36.0, LengthUnit.INCHES), converted);
    }

    @Test
    void testRoundTripConversion() {
        double v = QuantityMeasurementApp.convert(
                QuantityMeasurementApp.convert(2.0,
                        LengthUnit.YARDS, LengthUnit.FEET),
                LengthUnit.FEET, LengthUnit.YARDS);
        assertEquals(2.0, v, EPS);
    }

    @Test
    void testInvalidValueThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN,
                        LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void testNullUnitThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0,
                        null, LengthUnit.INCHES));
    }
}