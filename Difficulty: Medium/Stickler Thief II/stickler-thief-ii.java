//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxValue(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0]; // Edge case: Only one house
        
        // Consider two cases and return the max
        return Math.max(robLinear(arr, 0, n - 2), robLinear(arr, 1, n - 1));
    }

    private int robLinear(int[] arr, int start, int end) {
        int prev2 = 0, prev1 = 0;
        
        for (int i = start; i <= end; i++) {
            int pick = arr[i] + prev2; // Take current house + amount from two steps before
            int skip = prev1; // Skip current house
            int curr = Math.max(pick, skip); // Choose the max option
            
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

