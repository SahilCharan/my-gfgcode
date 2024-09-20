//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if(arr==null || arr.length ==0)
        return "-1";
        
        int n = arr.length;
        String s = arr[0];
        for(String str : arr ){
            while(str.indexOf(s)!=0){
                s= s.substring(0,s.length()-1);
                
                if(s.isEmpty())
                return "-1";
            }
        }
        return s;
    }
}