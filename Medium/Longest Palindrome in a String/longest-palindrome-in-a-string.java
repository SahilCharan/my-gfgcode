//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        String res="";
        int resLen = 0;
        int l,r;
        for (int i =0;i<S.length();i++)
        {
            //odd
            l = i;r =i;
            while(l>=0&&r< S.length() && S.charAt(l)== S.charAt(r))
            {
                if((r-l+1)>resLen)
                {
                    res = S.substring(l,r+1);
                    resLen = r-l+1;
                }
                l-=1;
                r+=1;
            }
            //even
            l=i;r=i+1;
            while(l>=0&&r< S.length() && S.charAt(l)== S.charAt(r))
            {
                if((r-l+1)>resLen)
                {
                    res = S.substring(l,r+1);
                    resLen = r-l+1;
                }
                l-=1;
                r+=1;
            }
            
            
        }
        
        return res;
        
    }
}