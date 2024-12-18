//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        // Edge case: If students are more than books
        if (k > n) {
            return -1;
        }

        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // Maximum single book pages
            high += pages;             // Sum of all pages
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, n, k, mid)) {
                result = mid;         // Found a possible solution
                high = mid - 1;       // Try for smaller maximum
            } else {
                low = mid + 1;        // Increase the maximum limit
            }
        }

        return result;
    }

    // Helper function to check feasibility of current maxPages
    private static boolean isFeasible(int[] arr, int n, int k, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                // Assign new student
                studentsRequired++;
                currentSum = pages;

                // If students required exceed available, return false
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentSum += pages;
            }
        }

        return true;
    }
}
