//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here'
    int t[] = new int[n+1];
     Arrays.fill(t, -1);
     int MOD = 1000000007;
     
     return dpway(n,t,MOD);
        
        
    }
    int dpway(int n, int t[], int MOD)
    {
        if(n<=0)
        return 0;
        if(n==1)
        return 1;
        if(n==2)
        return 2;
        
        if(t[n]!= -1)
        return t[n];
        
        return t[n] = (dpway(n-1,t,MOD)+dpway(n-2,t,MOD))%MOD;
    }
}