//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int price[], int n) {
        // initialize length array and memoization table
        int length[] = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        
        int[][] t = new int[n + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        
        return un_kn(price, length, n, n, t);
    }
    
    int un_kn(int price[], int length[], int Max_len, int n, int t[][]) {
        if (n == 0 || Max_len == 0) {
            return 0;
        }
        
        if (t[n][Max_len] != -1) {
            return t[n][Max_len];
        }
        
        if (length[n - 1] <= Max_len) {
            t[n][Max_len] = Math.max(
                price[n - 1] + un_kn(price, length, Max_len - length[n - 1], n, t),
                un_kn(price, length, Max_len, n - 1, t)
            );
        } else {
            t[n][Max_len] = un_kn(price, length, Max_len, n - 1, t);
        }
        
        return t[n][Max_len];
    }
}
