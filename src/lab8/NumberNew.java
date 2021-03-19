package lab8;

import java.text.DecimalFormat;

public class NumberNew {
    private double number;
    DecimalFormat df = new DecimalFormat("0.00");

    public NumberNew() {
        setValue((double) (Math.random() * 100));
    }

    public NumberNew(double n) {
        setValue(n);
    }

    public void setValue(double n) {
        number = n;
    }

    public double getValue() {
        return (number);
    }

    public String toString() {
        //return (double.toString(getValue()));
        return df.format(getValue());
    }

    public void add(double n) {
        setValue(getValue() + n);
    }

    public void subtract(double n) {
        setValue(getValue() - n);
    }

    public void multiply(double n) {
        setValue(getValue() * n);
    }

    public void divide(double n) {
        setValue(getValue() / n);
    }

    public void percent(double n) {
        setValue(getValue() * n / 100);
    }

    public void squareroot(double n) {
        setValue(Math.sqrt(n));
    }

    public void positive(double n) {
        setValue(n-n-n);
    }
}
