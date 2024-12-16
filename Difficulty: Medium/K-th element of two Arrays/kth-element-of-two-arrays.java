//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // Ensure 'a' is the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }
        
        int n1 = a.length;
        int n2 = b.length;
        int low = Math.max(0, k - n2); // Ensure k is valid for 'b'
        int high = Math.min(k, n1);   // Ensure k is valid for 'a'
        
        while (low <= high) {
            int midA = (low + high) / 2;
            int midB = k - midA;
            
            int leftA = (midA == 0) ? Integer.MIN_VALUE : a[midA - 1];
            int leftB = (midB == 0) ? Integer.MIN_VALUE : b[midB - 1];
            int rightA = (midA == n1) ? Integer.MAX_VALUE : a[midA];
            int rightB = (midB == n2) ? Integer.MAX_VALUE : b[midB];
            
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = midA - 1; // Move left in 'a'
            } else {
                low = midA + 1; // Move right in 'a'
            }
        }
        
        return -1; // Should not reach here if inputs are valid
    }
}
