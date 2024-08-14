//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
       int low = 0;
        int high = n-1;
        int count = 0;
        
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == x) {
                int i = mid;
                int j = mid;
                while (i >= 0) {
                    if (arr[i] < x) break;
                    count++;
                    i--;
                }
                while (j < n) {
                    if (arr[j] > x) break;
                    count++;
                    j++;
                }
                break;
            }
            else if (arr[mid] < x) low = mid+1;
            else high = mid-1;
        }
        if (count > 0) return count-1;
        return count;
    }
}