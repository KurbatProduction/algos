package proglib.lesson6.CustomQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class CustomQueue {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        int count = Integer.parseInt(read(reader));
        boolean output = true;
        for (int i = 0; i < count; i++) {
            String input = read(reader);
            int spaceIndex = input.indexOf(' ');
            output =
                    processCommand(
                            parseInt(input, 0, spaceIndex),
                            parseInt(input, spaceIndex + 1, input.length()));
        }
        close(reader);

        BufferedWriter writer = getWriter();
        write(writer, output ? YES : NO);
        close(writer);
    }

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final Queue<Integer> queue = new ArrayDeque<>();

    public static boolean processCommand(int command, int value) {
        if (command == 3) return queue.offer(value);
        else {
            Integer polled = queue.poll();
            return polled == null && value == -1 || polled != null && polled == value;
        }
    }

    public static int parseInt(CharSequence s, int begin, int end) {
        int result = 0;
        boolean negative = false;

        if (s.charAt(begin) == '-') {
            negative = true;
            begin++;
        }

        for (int i = begin; i < end; i++) {
            char c = s.charAt(i);
            result = result * 10 + (c - '0');
        }

        return negative ? -result : result;
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
