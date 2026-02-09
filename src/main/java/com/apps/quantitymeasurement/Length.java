package com.apps.quantitymeasurement;
import java.util.Objects;
public class Length {
    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }
    /* ---------- PRIVATE BASE CONVERSION ---------- */
    private double convertToBaseUnit() {
        // Base unit = inches
        return this.value * this.unit.getConversionFactor();
    }

    /* ---------- UC3/UC4 COMPARISON ---------- */

    private boolean compare(Length that) {
        return Double.compare(
                this.convertToBaseUnit(),
                that.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length that = (Length) o;
        return compare(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    /* ---------- UC5 CONVERSION API ---------- */

    /**
     * Converts this Length to the target unit.
     * Returns a NEW immutable Length object.
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = convertToBaseUnit(); // inches
        double convertedValue = baseValue / targetUnit.getConversionFactor();

        // rounding to 2 decimal places
        double rounded = Math.round(convertedValue * 100.0) / 100.0;

        return new Length(rounded, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}