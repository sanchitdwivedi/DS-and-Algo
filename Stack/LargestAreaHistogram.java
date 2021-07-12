import java.util.ArrayDeque;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr=new int[]{6,2,5,4,1,5,6};
        
        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));
    }

    public static int getMaxArea(int[] arr, int n){
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = -1;
        right[n-1] = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = arr[i]*(i);
            }
            else{
                left[i] = arr[i]*(i-stack.peek()-1);
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
                right[i] = arr[i]*(n-i-1);
            }
            else{
                right[i] = arr[i]*(stack.peek()-i-1);
            }
            stack.push(i);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            int area;
            if(i==0){
                area = arr[i] + right[i];
            }
            else if(i==n-1){
                area = arr[i] + left[i];
            }
            else{
                area = arr[i] + left[i] + right[i];
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
