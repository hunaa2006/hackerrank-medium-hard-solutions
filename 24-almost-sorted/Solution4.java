import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        almostSorted(arr);
    }

    public static void almostSorted(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        if (Arrays.equals(arr, sortedArr)) {
            System.out.println("yes");
            return;
        }

        int n = arr.length;
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Try swapping
        swap(arr, left, right);
        if (Arrays.equals(arr, sortedArr)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1));
            return;
        }
        swap(arr, left, right); // Swap back

        // Try reversing
        if (left < right) {
            reverse(arr, left, right);
            if (Arrays.equals(arr, sortedArr)) {
                System.out.println("yes");
                System.out.println("reverse " + (left + 1) + " " + (right + 1));
                return;
            }
            reverse(arr, left, right); // Reverse back
        }

        System.out.println("no");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}