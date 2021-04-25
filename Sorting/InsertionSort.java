public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5, 2, 7, 14, 10, 4};
        insertionSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort(int arr[], int n){
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
