package Mathematics;

import java.io.*;
/**
 * trailingZeros
 */
public class trailingZeros {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int res = 0;
        for (int i = 5; i <= n; i=i*5) {
            res = res + n/i;
        }
        System.out.println(res);
    }
}