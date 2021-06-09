import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {8, 3, 1, 5, -6, 6, 2, 2};
        int sum = 4;
        System.out.println(findLongestSubarray(arr, arr.length, sum));
    }

    public static int findLongestSubarray(int arr[], int n, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum=0, length=0;
        for(int i=0; i<n; i++){
            preSum += arr[i];
            if(preSum == sum){
                length = i+1;
            }
            if(!map.containsKey(preSum)){
                map.put(preSum, i);
            }
            if(map.containsKey(preSum-sum)){
                length = Math.max(length, i-map.get(preSum-sum));
            }
        }
        return length;
    }
}
