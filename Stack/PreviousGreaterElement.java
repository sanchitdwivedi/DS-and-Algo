import java.util.ArrayDeque;

/**
 * PreviousGreaterElement
 */
public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[]{15, 10, 18, 12, 4, 6, 2, 8};
        
        printPrevGreater(arr,arr.length);
    }

    public static void printPrevGreater(int[] arr, int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        System.out.print("-1 ");
        stack.push(arr[0]);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("-1 ");
            }
            else{
                System.out.print(stack.peek() + " ");
            }
            stack.push(arr[i]);
        }
    }
}