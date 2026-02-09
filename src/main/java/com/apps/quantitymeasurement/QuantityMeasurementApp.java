package com.apps.quantitymeasurement;
public class QuantityMeasurementApp {
    /* ---------- EQUALITY (UC3/UC4) ---------- */

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    /* ---------- UC5: STATIC CONVERSION ---------- */

    public static double convert(double value,
                                 LengthUnit from,
                                 LengthUnit to) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double baseValue = value * from.getConversionFactor(); // inches
        return baseValue / to.getConversionFactor();
    }

    /* ---------- UC5: OVERLOADED INSTANCE CONVERSION ---------- */

    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit from,
            LengthUnit to) {

        return new Length(value, from).convertTo(to);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit to) {

        return length.convertTo(to);
    }

    /* ---------- MAIN DEMO ---------- */

    public static void main(String[] args) {
        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCHES)); // 12.0
        System.out.println(convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));  // 9.0
        System.out.println(convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS)); // 1.0

        Length l = new Length(100.0, LengthUnit.CENTIMETERS);
        System.out.println(l.convertTo(LengthUnit.INCHES)); // 39.37 INCHES
    }
}