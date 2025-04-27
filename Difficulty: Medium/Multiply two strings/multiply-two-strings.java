//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Step 1: Handle negative signs
        boolean negative = false;
        if (s1.startsWith("-")) {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.startsWith("-")) {
            negative = !negative;
            s2 = s2.substring(1);
        }

        // Step 2: Remove leading zeros
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");

        if (s1.length() == 0 || s2.length() == 0) {
            return "0";
        }

        // Step 3: Initialize result array
        int[] result = new int[s1.length() + s2.length()];

        // Step 4: Multiply digits manually
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        // Step 5: Build result string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        if (sb.length() == 0) {
            return "0";
        }

        // Step 6: Add negative sign if needed
        if (negative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }
}
