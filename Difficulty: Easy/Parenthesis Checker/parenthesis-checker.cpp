//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
public:
    bool isBalanced(string& s) {
        stack<char> st;
        unordered_map<char, char> bracketPairs = {
            {')', '('},
            {'}', '{'},
            {']', '['}
        };

        for (char ch : s) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            // If it's a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Check if stack is empty or top element doesn't match
                if (st.empty() || st.top() != bracketPairs[ch]) {
                    return false;
                }
                st.pop(); // Pop the matching opening bracket
            }
        }

        // If stack is empty, all brackets were balanced
        return st.empty();
    }
};




//{ Driver Code Starts.

int main() {
    int t;
    string a;
    cin >> t;
    while (t--) {
        cin >> a;
        Solution obj;
        if (obj.isBalanced(a))
            cout << "true" << endl;
        else
            cout << "false" << endl;

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends