package com.apps.quantitymeasurement;
//UC4
public class QuantityMeasurementApp {

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        boolean result = length1.equals(length2);

        System.out.println(
                "Input: Quantity(" + value1 + ", " + unit1 + ") and Quantity(" +
                        value2 + ", " + unit2 + ")\nOutput: Equal (" + result + ")\n"
        );
        return result;
    }

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS,
                2.0, Length.LengthUnit.YARDS);

        demonstrateLengthComparison(2.0, Length.LengthUnit.CENTIMETERS,
                2.0, Length.LengthUnit.CENTIMETERS);

        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                0.393701, Length.LengthUnit.INCHES);
    }
}