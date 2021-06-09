import java.util.HashMap;

public class DistinctElementsInWindow {
    public static void main(String[] args) {
        int arr[] = {10, 20, 10, 10, 30, 40};
        int k = 4;
        countDistinctElements(arr, arr.length, k);
    }

    public static void countDistinctElements(int arr[], int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        System.out.print(map.size() + " ");
        for(int i=k; i<n; i++){
            if(map.get(arr[i-k]) == 1){
                map.remove(arr[i-k]);
            }
            else{
                map.put(arr[i-k], map.get(arr[i-k])-1);
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
            System.out.print(map.size() + " ");
        }
    }
}
