package proglib.lesson1;

import java.io.*;

public class FactorialNulls {

    public static void main(String[] args){
        BufferedReader reader = getReader();
        int n = readInt(reader);
        closeReader(reader);

        int countOfNulls = countOfNulls(n);

        BufferedWriter writer = getWriter();
        write(writer, countOfNulls);
        closeWriter(writer);
    }

    private static int countOfNulls(int n) {
        int k = n / 5;
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count += n / fiveInPower(i);
        }
        return count;
    }

    private static int fiveInPower(int n) {
        int result = 1;
        int aInPowerOf2 = 5;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= aInPowerOf2;
            }
            aInPowerOf2 *= aInPowerOf2;
            n >>= 1;
        }
        return result;
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

    public static void write(BufferedWriter writer, int intValue) {
        try {
            writer.write(String.valueOf(intValue));
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