//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends




class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Map to group anagrams
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        // Iterate over each string in the input array
        for (String str : arr) {
            // Sort the characters of the string to create a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Add the string to the group corresponding to the sorted key
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        // Prepare the result, maintaining the order of first appearance
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<String> group : map.values()) {
            result.add(group);
        }

        return result;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends