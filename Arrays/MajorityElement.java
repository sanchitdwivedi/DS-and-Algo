package Arrays;

import java.io.*;

//Moore's Voting Algo ==> Find majority element (element occuring more than n/2 times)
public class MajorityElement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMajority(arr, n));   //Printing the index of majority element
    }

    public static int findMajority(int arr[], int n) {
        //Finding a candidate
        int res = 0, count = 1;
        for(int i=1; i<n; i++){
            if(arr[res]==arr[i]){
                count++;
            }
            else count--;
            if(count==0){
                count = 1;
                res = i;
            }
        }
        //Checking if the found candidate is actually a majority
        count= 0;
        for(int i=0; i<n; i++){
            if(arr[res]==arr[i]){
                count++;
            }
        }
        if(count<=n/2) return -1;
        return res;
    }
}
