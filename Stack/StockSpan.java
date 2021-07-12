import java.util.ArrayDeque;

/**
 * StockSpan
 */
public class StockSpan {
    public static void main(String[] args) {
        int[] arr=new int[]{18,12,13,14,11,16};

        printSpan(arr,arr.length);
    }

    public static void printSpan(int arr[], int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        System.out.print("1 ");
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1: i-stack.peek();
            System.out.print(span+" ");
            stack.push(i);
        }
    }
}