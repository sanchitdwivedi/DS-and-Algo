import java.util.*;

public class TopologicalSort {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
	}
    public static void main(String[] args) {
        int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0, 2); 
            addEdge(adj,0, 3); 
            addEdge(adj,1, 3); 
            addEdge(adj,1, 4); 
            addEdge(adj,2, 3);
		
		System.out.println("Following is a Topological Sort of"); 
        // topologicalSort(adj,V);
        DFSTopological(adj, V);
    }

    // Kahn's algorithm
    public static void topologicalSort(ArrayList<ArrayList<Integer> > adj, int v){
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

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i: adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
    }

    // DFS based algorithm
    public static void DFSTopological(ArrayList<ArrayList<Integer> > adj, int v){
        boolean visited[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<v; i++){
            if(!visited[i]){
                DFSRec(adj, i, visited, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void DFSRec(ArrayList<ArrayList<Integer> > adj, int i, boolean[] visited, Stack<Integer> s){
        visited[i] = true;
        for(int v: adj.get(i)){
            if(!visited[v]){
                DFSRec(adj, v, visited, s);
            }
        }
        s.push(i);
    }
}
