package Mathematics;

import java.io.*;

public class ComputingPower {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        //System.out.println(powerRecursive(x, n));
        System.out.println(powerIterative(x, n));
    }

    public static int powerRecursive(int x, int n){
        if(n==0) return 1;
        int temp = powerRecursive(x, n/2);
        temp = temp * temp;
        if(n%2==0){
            return temp;
        }
        else return temp*x;
    }

    public static int powerIterative(int x, int n){
        int res = 1;
        while(n>0){
            if(n%2!=0){
                res = res * x;
            }
            x = x*x;
            n=n/2;
        }
        return res;
    }
}
