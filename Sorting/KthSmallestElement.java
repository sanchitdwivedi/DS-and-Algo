/**
 * KthSmallestElement using Lomuto's partition => This algorithm is known as QuickSelect algo
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = {10, 4, 5, 8, 11, 6, 26};
        int k=5;
        System.out.println(findKthSmallest(arr, arr.length, k));
    }
    public static int findKthSmallest(int arr[], int n, int k){
        int l=0, r=n-1;
        while(l<=r){
            int p = partition(arr, l, r);
            if(p == k-1){
                return arr[p];
            }
            else if(p>k-1){
                r=p-1;
            }
            else{
                l=p+1;
            }
        }
        return -1;
    }
    public static int partition(int arr[], int l, int r){
        int pivot = arr[r];
        int i=l-1;
        for(int j=l; j<r; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1; 
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}