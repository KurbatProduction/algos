package common;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 2, 3, 4, 5, 6}, 2));
    }

    public static int binarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];

            if (key > midVal)
                left = mid + 1;
            else if (key < midVal)
                right = mid - 1;
            else
                return mid;
        }

        return -(left + 1);
    }
}
