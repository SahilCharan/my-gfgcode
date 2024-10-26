//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        long t[][] = new long[n+1][sum+1];
        for(long row[]: t){
            Arrays.fill(row,-1);
        }
        return function(coins,t,sum,n);
    }
    public long function(int coins[],long t[][],int currsum, int n){
        //base case 1
        //if the currsum =0 then return 1 as it is one way to get the answeer
        
        if(currsum==0){
            return 1;
        }
        //base case 2
        // if the sum becomes negative or the number of coins required that is n is 0
        //then return 0
        
        if(n==0 &&currsum!=0)
        return 0;
        
        // checking if i have already solved this problem earlier then use the value
        //memozation
        if(t[n][currsum]!=-1)
        return t[n][currsum];
        
        //if all the case are solved then i will be looking into the case where i could take the coin or not
        //calling recursion
        //before calling recursion i will be checking if the value of that coin is less then or equal to the required value
        //if yes i can take the coin else i will not take the coin
        // if i choose to take the coin then i will be subtracting the number of coins required and also if i wish to use the coin in the future
        //otherwise will decrease the size of n, and not using the sum
        
        if(coins[n-1]<=currsum){
            t[n][currsum] = function(coins,t,currsum-coins[n-1],n)+function(coins,t,currsum,n-1);
        }
        else{
        t[n][currsum] = function(coins,t,currsum,n-1);
    }
    return t[n][currsum];
}
}