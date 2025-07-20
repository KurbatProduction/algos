package proglib.lesson3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RequiredSum {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        read(reader); //reading array1 length
        int[] a = parseIntArray(read(reader));
        read(reader); //reading array2 length
        int[] b = parseIntArray(read(reader));
        int k = Integer.parseInt(read(reader));
        closeReader(reader);

        int output = countAlgo1(a, b, k);

        BufferedWriter writer = getWriter();
        write(writer, String.valueOf(output));
        closeWriter(writer);
    }

    public static int countNaive(int[] a, int[] b, int k) {
        int count = 0;
        Set<Integer> bSet = new HashSet<>();
        for (int bValue: b) bSet.add(bValue);
        for (int aValue: a) {
            if (bSet.contains(k - aValue)) count++;
        }
        return count;
    }

    public static int countAlgo1(int[] a, int[] b, int k) {

        int i = 0;
        int j = b.length - 1;
        int count = 0;

        while (i < a.length && j >= 0) {
            int sum = a[i] + b[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return count;
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
