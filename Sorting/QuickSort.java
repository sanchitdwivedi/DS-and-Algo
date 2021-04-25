import java.io.*;

/**
 * QuickSort
 */
public class QuickSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr, 0, n-1);
        for(int a: arr){
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int arr[], int l, int h){
        if(l<h){
            int p = partition(arr, l, h);
            quickSort(arr, l, p);
            quickSort(arr, p+1, h);
        }
    }
    // Hoare's partition
    public static int partition(int arr[], int l, int h){
        int i=l-1, j=h+1, pivot = arr[l];
        while(true){
            do{
                i++;
            }while(arr[i] < pivot);

            do{
                j--;
            }while(arr[j] > pivot);

            if(i>=j){
                return j;
            }
            swap(arr, i, j);
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}