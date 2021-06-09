import java.util.HashMap;

public class LongestSubarraywithEqual0s1s {
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(findLongestSubarray(arr, arr.length));
    }

    public static int findLongestSubarray(int arr[], int n){
        //replace 0s with -1
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                arr[i] = -1;
            }
        }

        // Now find longest subarray with 0 sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum=0, length=0;
        for(int i=0; i<n; i++){
            preSum += arr[i];
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
