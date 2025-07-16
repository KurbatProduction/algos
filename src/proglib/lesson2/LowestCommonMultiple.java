package proglib.lesson2;

import java.util.*;

public class LowestCommonMultiple {

    public static void main(String[] args){
        int first = 12323;
        int second = 82345;

        long startNaive = System.currentTimeMillis();
        int resultNaive = getLCMNaive(first, second);
        long timeNaive = System.currentTimeMillis() - startNaive;
        System.out.println("Naive: LCM for " + first + " and " + second + " = " + resultNaive);
        System.out.println("time = " + timeNaive + " ms");

        long startAlgo1 = System.currentTimeMillis();
        int resultAlgo1 = getLCMAlgo(first, second);
        long timeAlgo1 = System.currentTimeMillis() - startAlgo1;
        System.out.println("Algo: GCD for " + first + " and " + second + " = " + resultAlgo1);
        System.out.println("time = " + timeAlgo1 + " ms");
    }

    public static int getLCMNaive(int first, int second) {
        List<Integer> firstList = getPrimeFactors(first);
        List<Integer> secondList = getPrimeFactors(second);

        Set<Integer> firstSet = new HashSet<>(firstList);
        Set<Integer> secondSet = new HashSet<>(secondList);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer primeFactor : firstSet) {
            if (secondSet.contains(primeFactor)) {
                map.put(
                        primeFactor,
                        Math.max(
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
        return result == 1 ? first * second : result;
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

    public static int getLCMAlgo(int first, int second) {
        int a = first, b = second;
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a * (first / a) * (second / a);
    }
}
