package proglib.lesson2;

import java.io.*;

public class FractionsSum {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        int[] nums = parseIntArray(read(reader));
        closeReader(reader);

        String fractionsSum = fractionsSum(nums);

        BufferedWriter writer = getWriter();
        write(writer, fractionsSum);
        closeWriter(writer);
    }

    public static String fractionsSum(int[] nums) {
        int LCM = nums[1] * nums[3] / GCD(nums[1], nums[3]);

        nums[0] = nums[0] * (LCM / nums[1]) + nums[2] * (LCM / nums[3]);

        int GCD = GCD(nums[0], LCM);

        return nums[0] / GCD + " " + LCM / GCD;
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int LCM(int first, int second, int GCD) {
        return first * second / GCD;
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
