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
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            sc.nextLine();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0; 
        int n = intervals.length;

        // Add all intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read the number of intervals
            if (!sc.hasNextInt()) {
                System.out.println("No input provided");
                return;
            }
            int n = sc.nextInt();

            // Read the intervals
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            // Read the new interval
            int[] newInterval = new int[2];
            newInterval[0] = sc.nextInt();
            newInterval[1] = sc.nextInt();

            // Process the intervals
            ArrayList<int[]> result = insertInterval(intervals, newInterval);

            // Print the result
            for (int[] interval : result) {
                System.out.println(interval[0] + " " + interval[1]);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input or input format");
        } finally {
            sc.close(); // Ensure the scanner is closed
        }
    }
}

