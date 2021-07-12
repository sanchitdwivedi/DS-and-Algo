import java.util.ArrayDeque;

public class LargestRectangleWith1s {
    public static void main(String[] args) {
        int R = 4; 
        int C = 4; 
  
        int A[][] = { 
            { 0, 1, 1, 0 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 0, 0 }, 
        }; 
        System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
    }

    public static int maxRectangle(int r, int c, int a[][]){
        int res = largestHist(a[0], c);
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                if(a[i][j]==1){
                    a[i][j] += a[i-1][j];
                }
                res = Math.max(res, largestHist(a[i], c));
            }
        }
        return res;
    }

    public static int largestHist(int arr[], int n){
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
