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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls array
        Arrays.sort(stalls);
        
        // Step 2: Define binary search range
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;
        
        // Step 3: Binary search to find the maximum minimum distance
        while (low <= high) {
            int mid = (low + high) / 2; // Candidate distance
            
            if (canPlaceCows(stalls, k, mid)) {
                result = mid;  // Update result as this distance works
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the search space
            }
        }
        return result;
    }
    
    // Helper method to check if cows can be placed with at least 'minDist' distance
    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int cowsPlaced = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                cowsPlaced++; // Place another cow
                lastPosition = stalls[i]; // Update the last position
            }
            if (cowsPlaced >= k) {
                return true; // Successfully placed all cows
            }
        }
        return false; // Could not place all cows with the given distance
    }
}
