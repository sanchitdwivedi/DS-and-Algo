import java.util.*;

public class Dijkastra {
    static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int w) 
	{ 
        Edge e = new Edge(u, v, w);
		adj.get(u).add(e);
        // Undirected graph -->
        Edge e2 = new Edge(v, u, w);
        adj.get(v).add(e2); 
	}
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Edge>()); 

        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 2, 3, 20);

        for(int x: djikstra(adj, v, 0)){
    	    System.out.print(x+" ");
    	} 
    }

    public static int[] djikstra(ArrayList<ArrayList<Edge>> adj, int v, int source){
        boolean[] fin = new boolean[v];
        KeyVertexPair[] kv = new KeyVertexPair[v];
        for(int i=0; i<v; i++){
            kv[i] = new KeyVertexPair(Integer.MAX_VALUE, i);
        }
        kv[source].key = 0;
        TreeSet<KeyVertexPair> pq = new TreeSet<>();
        for(int i=0; i<v; i++){
            pq.add(kv[i]);
        }
        while(!pq.isEmpty()){
            KeyVertexPair keyVertex = pq.pollFirst();
            int vertex = keyVertex.vertex;
            fin[vertex] = true;
            for(Edge e: adj.get(vertex)){
                if(!fin[e.v] && kv[e.v].key>kv[vertex].key+e.weight){
                    pq.remove(kv[e.v]);
                    kv[e.v].key = kv[vertex].key+e.weight;
                    pq.add(kv[e.v]);
                }
            }
        }
        int dist[] = new int[v];
        for(int i=0; i<v; i++){
            dist[i] = kv[i].key;
        }
        return dist;
    }
}
