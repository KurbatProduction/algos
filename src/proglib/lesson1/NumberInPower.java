package proglib.lesson1;

import java.math.BigInteger;

public class NumberInPower {

    public static void main(String[] args) {
        int number = 3;
        int power = 100;

        long naiveStart = System.currentTimeMillis();
        long naive = naive(number, power);
        long naiveTime = System.currentTimeMillis() - naiveStart;

        long algoStart = System.currentTimeMillis();
        long algo = algo(number, power);
        long algoTime = System.currentTimeMillis() - algoStart;

        System.out.println(
                "Naive: "
                        + number
                        + " in power "
                        + power
                        + " = "
                        + naive
                        + ". Time = "
                        + naiveTime
                        + " ms");
        System.out.println(
                "Algo: "
                        + number
                        + " in power "
                        + power
                        + " = "
                        + algo
                        + ". Time = "
                        + algoTime
                        + " ms");

        System.out.println(BigInteger.valueOf(number).pow(power));
    }

    private static long naive(int number, int power) {
        long result = number;
        for (int i = 2; i <= power; i++) {
            result *= number;
        }
        return result;
    }

    private static long algo(int number, int power) {
        long result = 1;
        long aInPowerOf2 = number;
        while (power > 0) {
            if ((power & 1) == 1) {
                result *= aInPowerOf2;
            }
            aInPowerOf2 *= aInPowerOf2;
            power >>= 1;
        }
        return result;
    }
}
