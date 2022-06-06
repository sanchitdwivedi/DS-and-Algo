import java.util.*;
/**
 * EulerCircuit => start==end && every edge of even degree
 * EulerPath => start!=end && only 2 vertices of odd degree
 */
public class EulerCircuit {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=3; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        int res = isEulerCircuit(adj, adj.size());

        if(res==0) System.out.println("Euler CIRCUIT exists");
        else if(res==2) System.out.println("Euler PATH exists"); 
        else System.out.println("Euler circuit does not exist");
    }

    public static int isEulerCircuit(List<List<Integer>> adj, int V){
        int u = -1;
        for(int i=0; i<V; i++){
            if(adj.get(i).size()>0){
                u = i;
                break;
            }
        }
        
        if(u==-1) return -1;
        
        if(!CC(adj, V, u)) return -1;
        
        int[] degree = new int[V];
        for(int i=0; i<V; i++){
            degree[i] += adj.get(i).size();
            for(int v: adj.get(i)) degree[v]++;
        }
        
        int odd = 0;
        for(int i=0; i<V; i++){
            if(degree[i]%2==1) odd++;
        }
        
        return odd;
    }

    public static boolean CC(List<List<Integer>> adj, int V, int u){
        boolean[] visited = new boolean[V];
        dfs(adj, u, visited);
        
        for(int i=0; i<V; i++){
            if(adj.get(i).size()>0 && !visited[i]) return false;
        }
        
        return true;
    }

    public static void dfs(List<List<Integer>> adj, int u, boolean[] visited){
        visited[u] = true;
        for(int v: adj.get(u)){
            if(!visited[v]) dfs(adj, v, visited);
        }
    }
}