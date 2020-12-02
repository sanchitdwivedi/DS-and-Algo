package Mathematics;

import java.io.*;

public class PrimeFactors {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        factors(n);
    }

    public static void factors(int n) {
        if(n==1) return;
        while(n%2==0){
            System.out.print(2 + " ");
            n=n/2;
        }
        while(n%3==0){
            System.out.print(3 + " ");
            n=n/3;
        }
        for(int i=5; i*i<=n; i+=6) {
            while(n%i==0){
                System.out.print(i + " ");
                n=n/i;
            }
            while(n%(i+2)==0){
                System.out.print(i+2 + " ");
                n=n/(i+2);
            }
        }
        if(n>3){
            System.out.println(n);
        }
    }
}
