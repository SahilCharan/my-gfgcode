//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean vis[] = new boolean[n];
        // multiple components
        for(int i =0;i<n;i++){
            if(!vis[i]){
                boolean ans = dfs(adj,vis,i,-1);
                if(ans) return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,boolean vis[], int curr,int parent){
        
        vis[curr] = true;
        
        for(int i: adj.get(curr)){
            // if visited but it ain't parent node 
            if(vis[i] && i!= parent){
                return true;
            }
            // if node is not visited
            if(!vis[i]){
                if(dfs(adj,vis,i,curr)) return true;
            }
        }
        return false;
    }
}