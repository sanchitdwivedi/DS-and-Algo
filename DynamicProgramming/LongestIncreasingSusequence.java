/**
 * LongestIncreasingSusequence
 */
public class LongestIncreasingSusequence {
    public static void main(String[] args) {
        int arr[] = {3, 10, 20, 4, 6, 7};
        // System.out.println(LIS(arr, arr.length));
        System.out.println(LISBinarySearch(arr, arr.length));
    }

    // DP, Time Complexity => O(n^2)
    public static int LIS(int[] arr, int n){
        int lis[] = new int[n];
        lis[0] = 1;
        for(int i=1; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int res = lis[0];
        for(int i=1; i<n; i++){
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    // Using Binary Search, Time Complexity => O(n*logn)
    public static int LISBinarySearch(int [] arr, int n){
        int tail[] = new int[n];
        int len = 1;
        tail[0] = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>tail[len-1]){
                tail[len] = arr[i];
                len++;
            }
            else{
                int ub = upperBound(tail, 0, len-1, arr[i]);
                tail[ub] = arr[i];
            }
        }
        return len;
    }

    public static int upperBound(int arr[], int start, int end, int x){
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>=x){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }
}