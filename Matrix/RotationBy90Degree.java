import java.io.*;
/**
 * RotationBy90Degree
 */
public class RotationBy90Degree {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int arr[][] = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}};
        
        rotate(arr);

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int arr[][]){
        transpose(arr);
        //Reverse columns
        for(int i=0; i<arr.length; i++){
            int low=0, high=arr.length - 1;
            while(low<high){
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;

                low++;
                high--;
            }
        }
    }

    public static void transpose(int arr[][]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}