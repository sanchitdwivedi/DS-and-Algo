package Recursion;

import java.io.*;

public class RopCutting {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(maxPieces(n, a, b, c));
    }

    public static int maxPieces(int n, int a, int b, int c){
        if(n==0) return 0;
        if(n<0) return -1;
        int res = Math.max(maxPieces(n-a, a, b, c),
                            Math.max(maxPieces(n-b, a, b, c),
                            maxPieces(n-c, a, b, c)));
        if(res==-1) return -1;
        return res+1;
    }
}
