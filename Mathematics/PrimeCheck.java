package Mathematics;

import java.io.*;
public class PrimeCheck {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(isPrime(n)){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }

    public static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5; i*i <= n; i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
