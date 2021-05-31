import java.util.Arrays;

/*
 * Assumptions:-
 * 1. Matrix size is odd
 * 2. All elements are distinct
 */
public class RowWiseSortedMedian {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                    {5, 6, 7},
                    {9, 10, 11}};
        
        System.out.println(countMedian(arr));
    }

    public static int countMedian(int arr[][]){
        int min=arr[0][0], max=arr[0][arr[0].length - 1];
        for(int i=0; i<arr.length; i++){
            if(arr[i][0] < min){
                min = arr[i][0];
            }
            if(arr[i][arr[0].length - 1] > max){
                max = arr[i][arr[0].length - 1];
            }
        }

        int medPos = (arr.length*(arr[0].length)+1)/2;
        while(min<max){
            int mid = (min+max)/2, midPos=0;
            for(int i=0; i<arr.length; i++){
                int pos = Arrays.binarySearch(arr[i], mid)+1;
                midPos += Math.abs(pos);
            }
            if(midPos<medPos){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        return min;
    }
}
