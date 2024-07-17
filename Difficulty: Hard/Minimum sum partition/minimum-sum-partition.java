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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    // using recursion
	    int sum =0;
	    for(int s : arr)
	    {
	        sum+= s;
	    }
	    int t[][] = new int[n+1][sum+1];
	    for(int r[]: t)
	    {
	        Arrays.fill(r,-1);
	    }
	    return recursion(arr,n-1,0,sum,t);
	    
	} 
	int recursion(int arr[], int n, int currsum, int totalsum, int t[][])
	{
	    if(n==0)
	    {
	        return Math.abs((totalsum-currsum)-currsum);
	    }
	    if(t[n][currsum]!=-1)
	    return t[n][currsum];
	    int include = recursion(arr, n-1,currsum+arr[n], totalsum,t);
	    int exclude = recursion(arr,n-1, currsum,totalsum,t);
	    
	    t[n][currsum] = Math.min(include, exclude);
	    return t[n][currsum];
	}
}
