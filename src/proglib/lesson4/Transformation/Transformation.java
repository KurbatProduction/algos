package proglib.lesson4.Transformation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Transformation {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        read(reader); // reading a length
        int[] a = parseIntArray(read(reader));
        closeReader(reader);

        int output = findMinSize(a);

        BufferedWriter writer = getWriter();
        write(writer, String.valueOf(output));
        closeWriter(writer);
    }

    public static int findMinSize(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) map.put(num, map.getOrDefault(num, 0) + 1);

        int maxFrequency = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        if (maxFrequency <= (a.length + 1) / 2) {
            return a.length % 2;
        } else {
            return 2 * maxFrequency - a.length;
        }
    }

    public static int[] parseIntArray(String str) {
        String[] strArray = str.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
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
