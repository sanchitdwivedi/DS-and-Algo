import java.util.HashMap;

public class LongestCommonSpanWithSameSumBinaryArray {
    public static void main(String[] args) {
        int arr1[] = {0, 1, 0, 0, 0, 0};
        int arr2[] = {1, 0, 1, 0, 0, 1};
        System.out.println(findLongestSubarray(arr1, arr2, arr1.length));
    }

    public static int findLongestSubarray(int arr1[], int arr2[], int n){
        // temp[] contains difference of both arrays
        int temp[] = new int[n];
        for(int i=0; i<n; i++){
            temp[i] = arr1[i] - arr2[i];
        }

        // Now find longest subarray with 0 sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum=0, length=0;
        for(int i=0; i<n; i++){
            preSum += temp[i];
            if(preSum==0){
                length = i+1;
            }
            if(!map.containsKey(preSum)){
                map.put(preSum, i);
            }
            else{
                length = Math.max(length, i-map.get(preSum));
            }
        }
        return length;
    }
}
