package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void yardToYardSameValue() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(1.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    void yardToFeetEquivalent() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    void yardToInchesEquivalent() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(36.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    void centimetersToInchesEquivalent() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.CENTIMETERS),
                new Length(0.393701, Length.LengthUnit.INCHES)
        );
    }

    @Test
    void centimetersToFeetNotEqual() {
        assertNotEquals(
                new Length(1.0, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    void transitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

    @Test
    void reflexiveProperty() {
        Length length = new Length(2.0, Length.LengthUnit.YARDS);
        assertEquals(length, length);
    }

    @Test
    void nullComparison() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(length, null);
    }

    @Test
    void nullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }
}