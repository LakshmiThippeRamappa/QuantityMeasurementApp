package com.apps.quantitymeasurement;

/**
 * This class is responsible for checking the equality of two numerical values
 * measured in feet in the Quantity Measurement Application.
 */
public class QuantityMeasurementApp {

    /**
     * Inner class to represent Feet measurement
     */
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        /**
         * Overrides equals() method to compare two Feet objects
         */
        @Override
        public boolean equals(Object obj) {

            // 1. Reference check
            if (this == obj) {
                return true;
            }

            // 2. Null check
            if (obj == null) {
                return false;
            }

            // 3. Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // 4. Cast safely
            Feet other = (Feet) obj;

            // 5. Value comparison using Double.compare
            return Double.compare(this.value, other.value) == 0;
        }
    }

    /**
     * Main method to demonstrate feet equality
     */
    public static void main(String[] args) {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Equal : " + feet1.equals(feet2));
    }
}