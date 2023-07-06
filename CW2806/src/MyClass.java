import java.util.Arrays;

public class MyClass {
    public static <T extends Comparable<T>> T max(T a, T... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        T val = a;
        for (T arg : args) {
            if (arg.compareTo(val) > 0) val = arg;
        }
        return val;
    }

    public static <T extends Comparable<T>> T min(T a, T... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Second argument be null or empty.");
        }
        T val = a;
        for (T arg : args) {
            if (arg.compareTo(val) < 0) val = arg;
        }
        return val;
    }

    public static <T extends Number> double avg(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Second argument cannot be null or empty.");
        }
        double sum = 0d;
        for (T num : arr) {
            sum += num.doubleValue();
        }
        return sum / arr.length;
    }
    public static <T extends Comparable<T>> T[] sort(T[] a, boolean desc) {
        Arrays.sort(a);
        if (desc) {
            int i = 0;
            int j = a.length - 1;
            while (i < j) {
                T temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return a;
    }
    public static <T extends Comparable<T>> int binarySearch(T[] array, T key){
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = array[mid].compareTo(key);
            if (comparison < 0) {
                low = mid + 1;
            } else if (comparison > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
