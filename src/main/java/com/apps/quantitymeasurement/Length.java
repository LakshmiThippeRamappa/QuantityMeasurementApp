package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Base unit: INCHES
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),           // 1 yard = 36 inches
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double toInches(double value) {
            return value * conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.toInches(value);
    }

    public boolean compare(Length other) {
        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return compare(length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }
}