//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    static int minRemoval(int intervals[][]) {
        // Step 1: Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Initialize variables
        int removed = 0; // Count of intervals to remove
        int prevEnd = Integer.MIN_VALUE; // Tracks the end time of the last non-overlapping interval

        // Step 3: Iterate through intervals
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // Non-overlapping case: update prevEnd
                prevEnd = interval[1];
            } else {
                // Overlapping case: increment removal counter
                removed++;
            }
        }

        // Step 4: Return the total number of removals
        return removed;
    }
}

