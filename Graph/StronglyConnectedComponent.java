import java.util.*;

/**
 * StronglyConnectedComponent => Trajan's Algorithm -- O(V+E)
 */
public class StronglyConnectedComponent {
    static int time = 0;
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=6; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(3).add(4);
        adj.get(4).add(0);
        adj.get(1).add(3);
        adj.get(4).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(5);

        findSCC_Tarjan(adj);
    }

    public static void findSCC_Tarjan(List<List<Integer>> adj){
        int V = adj.size();
        int[] disc = new int[V];
        int[] low = new int[V];
        Arrays.fill(disc, -1);
        boolean[] inStack = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<V; i++){
            if(disc[i]==-1) dfs(adj, i, disc, low, inStack, s);
        }
    }

    public static void dfs(List<List<Integer>> adj, int u, int[] disc, int[] low, boolean[] inStack, Stack<Integer> s){
        disc[u] = low[u] = time;
        time++;
        s.push(u);
        inStack[u] = true;

        for(int v: adj.get(u)){
            if(disc[v]==-1){
                dfs(adj, v, disc, low, inStack, s);
                low[u] = Math.min(low[v], low[u]);
            }
            else if(inStack[v]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if(low[u]==disc[u]){
            System.out.print("SCC => ");
            while(s.peek()!=u){
                System.out.print(s.peek()+", ");
                inStack[s.pop()] = false;
            }
            System.out.println(s.peek());
            inStack[s.pop()] = false;
        }
    }
}