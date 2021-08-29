import java.security.Key;
import java.util.*;
class KeyVertexPair implements Comparable<KeyVertexPair>{
    int key;
    int vertex;
    KeyVertexPair(){}
    KeyVertexPair(int k, int v){
        key = k;
        vertex = v;
    }
    @Override
    public int compareTo(KeyVertexPair p1) {
        return key-p1.key;
    }
}
public class Prims {
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
        // int graph[][] = new int[][] { { 0, 5, 8, 0}, 
    	// 					{ 5, 0, 10, 15 }, 
    	// 					{ 8, 10, 0, 20 }, 
    	// 					{ 0, 15, 20, 0 },};  

        // System.out.print(primMSTMatrix(graph, v));

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Edge>()); 

        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 2, 3, 20);

        System.out.println(primMSTList(adj, v));
    }

    // Time complexity => O(v^2)
    public static int primMSTMatrix(int graph[][], int v){
        int key[] = new int[v];
        boolean mSet[] = new boolean[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        int res = 0;
        for(int i=0; i<v; i++){
            int u = -1;
            for(int j=0; j<v; j++){
                if(!mSet[j] && (u==-1 || key[j]<key[u])){
                    u = j;
                }
            }
            mSet[u] = true;
            res += key[u];
            for(int j=0; j<v; j++){
                if(!mSet[j] && graph[u][j]!=0 && graph[u][j]<key[j]){
                    key[j] = graph[u][j];
                }
            }
        }
        return res;
    }

    // Time complexity => O(E*log(v))
    public static int primMSTList(ArrayList<ArrayList<Edge>> adj, int v){
        int res = 0;
        boolean mSet[] = new boolean[v];
        KeyVertexPair[] kv = new KeyVertexPair[v];
        for(int i=0; i<v; i++){
            kv[i] = new KeyVertexPair(Integer.MAX_VALUE, i);
        }
        kv[0].key = 0;
        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<KeyVertexPair> pq = new TreeSet<>();
        for(int i=0; i<v; i++){
            pq.add(kv[i]);
        }
        while(!pq.isEmpty()){
            KeyVertexPair keyVertex = pq.pollFirst(); // Extracts min. key
            int u = keyVertex.vertex;
            int k = keyVertex.key;
            res += k;
            mSet[u] = true;
            for(Edge e: adj.get(u)){
                int adjacentVertex = e.v;
                if(mSet[adjacentVertex]==false){
                    if(kv[adjacentVertex].key > e.weight){
                        pq.remove(kv[adjacentVertex]);
                        kv[adjacentVertex].key = e.weight;
                        pq.add(kv[adjacentVertex]);
                    }
                }
            }
        }
        return res;
    }
}
