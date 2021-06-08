import java.util.HashSet;

/**
 * SubarrayWithZeroSum
 */
public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        int arr[] = {3, 4, 3, -1, 1};
        System.out.println(zeroSumSubarrayPresent(arr, arr.length));
    }

    public static boolean zeroSumSubarrayPresent(int arr[], int n){
        HashSet<Integer> set = new HashSet<>();
        int preSum=0;
        for(int i=0; i<n; i++){
            preSum += arr[i];
            if(set.contains(preSum)){
                return true;
            }
            if(preSum == 0){
                return true;
            }
            set.add(preSum);
        }
        return false;
    }
}