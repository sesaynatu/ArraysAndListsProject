/**
 * Name: Taphanatu Sesay
 * Date: 3/22/2026
 * Project Week 3: Arrays and Lists
 * Description:
 * This class manages a single memory value and a collection
 * of up to 10 integer values for a calculator-style application.
 */

import java.util.ArrayList;

public class CalculatorMemory {

    private Double singleValue;
    private ArrayList<Integer> values;

    public CalculatorMemory() {
        singleValue = null;
        values = new ArrayList<>();
    }

    // Single value memory methods
    public void storeSingleValue(double value) {
        singleValue = value;
    }

    public double retrieveSingleValue() {
        return singleValue;
    }

    public void clearSingleValue() {
        singleValue = null;
    }

    public void replaceSingleValue(double value) {
        singleValue = value;
    }

    public boolean hasSingleValue() {
        return singleValue != null;
    }

    // Collection methods
    public void addValue(int value) {
        if (values.size() < 10) {
            values.add(value);
        }
    }

    public void displayValues() {
        if (values.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            System.out.println("Values currently stored: " + values);
        }
    }

    public int getCount() {
        return values.size();
    }

    public boolean removeValue(int value) {
        return values.remove(Integer.valueOf(value));
    }

    public int getSum() {
        int sum = 0;
        for (int number : values) {
            sum += number;
        }
        return sum;
    }

    public double getAverage() {
        if (values.isEmpty()) {
            return 0;
        }
        return (double) getSum() / values.size();
    }

    public int getDifferenceFirstLast() {
        if (values.size() < 2) {
            return 0;
        }
        return values.get(0) - values.get(values.size() - 1);
    }

    public boolean isCollectionFull() {
        return values.size() >= 10;
    }
}