package BitMagic;
import java.io.*;

// Count number of set bits in 'n'
public class BrianKerningamAlgo {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(setBits(n));
    }

    public static int setBits(int n){
        int res = 0;
        while(n>0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}