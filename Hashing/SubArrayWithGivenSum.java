import java.util.HashSet;

/**
 * SubArrayWithGivenSum
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {5, 3, 2, -1};
        int sum = 4;
        System.out.println(sumPresent(arr, arr.length, sum));
    }

    public static boolean sumPresent(int arr[], int n, int sum){
        HashSet<Integer> set = new HashSet<>();
        int preSum=0;
        for(int i=0; i<n; i++){
            preSum += arr[i];
            if(preSum==sum){
                return true;
            }
            if(set.contains(preSum-sum)){
                return true;
            }
            set.add(preSum);
        }
        return false;
    }
}