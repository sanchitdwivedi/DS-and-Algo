import java.util.PriorityQueue;

public class PurchasingMaxItems {
    public static void main(String[] args) {
        int cost[] = {1, 12, 5, 111, 200};
        int sum = 10;

        System.out.println(maxItems(cost, cost.length, sum));
    }

    public static int maxItems(int cost[], int n, int sum){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(cost[i]);
        }
        int res = 0;
        while(!pq.isEmpty()){
            if(pq.peek() <= sum){
                res++;
                sum = sum-pq.remove();
            }
            else{
                break;
            }
        }
        return res;
    }
}
