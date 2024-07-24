//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int t[][] = new int[M+1][V+1];
	    for(int row[] : t)
	    {
	        Arrays.fill(row,-1);
	    }
	    int res = rec(coins ,V, M, t);
	    return res == Integer.MAX_VALUE-1 ? -1 : res;
	} 
	int rec(int coins[], int v, int m, int[][] t)
	{
	    if(m==0)
	    return Integer.MAX_VALUE-1;
	   
	    if(v==0)
	    return 0;
	    
	    
	    if(t[m][v]!=-1)
	    return t[m][v];
	    
	    if(coins[m-1]<=v)
	    {
	        t[m][v] = Math.min(1+ rec(coins, v-coins[m-1],m,t), rec(coins,v,m-1,t));
	    }
	    else
	    t[m][v] = rec(coins,v,m-1,t);
	    
	    return t[m][v];
	    
	}
}