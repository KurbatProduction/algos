package common;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {-40, -5, 0, 12, 12, 12, 12, 34, 34, 71}, 2));

        System.out.println(count(new int[] {-40, -5, 0, 12, 12, 12, 12, 34, 34, 71}, 71));
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr[mid];

            if (midVal < value) left = mid + 1;
            else if (midVal > value) right = mid - 1;
            else return mid;
        }

        return -(left + 1);
    }

    public static int lowerBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < value) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public static int upperBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > value) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public static int count(int[] arr, int value) {
        return upperBound(arr, value) - lowerBound(arr, value);
    }
}
