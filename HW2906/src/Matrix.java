import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix<T extends Number> {
    T[][] matrix;
    int rows;
    int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = createMatrix(rows, columns);
    }

    private T[][] createMatrix(int rows, int columns) {
        @SuppressWarnings("unchecked")
        T[][] newMatrix = (T[][]) new Number[rows][columns];
        return newMatrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public T getElement(int row, int column) {
        return matrix[row][column];
    }

    public void setElement(int row, int column, T element) {
        matrix[row][column] = element;
    }

    public void fillFromKeyboard(Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at row " + (i + 1) + ", column " + (j + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    matrix[i][j] = (T) Double.valueOf(scanner.nextDouble());
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.nextLine();
                    j--;
                }
            }
        }
    }

    public void fillRandomly() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double randomValue = random.nextDouble();
                matrix[i][j] = (T) Double.valueOf(randomValue);
            }
        }
    }

    public void showMatrix() {
        for (T[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public Matrix<T> add(Matrix<T> other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double sum = this.getElement(i, j).doubleValue() + other.getElement(i, j).doubleValue();
                result.setElement(i, j, (T) Double.valueOf(sum));
            }
        }
        return result;
    }

    public T findMinElement() {
        T min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j].doubleValue() < min.doubleValue()) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public T findMaxElement() {
        T max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j].doubleValue() > max.doubleValue()) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public double calculateAverageValue() {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j].doubleValue();
                count++;
            }
        }
        return sum / count;
    }
}
