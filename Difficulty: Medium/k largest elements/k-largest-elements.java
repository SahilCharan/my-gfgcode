//{ Driver Code Starts
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
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
    int[] ans = new int[k];
    
    for (int a : arr) {
        pq.add(a);
        if (pq.size() > k) {
            pq.poll(); // Remove smallest element if size exceeds k
        }
    }
    
    for (int i = k - 1; i >= 0; i--) {
        ans[i] = pq.poll(); // Collect largest elements in descending order
    }
    
    return ans;
    }
}