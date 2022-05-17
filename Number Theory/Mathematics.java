import java.io.*;
import java.util.*;

class Mathematics {
    static long d, x, y; 
    public static void main(String args[] ) throws Exception {
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // long a=Long.parseLong(st.nextToken());
        // long b=Long.parseLong(st.nextToken());
        // long c=Long.parseLong(st.nextToken());
        // long m=Long.parseLong(st.nextToken());

        // System.out.println(solve(a,b,c,m));
        
        // List<Integer> res = segSieve(1,100);
        // for(int p:res) System.out.print(p+" ");

        List<Integer> factors = factorize(100);
        for(int f: factors) System.out.print(f+" ");
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

    // O(nloglogn)
    public static List<Long> sieve(long n){
        List<Long> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[(int)n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i) isPrime[j] = false;
            }
        }
        for(long i=0; i<=n; i++){
            if(isPrime[(int)i]) primes.add(i);
        }
        return primes;
    }
    // O(sqrt(h)loglogh)
    public static List<Long> segSieve(long l, long h){
        boolean isPrime[] = new boolean[(int)(h-l+1)];
        Arrays.fill(isPrime, true);
        List<Long> primes = sieve((long)Math.sqrt(h));
        for(long prime: primes){
            long sm = (l/prime)*prime;
            if(sm<l) sm+=prime;
            // sm+=prime;
            for(; sm<=h; sm+=prime){
                if(prime==sm) continue;
                isPrime[(int)(sm-l)] = false;
            }
        }
        List<Long> res = new ArrayList<>();
        for(long i=Math.max(2,l); i<=h; i++){
            if(isPrime[(int)(i-l)]) res.add(i);
        }
        return res;
    } 

    // O(sqrt(n))
    public static List<Integer> factorize(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            while(n%i==0){
                factors.add(i);
                n=n/i;
            }
        }
        if(n!=1) factors.add(n);
        return factors;
    }
}
