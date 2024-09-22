//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
      int n = str.length();
        int[] lps = new int[n]; // lps array to hold the longest prefix suffix lengths
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;    // start from the second character

        // LPS of the first character is always 0
        lps[0] = 0; 

        // loop through the string to fill the lps array
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;  // increment the length of the matching prefix and suffix
                lps[i] = len;
                i++;
            } else {  // mismatch after len matches
                if (len != 0) {
                    // fall back to the previous longest prefix suffix value
                    len = lps[len - 1];
                } else {
                    // no match, set lps[i] to 0 and move on
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // the value of lps[n-1] will contain the length of the longest proper
        // prefix which is also a suffix for the entire string
        return lps[n - 1];  
        
    }
}