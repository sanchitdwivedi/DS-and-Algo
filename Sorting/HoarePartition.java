public class HoarePartition {
    public static void main(String[] args) {
        int arr[] = {7, 10, 8, 9, 1, 5};
        int n = arr.length;
        System.out.println(partition(arr, 0, n-1));
    }

    public static int partition(int arr[], int l, int h){
        int pivot = arr[l];
        int i=l-1, j=h+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if(i>=j){
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
