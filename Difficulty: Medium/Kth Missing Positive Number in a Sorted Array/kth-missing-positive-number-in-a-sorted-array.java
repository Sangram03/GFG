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
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        int missingCount = 0; // Count of missing numbers found
        int current = 1; // Current number to check
        int index = 0; // Pointer to traverse the array
        
        while (missingCount < k) {
            if (index < arr.length && arr[index] == current) {
                // If current number is in the array, move to the next element
                index++;
            } else {
                // If current number is missing
                missingCount++;
            }
            if (missingCount == k) {
                return current; // Found the kth missing number
            }
            current++;
        }
        return -1; // This will never be reached
    }
}
