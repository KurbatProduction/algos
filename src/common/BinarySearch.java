package common;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {-40, -5, 0, 12, 12, 12, 12, 34, 34, 71}, 0));

        System.out.println(count(new int[] {-40, -5, 0, 12, 12, 12, 12, 34, 34, 71}, 12));

        System.out.println(
                binarySearchWithDoubling(new int[] {-40, -5, 0, 0, 0, 12, 12, 12, 12, 34, 34, 71}, 12));
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

            if (arr[mid] <= value) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public static int count(int[] arr, int value) {
        return upperBound(arr, value) - lowerBound(arr, value);
    }

    public static int binarySearchWithDoubling(int[] arr, int value) {
        int k = 0;
        while (arr[k] < value) {
            if (k == 0) k++;
            else k *= 2;
        }
        return binarySearch(arr, value, k / 2, k);
    }

    public static int binarySearch(int[] arr, int value, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < value) left = mid + 1;
            else right = mid;
        }

        return (left >= arr.length || arr[left] != value) ? -(left - 1) : left;
    }
}
