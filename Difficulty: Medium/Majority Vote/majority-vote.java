//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        
        
        int c1 =0, c2 =0, num1 =0, num2 =0;
        int n = nums.size();
        for(int i =0;i<n;i++)
        {
            if(c1==0 && nums.get(i)!=num2){
                c1 =1;
                num1 = nums.get(i);
                
            } else if(c2==0 &&nums.get(i)!= num1){
                c2=1;
                num2 = nums.get(i);
            } else if(nums.get(i)==num1){
                c1++;
            } else if(nums.get(i)==num2)
            {
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        List<Integer> ans =  new ArrayList<>();
        c1=0;
        c2 =0;
        for(int i =0;i<n;i++){
            if(num1 == nums.get(i)){
                c1++;
            }else if(num2 == nums.get(i)){
                c2++;
            }
        }
        
        if(c1>n/3)
        ans.add(num1);
        if(c2>n/3)
        ans.add(num2);
        
        if(ans.isEmpty())
        ans.add(-1);
        
        
        return ans;
    }
}
