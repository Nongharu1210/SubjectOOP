package lab8;

class Number {
    private int number;

    public Number() {
        setValue((int) (Math.random() * 100));
    }

    public Number(int n) {
        setValue(n);
    }

    public void setValue(int n) {
        number = n;
    }

    public int getValue() {
        return (number);
    }

    public String toString() {
        return (Integer.toString(getValue()));
    }
}
