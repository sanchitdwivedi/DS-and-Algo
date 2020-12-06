package Recursion;

import java.io.*;

public class Subset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printSubsets(str, "", 0);
    }

    public static void printSubsets(String str, String curr, int index){
        if(index==str.length()){
            System.out.println(curr);
            return;
        }
        printSubsets(str, curr, index+1);
        printSubsets(str, curr+str.charAt(index), index+1);
    }
}
