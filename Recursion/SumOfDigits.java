package Recursion;

import java.io.*;

public class SumOfDigits {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(sum(n));
    }

    public static int sum(int n){
        if(n<10){
            return n;
        }
        return n%10 + sum(n/10);
    }
}
