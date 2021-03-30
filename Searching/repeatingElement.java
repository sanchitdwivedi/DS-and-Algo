package Searching;

import java.io.*;
import java.util.Arrays;

public class repeatingElement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //System.out.println(findElementSimple(arr, n));
        System.out.println(findElementEfficient(arr, n));
    }

    // O(n) time complexity and O(n) space complexity
    public static int findElementSimple(int arr[], int n) {
        boolean arr2[] = new boolean[n];
        Arrays.fill(arr2, false);
        for(int i=0; i<n; i++){
            if(arr2[arr[i]]==true){
                return arr[i];
            }
            arr2[arr[i]] = true;
        }
        return -1;
    }

    // O(n) time complexity and O(1) space complexity
    public static int findElementEfficient(int arr[], int n) {
        int slow = arr[0]+1, fast = arr[0]+1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);
        slow = arr[0]+1;
        while(slow!=fast){
            slow = arr[slow]+1;
            fast = arr[fast]+1;
        }
        return slow-1;
    }
}
