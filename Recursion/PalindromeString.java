package Recursion;

import java.io.*;

public class PalindromeString {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(isPalindrome(str, 0, str.length()-1));
    }

    public static boolean isPalindrome(String str, int start, int end){
        if(start>=end){
            return true;
        }
        return (str.charAt(start)==str.charAt(end) && isPalindrome(str, start+1, end-1));
    }
}
