package Mathematics;

import java.io.*;

/**
 * HCF
 */
public class EuclideanAlgo {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}