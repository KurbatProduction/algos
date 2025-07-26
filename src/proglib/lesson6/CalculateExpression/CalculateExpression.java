package proglib.lesson6.CalculateExpression;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateExpression {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        String input = read(reader);
        close(reader);

        String postfix = getPostfix(input);
        int output = calculatePostfix(postfix);

        BufferedWriter writer = getWriter();
        write(writer, String.valueOf(output));
        close(writer);
    }

    public static String getPostfix(String input) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if (isDigit(c)) postfix.append(c);
            else if (isOpenedBracket(c)) stack.push(c);
            else {
                if (isDigit(postfix.charAt(postfix.length() - 1))) postfix.append(' ');
                if (isClosedBracket(c)) {
                    while (!stack.isEmpty() && !isOpenedBracket(stack.peek()))
                        postfix.append(stack.pop());
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && isMajorOperator(stack.peek(), c))
                        postfix.append(stack.pop());
                    stack.push(c);
                }
            }
        }

        if (!stack.isEmpty()) {
            if (isDigit(postfix.charAt(postfix.length() - 1))) postfix.append(' ');
            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }
        }
        return postfix.toString();
    }

    public static boolean isMajorOperator(char first, char second) {
        if (first == '(') return false;
        if (first == '*' || first == '/') return true;
        else return second != '*' && second != '/';
    }

    public static boolean isOpenedBracket(char c) {
        return c == '(';
    }

    public static boolean isClosedBracket(char c) {
        return c == ')';
    }

    /*
       1 2 3 *+4 5 *+ ->
       '1' кладем в стек: stack(1)
       '2' кладем в стек: stack(1, 2)
       '3' кладем в стек: stack(1, 2, 3)
       '*' применяем к двум последним элементам в стеке: stack(1, 6)
       '+' применяем к двум последним элементам в стеке: stack(7)
       '4' кладем в стек: stack(7, 4)
       '5' кладем в стек: stack(7, 4, 5)
       '*' применяем к двум последним элементам в стеке: stack(7, 20)
       '+' применяем к двум последним элементам в стеке: stack(27)
       выводим единственное число в стеке
    */
    public static int calculatePostfix(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        int buffer = 0;
        for (char c : postfix.toCharArray()) {
            if (isDigit(c)) buffer = buffer * 10 + (c - '0');
            else if (isSpace(c)) {
                stack.push(buffer);
                buffer = 0;
            } else stack.push(calculate(stack.pop(), stack.pop(), c));
        }
        return stack.pop();
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isSpace(char c) {
        return c == ' ';
    }

    public static int calculate(int second, int first, char operation) {
        return switch (operation) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> -1;
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
