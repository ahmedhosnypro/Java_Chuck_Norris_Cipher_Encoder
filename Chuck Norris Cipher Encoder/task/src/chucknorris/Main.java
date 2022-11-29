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

        StringBuilder binary = new StringBuilder();
        for (var c : input.toCharArray()) {
            binary.append(toBinaryString(c));
        }

        String chuckNorris = toChuckNorris(binary.toString());
        System.out.println(chuckNorris);
    }

    private static String toBinaryString(char c) {
        return String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0");
    }

    private static String toChuckNorris(String binary) {

        StringBuilder chuckNorris = new StringBuilder();

        int loopNumber = binary.charAt(0) - '0';
        int blockLength = 1;

        char[] binaries = binary.toCharArray();

        for (int i = 1; i < binaries.length; i++) {
            if (binaries[i] - '0' == loopNumber) {
                blockLength++;
            } else {
                if (loopNumber == 0) {
                    chuckNorris.append("00 ").append("0".repeat(blockLength)).append(" ");
                } else {
                    chuckNorris.append("0 ").append("0".repeat(blockLength)).append(" ");
                }

                loopNumber = binaries[i] - '0';
                blockLength = 1;
            }
        }

        if (loopNumber == 0) {
            chuckNorris.append("00 ").append("0".repeat(blockLength)).append(" ");
        } else {
            chuckNorris.append("0 ").append("0".repeat(blockLength)).append(" ");
        }
        return chuckNorris.toString();
    }
}