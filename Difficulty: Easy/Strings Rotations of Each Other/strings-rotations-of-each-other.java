//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Check if lengths are equal
        if (s1.length() != s2.length()) {
            return false;
        }
        // Concatenate s1 with itself
        String combined = s1 + s1;
        // Use KMP for substring search
        return kmpSearch(combined, s2);
    }

    // KMP substring search function
    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0; // i for text, j for pattern
        
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return true; // Found a match
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // Use LPS to skip unnecessary comparisons
                } else {
                    i++;
                }
            }
        }
        return false; // No match found
    }

    // Function to compute the LPS (Longest Prefix Suffix) array for KMP
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(areRotations("abcd", "cdab")); // Output: true
        System.out.println(areRotations("aab", "aba"));   // Output: true
        System.out.println(areRotations("abcd", "acbd")); // Output: false
    }
}
