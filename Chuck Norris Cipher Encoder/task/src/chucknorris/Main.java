package chucknorris;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input string:");

        String input = scanner.nextLine();
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (var c : input.toCharArray()) {
            sb.append(c).append(" ");
        }

        System.out.println(sb.toString());
    }
}