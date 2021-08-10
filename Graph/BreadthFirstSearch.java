import java.util.*;

/**
 * BreadthFirstSearch
 * Time complexity => O(V+E)
 */
public class BreadthFirstSearch {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	}
    public static void main(String[] args) {
        int v = 7; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(v); 
		
		for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,0,2); 
        	addEdge(adj,2,3); 
        	addEdge(adj,1,3); 
        	addEdge(adj,4,5);
        	addEdge(adj,5,6);
        	addEdge(adj,4,6);
		
		System.out.print("Number of components: "+BFSDisconnected(adj,v));
    }

    public static int BFSDisconnected(ArrayList<ArrayList<Integer> > adj, int v){
        boolean visited[] = new boolean[v+1];
        int count = 0; // to count number of components
        for(int i=0; i<v; i++){
            if(!visited[i]){
                count++;
                BFS(adj, i, visited);
            }
        }
        return count;
    }

    public static void BFS(ArrayList<ArrayList<Integer> > adj, int i, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int u = q.remove();
            System.out.print(u + " ");
            for(int v: adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}