//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        HashMap<Integer,Integer>map=new HashMap<>();
        int c =0;
        int sum =0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int compli = 0-sum;
            if(map.containsKey(compli)){
                c+=map.get(compli);
            }
            map.put(compli,map.getOrDefault(compli,0)+1);
        }
        return c;
    }
}
