package Arrays;

import java.io.*;

public class LeftRotateByD {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int d = Integer.parseInt(br.readLine());
        leftRotate(arr, d);
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void leftRotate(int[] arr, int d){
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    public static void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
    		arr[left] = arr[right];
    		arr[right] = temp;

    		left++;
    		right--;
        }
    }
}