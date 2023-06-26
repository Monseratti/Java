import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //t1
//        System.out.println("Fall seven times \nand \nstand up eight");

//        t2
//        Scanner scan = new Scanner(System.in);
//        int x = 0,y = 0;
//        System.out.print("Input \"x\": ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        System.out.print("Input \"y\": ");
//        if(scan.hasNextInt()){
//            y = scan.nextInt();
//        }
//        System.out.println("\"x\"+\"y\" = "+(x+y));
//        System.out.println("\"x\"-\"y\" = "+(x-y));
//        System.out.println("\"x\"*\"y\" = "+(x*y));
//        System.out.println("\"x\"/\"y\" = "+((y==0)?"NaN. Divided by zero":(x/y)));

//        t3
//        Scanner scan = new Scanner(System.in);
//        String str = "";
//        System.out.print("Input a nubmer with 4 digit: ");
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
//        if(str.length() != 4) {
//            System.out.println("Your number is not has a 4 digit");
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        System.out.println("You input: " + str + ". I say: " + sb.reverse());

//        t4
//        Scanner scan = new Scanner(System.in);
//        int x = -1;
//        do {
//            System.out.print("Input an hour: ");
//            x=scan.nextInt();
//        }while (x<0||x>24);
//        if(x>=0&&x<6){
//            System.out.println("Good Night");
//        } else if (x>=6&&x<13) {
//            System.out.println("Good Morning");
//        }else if (x>=13&&x<17) {
//            System.out.println("Good Day");
//        }else{
//            System.out.println("Good Evening");
//        }

//        t5
//        Scanner scan = new Scanner(System.in);
//        String str = "";
//        System.out.print("Input a nubmer with 6 digit: ");
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
//        int firstSum = 0;
//        int secondSum = 0;
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < 3; i++) {
//            firstSum += Integer.parseInt(String.valueOf(chars[i]));
//        }
//        for (int i = 3; i < str.length(); i++) {
//            secondSum += Integer.parseInt(String.valueOf(chars[i]));
//        }
//        if(firstSum!=secondSum){
//            System.out.println("Your number is NOT lucky");
//        }
//        else{
//            System.out.println("Your number is lucky");
//        }

//        t6
//            Scanner scan = new Scanner(System.in);
//            int x = -1;
//            System.out.print("Input a number between 1 and 100: ");
//            x=scan.nextInt();
//            if(x<0||x>100){
//                System.out.println("Your number is not between 1 and 100");
//                return;
//            }
//            if(x%3==0&&x%5==0){
//                System.out.println("Fizz Buzz");
//            } else if (x%3==0) {
//                System.out.println("Fizz");
//            } else if (x%5==0) {
//                System.out.println("Buzz");
//            } else {
//                System.out.println(x);

//            }
//        t7
//            Scanner scan = new Scanner(System.in);
//            int x = -1,factX = 1;
//            System.out.print("Input a number: ");
//            x=scan.nextInt();
//        for (int i = 2; i < x+1; i++) {
//            factX *= i;
//        }
//            System.out.println("Factorial by "+x+" is: " +factX);

//        t8
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
//        if(x>y) return;
//        List<Integer> simpleArray = new ArrayList<>();
//        for (int i = x; i <= y; i++) {
//            boolean isSimple = true;
//            for (int j = 2; j <= i; j++) {
//                if(i%j==0&&i!=j){
//                    isSimple = false;
//                    break;
//                }
//            }
//            if(isSimple) simpleArray.add(i);
//        }
//        System.out.println("Array of simple numbers is: "+simpleArray);

//        t9
//        Scanner scan = new Scanner(System.in);
//        int x = 0;
//        float sum = 0;
//        String strArray = "";
//        System.out.print("Input size of array: ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        if(x<=0) return;
//        int[] arr = new int[x];
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("Input "+(i+1)+"-st element of array: ");
//            if(scan.hasNextInt()){
//                arr[i] = scan.nextInt();
//                sum+=arr[i];
//                strArray += arr[i]+",";
//            }
//            else i--;
//        }
//        System.out.println("Array: "+strArray);
//        System.out.println("Sum elements: "+sum);
//        System.out.println("Average elements: "+sum/arr.length);

//        t10
//        Scanner scan = new Scanner(System.in);
//        int x = 0, y = 0, count = 0;
//        System.out.print("Input size of array: ");
//        if(scan.hasNextInt()){
//            x = scan.nextInt();
//        }
//        if(x<=0) return;
//        int[] arr = new int[x];
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("Input "+(i+1)+"-st element of array: ");
//            if(scan.hasNextInt()){
//                arr[i] = scan.nextInt();
//            }
//            else i--;
//        }
//        System.out.print("Input some number: ");
//        if(scan.hasNextInt()) {
//            y = scan.nextInt();
//        }
//        for (int j : arr) {
//            if (j == y) count++;
//        }
//        System.out.println("Number "+y+" counted in array "+count+" pcs");

        //        t11
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
//        if(x>y) return;
//        System.out.println("Sum numbers in range is: "+countSum(x,y));

//        t12
        Scanner scan = new Scanner(System.in);
        int x = 0, y = 0, count = 0;
        System.out.print("Input size of array: ");
        if(scan.hasNextInt()){
            x = scan.nextInt();
        }
        if(x<=0) return;
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Input "+(i+1)+"-st element of array: ");
            if(scan.hasNextInt()){
                arr[i] = scan.nextInt();
            }
            else i--;
        }
        int[] factArray = countArrayFactorial(arr);
        System.out.print("Result: ");
        for (int i:factArray){
            System.out.print(i+",");
        }
    }

    public static int countSum(int x, int y){
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum +=i;
        }
        return sum;
    }
    public static int[] countArrayFactorial(int[] x){
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            int fact = 1;
            for (int j = 2; j <= x[i]; j++) {
                fact*=j;
            }
            result[i] = fact;
        }
        return result;
    }
}