package proglib.lesson1;

public class IsPrimeFactors {

    public static void main(String[] args) {
        long number = 12345678901234969L;
        long start = System.currentTimeMillis();
        boolean result = naive(number);
        long workTime = System.currentTimeMillis() - start;
        System.out.println(number + " is " + (result ? "simple" : "not simple"));
        System.out.println("WorkTime = " + workTime + " ms");
    }

    public static boolean naive(long n) {
        if (n == 2) return true;
        if (n <= 1 || n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
