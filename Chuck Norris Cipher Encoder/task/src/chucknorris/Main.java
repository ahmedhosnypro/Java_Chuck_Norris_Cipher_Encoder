package chucknorris;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input string:");

        String input = scanner.nextLine();

        System.out.println("""
                The result:
                """);


        for (var c : input.toCharArray()) {
            System.out.print(c + " = ");
            System.out.print(String.format("%7s%n", Integer.toBinaryString(c)).replace(" ", "0"));
        }
    }
}