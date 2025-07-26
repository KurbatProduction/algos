package proglib.lesson5.BracketsSequence;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsSequence {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        String input = read(reader);
        close(reader);

        String output = validateSequence(input);

        BufferedWriter writer = getWriter();
        write(writer, output);
        close(writer);
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static String validateSequence(String input) {
        if (input.isBlank()) return input;

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isOpening(c)) stack.push(c);
            else if (isClosing(c)) {
                if (!stack.isEmpty()) {
                    if (isMatching(stack.peek(), c)) stack.pop();
                    else return IMPOSSIBLE;
                }
            }
        }

        while (!stack.isEmpty()) {
            result.append(closingFor(stack.pop()));
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (isClosing(c)) stack.push(c);
            else if (isOpening(c)) {
                if (!stack.isEmpty()) {
                    if (isMatching(c, stack.peek())) stack.pop();
                    else return IMPOSSIBLE;
                }
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, openingFor(stack.pop()));
        }

        return result.toString();
    }

    public static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    public static char openingFor(char close) {
        return switch (close) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> throw new IllegalArgumentException("Invalid closing bracket: " + close);
        };
    }

    public static char closingFor(char open) {
        return switch (open) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> throw new IllegalArgumentException("Invalid opening bracket: " + open);
        };
    }

    public static BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static String read(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedWriter getWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void write(BufferedWriter writer, String value) {
        try {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(BufferedWriter writer) {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
