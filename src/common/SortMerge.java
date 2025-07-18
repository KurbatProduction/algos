package common;

import java.util.Arrays;

public class SortMerge {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("До сортировки: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("После сортировки: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        sort(arr, buffer, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] buffer, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(arr, buffer, left, mid);
        sort(arr, buffer, mid + 1, right);
        merge(arr, buffer, left, mid, right);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) buffer[k++] = arr[j++];
            else buffer[k++] = arr[i++];
        }

        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= right) buffer[k++] = arr[j++];

        k = 0;
        for (i = left; i <= right; i++) {
            arr[i] = buffer[k++];
        }
    }
}
