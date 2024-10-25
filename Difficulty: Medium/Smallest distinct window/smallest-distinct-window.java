//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java
class Solution{
public int findSubString(String str) {
    Set<Character> uniqueChars = new HashSet<>();
    for (char c : str.toCharArray()) {
        uniqueChars.add(c); // Collect unique characters
    }
    int requiredUniqueCount = uniqueChars.size();

    Map<Character, Integer> windowCounts = new HashMap<>();
    int left = 0, minLength = Integer.MAX_VALUE;
    int uniqueInWindow = 0;

    for (int right = 0; right < str.length(); right++) {
        char rightChar = str.charAt(right);
        windowCounts.put(rightChar, windowCounts.getOrDefault(rightChar, 0) + 1);
        
        if (windowCounts.get(rightChar) == 1) {
            uniqueInWindow++;
        }

        while (uniqueInWindow == requiredUniqueCount) {
            minLength = Math.min(minLength, right - left + 1);
            char leftChar = str.charAt(left);
            windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

            if (windowCounts.get(leftChar) == 0) {
                uniqueInWindow--;
            }
            left++;
        }
    }

    return minLength;
}
}
