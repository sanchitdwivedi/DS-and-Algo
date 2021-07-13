import java.util.ArrayDeque;

public class MaxOfMinOfEveryWindowSize {
    public static void main(String[] args) {
        int arr[] = {10,20,30,50,10,70,30};

        int res[] = maxOfMin(arr, arr.length);

        for(int i: res){
            System.out.print(i + " ");
        }
    }

    public static int[] maxOfMin(int[] arr, int n) 
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = -1;
        right[n-1] = n;
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            int len = right[i] - left[i] - 1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }
        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }
}
