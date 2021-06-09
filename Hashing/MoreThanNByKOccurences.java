import java.util.*;

public class MoreThanNByKOccurences {
    public static void main(String[] args) {
        int arr[] = {30, 10, 20, 20, 20, 10, 40, 30, 30};
        int k = 4;
        printNByK(arr, arr.length, k);
        System.out.println();
        printNByKAlternative(arr, arr.length, k);
    }
    // O(n) => time complexity
    // O(n) => Space complexity
    public static void printNByK(int arr[], int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() > n/k){
                System.out.print(e.getKey() + " ");
            }
        }
    }

    // O(nk) ==> efficient if n is very large and k is small 
    // 1 assumption => if res_count is the number of elements in result then res_count<=k-1
    // O(k-1) ==> Space complexity
    // Similar to Moore's voting algo
    public static void printNByKAlternative(int arr[], int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        // Get candidates
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else if(map.size() < k-1){
                map.put(arr[i], 1);
            }
            else{
                for(Map.Entry<Integer, Integer> e: map.entrySet()){
                    if(e.getValue() == 1){
                        map.remove(e.getKey());
                    }
                    else{
                        map.put(e.getKey(), e.getValue()-1);
                    }
                }
            }
        }
        // Check if candidates are eligible
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            int count=0;
            for(int i=0; i<n; i++){
                if(arr[i] == e.getKey()){
                    count++;
                }
            }
            if(count>n/k){
                System.out.print(e.getKey() + " ");
            }
        }
    }
}
