package proglib.lesson2;

public class EratosthenesSieve {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(getPrimeFactorList(50));
    }

    public static String getPrimeFactorList(int n) {
        boolean[] sieve = new boolean[n + 1];
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (sieve[i]) {
                for (int j = 2; j * i <= n; j++) {
                    sieve[j * i] = false;
                }
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();
    }
}
