package common;

import java.util.Arrays;

public class SortQuick {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("До сортировки: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("После сортировки: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start > end) return;

        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr[left] > pivot && arr[right] < pivot) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] <= pivot) left++;
            if (arr[right] >= pivot) right--;

        }
        swap(arr, start, right);
        sort(arr, start, right - 1);
        sort(arr, right + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
