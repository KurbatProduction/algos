package proglib.lesson2.NumberSystem;

import java.io.*;

public class NumberSystem {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        String num = read(reader);
        closeReader(reader);

        int fractionsSum = parseToDecimal(num);

        BufferedWriter writer = getWriter();
        write(writer, String.valueOf(fractionsSum));
        closeWriter(writer);
    }

    public static int parseToDecimal(String str) {
        int base = str.chars().map(c -> c - '0').max().orElse(0) + 1;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = result * base + (str.charAt(i) - '0');
        }
        return result;
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

    public static void closeReader(BufferedReader reader) {
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

    public static void closeWriter(BufferedWriter writer) {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
