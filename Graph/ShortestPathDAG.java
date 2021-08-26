import java.util.*;
/**
 * ShortestPathDAG
 */
class Edge{
    int u;
    int v;
    int weight;
    Edge(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}
public class ShortestPathDAG {

    static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int w) 
	{ 
        Edge e = new Edge(u, v, w);
		adj.get(u).add(e);
	}
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Edge>()); 

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 5, 3, 1);

        int s = 0;

        shortestPath(adj, v, s);
    }

    public static void shortestPath(ArrayList<ArrayList<Edge>> adj, int v, int s){
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<v; i++){
            if(!visited[i]){
                topologicalSort(adj, i, visited, stack);
            }
        }

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while(!stack.isEmpty()){
            int u = stack.pop();
            if(dist[u]!=Integer.MAX_VALUE){
                for(Edge e: adj.get(u)){
                    if(dist[e.v]>dist[u]+e.weight){
                        dist[e.v] = dist[u]+e.weight;
                    }
                }
            }
        }

        for (int i = 0; i < v; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Edge>> adj, int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        for(Edge e: adj.get(v)){
            if(!visited[e.v]){
                topologicalSort(adj, e.v, visited, stack);
            }
        }
        stack.add(v);
    }
}