package proglib.lesson1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class GetFibonacci {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000;
        Thread naive =
                new Thread(
                        () -> {
                            long start = System.currentTimeMillis();
                            System.out.println(
                                    "Naive: "
                                            + naiveFibonacci(number)
                                            + " "
                                            + (System.currentTimeMillis() - start)
                                            + " ms");
                        });
        Thread binet =
                new Thread(
                        () -> {
                            long start = System.currentTimeMillis();
                            System.out.println(
                                    "Binet: "
                                            + binetFibonacci(number + 1)
                                            + " "
                                            + (System.currentTimeMillis() - start)
                                            + " ms");
                        });

        naive.start();
        binet.start();

        naive.join();
        binet.join();
    }

    public static BigInteger naiveFibonacci(int n) {
        if (n < 0) return BigInteger.valueOf(-1);
        if (n < 2) return BigInteger.ONE;

        BigInteger prev = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = prev;
            prev = current;
            current = temp.add(prev);
        }

        return current;
    }

    public static BigDecimal binetFibonacci(int n) {
        MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
        BigDecimal fiveSqrt = BigDecimal.valueOf(5).sqrt(mc);
        BigDecimal first = BigDecimal.ONE.add(fiveSqrt).pow(n);
        BigDecimal second = BigDecimal.ONE.subtract(fiveSqrt).pow(n);
        BigDecimal third = fiveSqrt.multiply(BigDecimal.TWO.pow(n));
        return first.subtract(second).divide(third, mc);
    }
}
