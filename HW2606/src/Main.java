import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //t1
//        System.out.println("""
//                 "Your time is limited,\s
//                \tso don’t waste it\s
//                \t\tliving someone else’s life"\s
//                \t\t\tSteve Jobs""");

        //t2
//        Scanner scan = new Scanner(System.in);
//        int x = 0,y = 0;
//        System.out.print("Input a number: ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        System.out.print("Input value of percente: ");
//        if(scan.hasNextInt()){
//            y = scan.nextInt();
//        }
//        if(y>100) y=100;
//        else if (y<0) y=0;
//        System.out.println(y + " percent from " + x + " is " + (x*(y*1.0/100)));

        //t3
//        Scanner scan = new Scanner(System.in);
//        StringBuilder str = new StringBuilder();
//        boolean hasError = false;
//        for (int i = 0; i < 3 && !hasError; i++) {
//            System.out.print("Input "+(i+1)+"-st digit: ");
//            if (scan.hasNextLine()) {
//                String tmp=scan.nextLine();
//                if(tmp.length() != 1){
//                    hasError = true;
//                }
//                try {
//                    Integer.parseInt(tmp);
//                }
//                catch (Exception e){
//                    hasError = true;
//                }
//                str.append(tmp);
//            }
//            else hasError = true;
//        }
//        if(hasError){
//            System.out.println("You input not a number or not a digit");
//            return;
//        }
//        System.out.println("Your number is: " + str);

        //t4
//        Scanner scan = new Scanner(System.in);
//        String str = "";
//        System.out.print("Input a number with 6 digit: ");
//        if(scan.hasNextLine()){
//            str = scan.nextLine();
//        }
//        try {
//            Integer.parseInt(str);
//        }
//        catch (Exception e){
//            System.out.println("You input NaN");
//            return;
//        }
//        if(str.length() != 6) {
//            System.out.println("Your number is not has a 6 digit");
//            return;
//        }
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < 2; i++) {
//            char tmp = chars[chars.length-i-1];
//            chars[chars.length-i-1] = chars[i];
//            chars[i] = tmp;
//        }
//        System.out.println("Your number is: " + str + ". I say: " + new String(chars));

        //t5
//        Scanner scan = new Scanner(System.in);
//        int month = 0;
//        do{
//            System.out.print("Input a number of the month: ");
//            if(scan.hasNextInt()){
//                month = scan.nextInt();
//            }
//        }while (month<1||month>12);
//        switch (month) {
//            case 1, 2, 12 -> System.out.println("Winter");
//            case 3, 4, 5 -> System.out.println("Spring");
//            case 6, 7, 8 -> System.out.println("Summer");
//            case 9, 10, 11 -> System.out.println("Autumn");
//        }

        //t6
//        Scanner scan = new Scanner(System.in);
//        int x = 0,y = 0;
//        System.out.print("Input a number of metres: ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        do {
//            System.out.print("Select converter: 0-miles, 1-yards, 2-inches - ");
//            if (scan.hasNextInt()) {
//                y = scan.nextInt();
//            }
//        }while (y<0||y>2);
//        switch (y){
//            case 0 -> System.out.println(x*0.000621371 + " miles");
//            case 1 -> System.out.println(x*1.09361296 + " yards");
//            case 2 -> System.out.println(x*39.370066559999998 + " inches");
//        }

        //t7
//        Scanner scan = new Scanner(System.in);
//        int x = 0,y = 0;
//        System.out.print("Input begin of the range: ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        System.out.print("Input end of the range: ");
//        if(scan.hasNextInt()){
//            y = scan.nextInt();
//        }
//        if(x>y) x = x^y^(y = x);
//        System.out.print("Is even numbers: ");
//        for (int i = x; i <= y; i++) {
//            if(i%2==0) System.out.print(i+",");
//        }

        //t8
//        Scanner scan = new Scanner(System.in);
//        int x = 0, y = 0;
//        System.out.print("Input begin of the range: ");
//        if (scan.hasNextInt()) {
//            x = scan.nextInt();
//        }
//        System.out.print("Input end of the range: ");
//        if (scan.hasNextInt()) {
//            y = scan.nextInt();
//        }
//        if (x > y) x = x ^ y ^ (y = x);
//        for (int i = x; i <= y; i++) {
//            for (int j = 1; j <= 10; j++) {
//                System.out.println(i+" x "+(j<10?" ":"")+j+" = " + (i*j));
//            }
//            System.out.println("################################");
//        }

        //t9
//        int[] arr = new int[100];
//        int max = 0, min = 0, countPlus = 0, countMinus = 0, countZero = 0;
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int)(Math.random()*100-50);
//            str.append(arr[i] + ",");
//            if(arr[i]>max) max = arr[i];
//            if(arr[i]<min) min = arr[i];
//            if(arr[i]<0) countMinus++;
//            else if (arr[i]>0) countPlus++;
//            else countZero++;
//        }
//        str.deleteCharAt(str.length()-1);
//        System.out.println("Array: [" + str + "]");
//        System.out.println("Max: " + max);
//        System.out.println("Min: " + min);
//        System.out.println("Count of negative number: " + countMinus);
//        System.out.println("Count of positive number: " + countPlus);
//        System.out.println("Count of zero: " + countZero);

        //t10
//        int[] arr = new int[10];
//        int countEven = 0, countOdd = 0, countPlus = 0, countMinus = 0;
//        StringBuilder str = new StringBuilder(), strEven = new StringBuilder(),
//                strOdd = new StringBuilder(), strNegative = new StringBuilder(),
//                strPositive = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 100 - 50);
//            str.append(arr[i]).append(",");
//            if (arr[i] % 2 == 0) countEven++;
//            else countOdd++;
//            if (arr[i] < 0) countMinus++;
//            else if (arr[i] > 0) countPlus++;
//        }
//        str.deleteCharAt(str.length() - 1);
//        System.out.println("Started array: [" + str + "]");
//        int[] arrEven = new int[countEven];
//        int[] arrOdd = new int[countOdd];
//        int[] arrNegative = new int[countMinus];
//        int[] arrPositive = new int[countPlus];
//        for (int num : arr) {
//            if (num % 2 == 0) {
//                arrEven[--countEven] = num;
//                strEven.append(num).append(",");
//            }
//            else {
//                arrOdd[--countOdd] = num;
//                strOdd.append(num).append(",");
//            }
//            if (num < 0) {
//                arrNegative[--countMinus] = num;
//                strNegative.append(num).append(",");
//            }
//            else if (num > 0) {
//                arrPositive[--countPlus] = num;
//                strPositive.append(num).append(",");
//            }
//        }
//        strEven.deleteCharAt(strEven.length() - 1);
//        System.out.println("Even array: [" + strEven + "]");
//        strOdd.deleteCharAt(strOdd.length() - 1);
//        System.out.println("Odd array: [" + strOdd + "]");
//        strNegative.deleteCharAt(strNegative.length() - 1);
//        System.out.println("Negative array: [" + strNegative + "]");
//        strPositive.deleteCharAt(strPositive.length() - 1);
//        System.out.println("Positive array: [" + strPositive + "]");

        //t11
//        printLine(15,'~',false);
//        printLine(15,'~',true);
        //t12
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100-50);
        }
        int[] res = sortArray(arr,true);
        for (int num:res){
            System.out.print(num+", ");
        }
        System.out.println();
        res = sortArray(arr,false);
        for (int num:res){
            System.out.print(num+", ");
        }
        System.out.println();
    }
    public static void printLine(int length, char symbol, boolean isVertical) {
        for (int i = 0; i < length; i++) {
            if(isVertical) System.out.println(symbol);
            else System.out.print(symbol);
        }
    }
    public static int[] sortArray(int[] arr, boolean isUp){
        int[] res = arr.clone();
        for (int i = 0; i < res.length; i++) {
            for (int j = i+1; j < res.length; j++) {
                if(isUp){
                    if(res[i]>res[j]){
                        int tmp = res[i];
                        res[i] = res[j];
                        res[j] = tmp;
                    }
                }
                else {
                    if(res[i]<res[j]){
                        int tmp = res[i];
                        res[i] = res[j];
                        res[j] = tmp;
                    }
                }
            }
        }
        return  res;
    }
}