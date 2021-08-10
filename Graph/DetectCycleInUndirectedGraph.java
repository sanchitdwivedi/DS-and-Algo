import java.util.*;

public class DetectCycleInUndirectedGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	}
    public static void main(String[] args) {
        int V = 6; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,1,2); 
        	addEdge(adj,2,4); 
        	addEdge(adj,4,5); 
        	addEdge(adj,1,3);
        	addEdge(adj,2,3);
		
		if(DFS(adj,V)==true)
    	    System.out.println("Cycle found");
    	else
    	    System.out.println("No cycle found");
    }

    public static boolean DFS(ArrayList<ArrayList<Integer> > adj, int v){
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visited[i]){
                if(DFSRec(adj, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DFSRec(ArrayList<ArrayList<Integer> > adj, int i, boolean[] visited, int parent){
        visited[i] = true;
        for(int v: adj.get(i)){
            if(!visited[v]){
                return DFSRec(adj, v, visited, i);
            }
            else if(v != parent){
                return true;
            }
        }
        return false;
    }
}
