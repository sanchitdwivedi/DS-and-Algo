import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {8, 3, 4, 2, 5};
        int sum=6;
        System.out.println(isPairExist(arr, arr.length, sum));
    }

    public static boolean isPairExist(int arr[], int n, int sum){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(set.contains(sum-arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
