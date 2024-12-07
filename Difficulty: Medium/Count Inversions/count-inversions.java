//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array
    static int inversionCount(int arr[]) {
        // Temporary array to help with merge sort
        int[] tempArr = new int[arr.length];
        return mergeSortAndCount(arr, tempArr, 0, arr.length - 1);
    }

    // Function to implement merge sort and count inversions
    static int mergeSortAndCount(int[] arr, int[] tempArr, int left, int right) {
        int invCount = 0;
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Count inversions in the left subarray
            invCount += mergeSortAndCount(arr, tempArr, left, mid);

            // Count inversions in the right subarray
            invCount += mergeSortAndCount(arr, tempArr, mid + 1, right);

            // Count cross inversions and merge the two halves
            invCount += mergeAndCount(arr, tempArr, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two sorted subarrays and count inversions
    static int mergeAndCount(int[] arr, int[] tempArr, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index to store sorted elements in temp array
        int invCount = 0;

        // Traverse both subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                // There are (mid - i + 1) inversions because all remaining elements
                // in the left subarray are greater than arr[j]
                tempArr[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of the left subarray
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        // Copy remaining elements of the right subarray
        while (j <= right) {
            tempArr[k++] = arr[j++];
        }

        // Copy sorted subarray back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = tempArr[i];
        }

        return invCount;
    }
}
