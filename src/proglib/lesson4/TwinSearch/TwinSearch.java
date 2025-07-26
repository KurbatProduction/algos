package proglib.lesson4.TwinSearch;

import java.io.*;

public class TwinSearch {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        read(reader); // reading array1 length
        int[] a = parseIntArray(read(reader));
        read(reader); // reading array2 length
        int[] b = parseIntArray(read(reader));
        closeReader(reader);

        String output = twinSearch(a, b);

        BufferedWriter writer = getWriter();
        write(writer, output);
        closeWriter(writer);
    }

    public static String twinSearchNaive(int[] a, int[] b) {
        StringBuilder result = new StringBuilder();

        for (int value : b) {
            int delta = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;

            if (value <= a[0]) {
                result.append(0).append(" ");
                continue;
            }
            if (value >= a[a.length - 1]) {
                result.append(a.length - 1).append(" ");
                continue;
            }

            for (int i = 0; i < a.length; i++) {
                int currentDelta = Math.abs(value - a[i]);
                if (a[i] > value && currentDelta >= delta) {
                    break;
                }
                if (currentDelta < delta) {
                    delta = currentDelta;
                    index = i;
                }
            }

            result.append(index).append(" ");
        }
        return result.toString().trim();
    }

    public static String twinSearch(int[] a, int[] b) {
        StringBuilder result = new StringBuilder();

        for (int value : b) {
            int index = binarySearch(a, value);
            result.append(index).append(" ");
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }

    public static int binarySearch(int[] a, int value) {
        if (value <= a[0]) return 0;
        if (value >= a[a.length - 1]) return a.length - 1;

        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] <= value) left = mid + 1;
            else right = mid;
        }
        if (left > a.length - 1) return a.length - 1;

        int prev = left - 1;
        if (Math.abs(a[prev] - value) <= Math.abs(a[left] - value)) {
            return prev;
        } else {
            return left;
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
