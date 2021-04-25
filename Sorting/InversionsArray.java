import java.io.*;

/**
 * InversionsArray
 */
public class InversionsArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(countInv(arr, 0, n-1));
    }

    public static int countInv(int arr[], int l, int r){
        int res=0;
        if(l<r){
            int mid = l + (r-l)/2;
            res += countInv(arr, l, mid);
            res += countInv(arr, mid+1, r);
            res += countAndMerge(arr, l, mid, r);
        }
        return res;
    }

    public static int countAndMerge(int arr[], int l, int mid, int r){
        int n1 = mid-l+1, n2 = r-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0; i<n1; i++){
            left[i] = arr[l+i];
        }
        for(int i=0; i<n2; i++){
            right[i] = arr[mid+1+i];
        }
        int res=0, i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }
            else{
                arr[k] = right[j];
                k++;
                j++;
                res += n1-i;
            }
        }
        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}