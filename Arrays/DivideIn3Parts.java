import java.io.*;;

/**
 * Check if a given array can be divided into 3 parts with equal length ===> Prefix sum
 */
public class DivideIn3Parts {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findIndices(arr, n));
    }

    public static String findIndices(int arr[], int n) {
        int prefixSum[] = new int[n];
        prefixSum[0] = arr[0];
        String ans = "";
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        if(prefixSum[n-1]%3 != 0){
            return "-1";
        }
        int i;
        for(i=0; i<n; i++){
            if(prefixSum[i] == prefixSum[n-1]/3){
                ans += "("+i+", ";
                break;
            }
        }
        int j;
        for(j=i+1; j<n; j++){
            if(prefixSum[j]-prefixSum[i] == prefixSum[n-1]/3){
                ans += j+")";
                break;
            }
        }
        if(j>=n){
            return "-1";
        }
        return ans;
    }
}