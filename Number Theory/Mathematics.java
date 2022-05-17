import java.io.*;
import java.util.*;

class Mathematics {
    static long d, x, y; 
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        long c=Long.parseLong(st.nextToken());
        long m=Long.parseLong(st.nextToken());

        System.out.println(solve(a,b,c,m));
    }

    // Example: Solving => ((a^b)/c)%m and 1<=a,b,c,m<10^9 and gcd(c,m)=1
    public static long solve(long a, long b, long c, long m){
        long a1 = modularExponentiation(a, b, m);
        long b1 = modularInverse(c, m);

        return (a1*b1)%m;
    }

    public static long modularExponentiation(long a, long b, long m){
        long res=1;
        while(b>0){
            if(b%2!=0){
                res = (res*a)%m;
            }
            a=(a*a)%m;
            b=b/2;
        }
        return res;
    }

    public static long modularInverse(long c, long m){
        extendedEuclid(c, m);
        return (x%m + m)%m; // x can be negative
    }

    public static void extendedEuclid(long c, long m){
        if(m==0){
            d = c;
            x = 1;
            y = 0;
        }
        else{
            extendedEuclid(m, c%m);
            long temp = x;
            x = y;
            y = temp - (c/m)*y;
        }
    }
}
