package proglib.lesson2;

import java.util.*;

public class GreatestCommonDivider {

    public static void main(String[] args) {
        int first = 18;
        int second = 24;

        long startNaive = System.currentTimeMillis();
        int resultNaive = getGCDNaive(first, second);
        long timeNaive = System.currentTimeMillis() - startNaive;
        System.out.println("Naive: GCD for " + first + " and " + second + " = " + resultNaive);
        System.out.println("time = " + timeNaive + " ms");

        long startAlgo1 = System.currentTimeMillis();
        int resultAlgo1 = getGCDAlgo1(first, second);
        long timeAlgo1 = System.currentTimeMillis() - startAlgo1;
        System.out.println("Algo1: GCD for " + first + " and " + second + " = " + resultAlgo1);
        System.out.println("time = " + timeAlgo1 + " ms");

        long startAlgo2 = System.currentTimeMillis();
        int resultAlgo2 = getGCDAlgo2(first, second);
        long timeAlgo2 = System.currentTimeMillis() - startAlgo2;
        System.out.println("Algo2: GCD for " + first + " and " + second + " = " + resultAlgo2);
        System.out.println("time = " + timeAlgo2 + " ms");

        long startEuclidean = System.currentTimeMillis();
        int resultEuclidean = getGCDEuclidean(first, second);
        long timeEuclidean = System.currentTimeMillis() - startEuclidean;
        System.out.println("Euclidean: GCD for " + first + " and " + second + " = " + resultEuclidean);
        System.out.println("time = " + timeEuclidean + " ms");
    }

    // неплохо, но слишком много памяти
    public static int getGCDNaive(int first, int second) {
        List<Integer> firstList = getPrimeFactors(first);
        List<Integer> secondList = getPrimeFactors(second);

        Set<Integer> firstSet = new HashSet<>(firstList);
        Set<Integer> secondSet = new HashSet<>(secondList);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer primeFactor : firstSet) {
            if (secondSet.contains(primeFactor)) {
                map.put(
                        primeFactor,
                        Math.min(
                                (int) firstList.stream().filter(a -> a.equals(primeFactor)).count(),
                                (int)
                                        secondList.stream()
                                                .filter(a -> a.equals(primeFactor))
                                                .count()));
            }
        }
        int result = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result *= (int) Math.pow(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        while (n % 2 == 0) {
            list.add(2);
            n /= 2;
        }
        for (int i = 3; i <= n; i += 2) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }
        return list;
    }

    public static int getGCDAlgo1(int first, int second) {
        if (first % second == 0) return second;
        if (second % first == 0) return first;

        int result = 1;

        while (first % 2 == 0 && second % 2 == 0) {
            result *= 2;
            first /= 2;
            second /= 2;
        }
        for (int i = 3; i <= first && i <= second; i += 2) {
            while (first % i == 0 && second % i == 0) {
                result *= i;
                first /= i;
                second /= i;
            }
        }
        return result;
    }

    public static int getGCDAlgo2(int a, int b) {
        int result = 1;

        for (int i = 2; i <= a && i <= b; ) {
            if (a % i == 0 && b % i == 0) {
                result *= i;
                a /= i;
                b /= i;
            } else {
                i ++;
            }
        }
        return result;
    }

    public static int getGCDEuclidean(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
