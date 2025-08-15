package common;

public class IBS {

    public static void main(String[] args) {
        System.out.println(
                maxFrom2Arrays(
                        new int[] {3, 44, 6, 14, 23, 23, 254, 999, 29, 30, 33, 36, 40},
                        new int[] {2, 36, 6, 76, 15, 21, 264, 333, 39, 30, 33, 36, 40}));
    }

    private static int maxFrom2Arrays(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;

        int i = 0;
        while (i < Math.min(arr1.length, arr2.length)) {
            int tempMax = Math.max(arr1[i], arr2[i]);
            if (tempMax > max) max = tempMax;
            i++;
        }

        if (i < arr1.length) {
            while (i < arr1.length) {
                if (arr1[i] > max) max = arr1[i];
                i++;
            }
        }

        if (i < arr2.length) {
            while (i < arr2.length) {
                if (arr2[i] > max) max = arr2[i];
                i++;
            }
        }

        return max;
    }
}
