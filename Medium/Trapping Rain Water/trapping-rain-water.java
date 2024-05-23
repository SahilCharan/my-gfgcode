//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
          int lmax[] = filLeft(arr,n);
        int rmax[] = fillRight(arr,n);
        long sum =0;
        
        for(int i =0;i<n;i++)
        {
            int h = Math.min(lmax[i],rmax[i])-arr[i];
            sum+=h;
            
        }
        return sum;
        
    } 
    static int[] filLeft(int arr[], int n)
    {
        int max =0;
        int left[] = new int[n];
        for(int i =0;i<n;i++)
        {
            max = Math.max(arr[i], max);
            left[i] =max;
            
        }
        return left;
    }
    static int[] fillRight(int arr[], int n)
    {
        int max =0;
        int right[] = new int[n];
        for(int i = n-1;i>=0;i--)
        {
            max = Math.max(arr[i],max);
            right[i] = max;
        }
        return right;
    }
    
}


