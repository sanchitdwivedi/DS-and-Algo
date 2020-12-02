package Mathematics;

import java.io.*;
import java.util.Arrays;

// Print all prime numbers less than 'n'
public class SieveOfEratosthenes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sieve(n);
    }

    public static void sieve(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j=j+i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                System.out.print(i + " ");
            }
        }
    }
}