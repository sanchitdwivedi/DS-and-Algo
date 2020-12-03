package BitMagic;
import java.io.*;

public class OneOddOcurring {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int res = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            res = res ^ arr[i];
        }
        System.out.println(res);
    }
}
