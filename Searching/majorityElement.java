package Searching;
import java.io.*;

// Moore's voting algo --> finding if an element occurs more than or equal to n/2 times.
public class majorityElement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findmajority(arr, n));
    }

    public static int findmajority(int arr[], int n) {
        //Finding a candidate
        int count=1, res=0;
        for(int i=1; i<n; i++){
            if(arr[res]==arr[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                res=i;
                count=1;
            }
        }
        // checking if the candidate is majority element
        count=0;
        for(int i=0; i<n; i++){
            if(arr[i]==arr[res]){
                count++;
            }
        }
        if(count >= n/2){
            return res;
        }
        return -1;
    }
}
