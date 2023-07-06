import java.util.Arrays;

public class MyArray<T extends Comparable<T>> {
    T[] array;
    public MyArray(T[] array){
        this.array = array;
    }
    public T[] getArray() {
        return array;
    }
    public void setArray(T[] array) {
        this.array = array;
    }
    public int length() {
        return array.length;
    }
    public T getElement(int index) {
        return array[index];
    }
    public void setElement(int index, T element) {
        array[index] = element;
    }
    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public T getMax() {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
    public T getMin() {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }
    public double getAvg() {
        if (array.length == 0) {
            throw new ArithmeticException("Cannot calculate average of an empty array");
        }
        double sum = 0.0;
        for (T element : array) {
            if (element instanceof Number) {
                sum += ((Number) element).doubleValue();
            }
            else {
                throw new IllegalArgumentException("Elements must be numeric");
            }
        }
        return sum / array.length;
    }
}
