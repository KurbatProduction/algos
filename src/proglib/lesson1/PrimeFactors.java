package proglib.lesson1;

import java.io.*;

public class PrimeFactors {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        int n = readInt(reader);
        closeReader(reader);
//        long start = System.currentTimeMillis();
        String primeFactors = getPrimeFactors(n);
//        long time = System.currentTimeMillis() - start;
        BufferedWriter writer = getWriter();
        write(writer, primeFactors);
//        write(writer, "\n" + time + " ms");
        closeWriter(writer);
    }

    public static String getPrimeFactors(int n) {
        StringBuilder result = new StringBuilder();
        while (n % 2 == 0) {
            result.append(2 + " ");
            n /= 2;
        }
        for (int i = 3; i < n; i += 2) {
            while (n % i == 0) {
                result.append(i).append(" ");
                n /= i;
            }
        }

        if (n > 2) {
            result.append(n);
        }

        return result.toString().trim();
    }

    public static BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static int readInt(BufferedReader reader) {
        try {
            return Integer.parseInt(reader.readLine());
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
