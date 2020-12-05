package BitMagic;
import java.io.*;

public class MaxANDValue {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(maxAndValue(arr, n));
    }

    public static int maxAndValue(int[] arr, int n){
        int res=0, count;
        for(int bit=31; bit>=0; bit--){
            count = checkSetBitElements(res|(1<<bit), arr, n);
            if(count>=2){
                res = res|(1<<bit);
            }
        }
        return res;
    }

    public static int checkSetBitElements(int pattern, int[] arr, int n){
        int count=0;
        for(int i=0; i<n; i++){
            if((pattern & arr[i]) == pattern){
                count++;
            }
        }
        return count;
    }
}
