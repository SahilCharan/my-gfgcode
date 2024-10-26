//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
       /* int left = 0;
        int right = n-1;
        int count =0;
        while(left<right){
            if(arr[left]<=k && arr[right]<=k){
                if(arr[left]>=arr[right])
                right--;
                else
                left++;
            }
            else if(arr[left]>k && arr[right]>k){
                left++;
                right--;
            }else
            if(arr[left]>k){
                swap(arr,left,right);
                count++;
                left++;
            }else if(arr[right]>k){
                swap(arr,left,right);
                count++;
                right--;
            }
        }
        return count;
    }
    public static void swap(int arr[], int left, int right){
        int temp= arr[left];
        arr[left]=arr[right];
        arr[right]= temp;
    }
    */
    //the abhove process will not work as swaps all the element which are less then 
    //k to the left which is a bull shit and code does not want it
    //think of some thing 
    
    //now let me think something as
    //what will happen if get all the elements which are less then k in one block, that is just counting the number of values which are less then k
    
    int numberslessthenk=0;
    for(int i=0;i<n;i++)
    {
        if(arr[i]<=k){
            numberslessthenk++;
        }
    }
    //now i will count the numbers which are greater then k, but pura array mein check krna bekufi hoga
    // to jese maan lete hai ki array hai[1,2,3,4,5] or k ka value 3 hai, to ab hmlog kya krenge, ki number less then k are 3
    //to hmko chaiye hoga ki minimum 3 index tk kitna number hai jo mera k se bada hai
    int numbersGreaterThenKInRangeOfCount=0;
    for(int i=0;i<numberslessthenk;i++){
        if(arr[i]>k){
            numbersGreaterThenKInRangeOfCount++;
        }
    }
    int minSwaps = numbersGreaterThenKInRangeOfCount;
    //ab hai mere pass ek window
    for(int outgoing=0,incoming=numberslessthenk;incoming<n;outgoing++,incoming++){
      //yadi mera bahar jane wala element k se bada hua to usme numbersGreaterThenKInRangeOfCount ka value decrease kr denge
      
        if(arr[outgoing]>k){
            numbersGreaterThenKInRangeOfCount--;
            
        }
        //yadi mera incoming element k se chota hai to numbersGreaterThenKInRangeOfCount ka value badhayege
        if(arr[incoming]>k){
            numbersGreaterThenKInRangeOfCount++;
        }
        minSwaps= Math.min(minSwaps,numbersGreaterThenKInRangeOfCount);
    }
    return minSwaps;
    
    
    
    }
    
    
}
