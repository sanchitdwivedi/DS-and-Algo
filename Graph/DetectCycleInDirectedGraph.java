import java.util.*;

public class DetectCycleInDirectedGraph {

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
        	addEdge(adj,2,1); 
        	addEdge(adj,2,3); 
        	addEdge(adj,3,4); 
        	addEdge(adj,4,5);
        	addEdge(adj,5,3);
		

        // boolean res = DFS(adj,V);
        boolean res = DetectCycle(adj, V);
		if(res)
    	    System.out.println("Cycle found");
    	else
    	    System.out.println("No cycle found");
    }

    public static boolean DFS(ArrayList<ArrayList<Integer> > adj, int v){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                return DFSRec(adj, i, visited, recStack);
            }
        }
        return false;
    }

    public static boolean DFSRec(ArrayList<ArrayList<Integer> > adj, int i, boolean[] visited, boolean[] recStack){
        visited[i] = true;
        recStack[i] = true;

        for(int v: adj.get(i)){
            if(!visited[v]){
                return DFSRec(adj, v, visited, recStack);
            }
            else if(recStack[v]){
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

    // Using Kahn's algorithm
    public static boolean DetectCycle(ArrayList<ArrayList<Integer> > adj, int v){
        int indegree[] = new int[v];
        for(int i=0; i<v; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i: adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
            count++;
        }

        return count!=v;
    }
}
