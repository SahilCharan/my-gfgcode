//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long t[][] =  new long[N+1][sum+1];
        for(long row[] : t)
        {
            Arrays.fill(row,-1);
        }
        return rec (coins,N,sum,t);
    }
    long rec(int coins[], int n,int sum, long t[][])
    {
     if(sum ==0)
     return 1;
     if(n==0 && sum!= 0)
     return 0;
     
     if(t[n][sum]!=-1)
     return t[n][sum];
     
     if(coins[n-1]<=sum)
     {
         t[n][sum] = rec(coins, n, sum-coins[n-1],t)+rec(coins,n-1,sum,t);
     }
     else
     t[n][sum] = rec(coins,n-1,sum,t);
     
     return t[n][sum];
    }
}