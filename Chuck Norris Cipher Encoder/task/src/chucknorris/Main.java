package chucknorris;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        decode();
    }

    private static void decode() {
        System.out.println("Input encoded string:");

        String message = scanner.nextLine();

        String binary = chuckNorrisToBinary(message);
        String decoded = binaryToString(binary);

        System.out.println("The result:");
        System.out.println(decoded);
    }


    private static String chuckNorrisToBinary(String message) {
        String[] blocks = message.split(" ");
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < blocks.length - 1; i += 2) {
            if (blocks[i].equals("0")) {
                binary.append("1".repeat(blocks[i + 1].length()));
            } else {
                binary.append("0".repeat(blocks[i + 1].length()));
            }
        }

        return binary.toString();
    }

    private static String binaryToString(String binary) {
        String[] binaries = SplitStringEveryNthChar(binary, 7);

        StringBuilder decodedMessage = new StringBuilder();
        for (String s : binaries) {
            char c = (char) Integer.parseInt(s, 2);
            decodedMessage.append(c);
        }

        return decodedMessage.toString();
    }

    private static String[] SplitStringEveryNthChar(String text, int n) {
        return text.split("(?<=\\G.{" + n + "})");
    }

    private static void encode() {
        System.out.println("Input string:");

        String input = scanner.nextLine();

        System.out.println("""
                The result:
                """);

        StringBuilder binary = new StringBuilder();
        for (var c : input.toCharArray()) {
            binary.append(stringToBinaryString(c));
        }

        String chuckNorris = binaryToChuckNorris(binary.toString());
        System.out.println(chuckNorris);
    }

    private static String stringToBinaryString(char c) {
        return String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0");
    }

    private static String binaryToChuckNorris(String binary) {

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