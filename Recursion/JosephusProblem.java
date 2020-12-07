package Recursion;

import java.io.*;

public class JosephusProblem {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(jos(n, k));
    }

    public static int jos(int n, int k){
        if(n==1){
            return 0;
        }
        return (jos(n-1, k) + k)%n;
    }
}
