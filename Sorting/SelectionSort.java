public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {5, 2, 7, 14, 10, 4};
        selectionSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int arr[], int n){
        int min;
        for(int i=0; i<n-1; i++){
            min=i;
            for(int j=i+1; j<n; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
