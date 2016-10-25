package labs.lab1.p3;

import java.util.Arrays;
import java.util.stream.*;

final class IntegerArray {
    private int[] intArray;

    public IntegerArray(int a[]){
        intArray = new int[a.length];
        intArray = Arrays.copyOf(a,a.length);
    }

    public int length() {
        return intArray.length;
    }

    public int getElementAt(int i) {
        return intArray[i];
    }

    public int sum() {
        return IntStream.of(intArray).sum();
    }

    public double average() {
        return (double)sum()/length();
    }

    public IntegerArray getSorted() {
        int[] sorted = Arrays.copyOf(intArray,length());
        Arrays.sort(sorted);
        return new IntegerArray(sorted);
    }

    public IntegerArray concat(IntegerArray ia) {
        int[] iaArray = new int[ia.length()];
        for (int i = 0; i < ia.length(); ++i) {
            iaArray[i] = ia.getElementAt(i);
        }
        return new IntegerArray(IntStream.concat(Arrays.stream(intArray), Arrays.stream(iaArray))
                .toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerArray)) return false;

        IntegerArray that = (IntegerArray) o;

        return Arrays.equals(intArray, that.intArray);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(intArray);
    }

    @Override
    public String toString() {
        return Arrays.toString(intArray);
    }
}
