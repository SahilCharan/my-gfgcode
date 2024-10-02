//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        Map<Integer,List<Character>>map = new HashMap<>();
        map.put(2,Arrays.asList('a','b','c'));
        map.put(3,Arrays.asList('d','e','f'));
        map.put(4,Arrays.asList('g','h','i'));
        map.put(5,Arrays.asList('j','k','l'));
        map.put(6,Arrays.asList('m','n','o'));
        map.put(7,Arrays.asList('p','q','r','s'));
        map.put(8,Arrays.asList('t','u','v'));
        map.put(9,Arrays.asList('w','x','y','z'));
         
        ArrayList<String> result = new ArrayList<>();
        getans(a,0,N,result,map,"");
        return result;
    }
    public static void getans(int a[],int index,int N, ArrayList<String> result,Map<Integer,List<Character>>map,String curr){
        if(index ==N){
            if(!curr.isEmpty())
            result.add(curr);
            return;
        }
        if(a[index]==1){
            getans(a,index+1,N,result,map,curr);
        }
        else if(a[index]==0){
            getans(a,index+1,N,result,map,curr);
        }
        else{
            int num = a[index];
            List<Character>values = map.get(num);
            for(char val : values){
                getans(a,index+1,N,result,map,curr+val);
            }
        }
    }
}


