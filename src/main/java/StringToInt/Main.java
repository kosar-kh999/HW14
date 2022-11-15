package StringToInt;

import java.util.Scanner;

import static StringToInt.Convert.stringConvert;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter your string");
        String str = scanner.nextLine();
        System.out.println("this is string to int : " + stringConvert(str));
    }
}
