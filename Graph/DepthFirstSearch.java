import java.util.*;
/**
 * DepthFirstSearch
 * Time complexity => O(V+E)
 */
public class DepthFirstSearch {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 
    public static void main(String[] args) {
        int v = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(v); 
		
		for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,0,2); 
        	addEdge(adj,1,2);
        	addEdge(adj,3,4);
		
		System.out.println("Number of connected components: "+DFS(adj,v));
    }

    public static int DFS(ArrayList<ArrayList<Integer> > adj, int v){
        boolean visited[] = new boolean[v];
        int count = 0;
        for(int i=0; i<v; i++){
            if(!visited[i]){
                DFSRec(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void DFSRec(ArrayList<ArrayList<Integer> > adj, boolean visited[], int i){
        visited[i] = true;
        System.out.print(i + " ");
        for(int v: adj.get(i)){
            if(!visited[v]){
                DFSRec(adj, visited, v);
            }
        }
    }
}
