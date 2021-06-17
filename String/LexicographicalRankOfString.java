/**
 *  All characters of string should be DISTINCT
 */
public class LexicographicalRankOfString {
   public static void main(String[] args) {
       String str = "STRING";
       System.out.println(lexRank(str));
   } 

   public static int lexRank(String str){
       int count[] = new int[256];
       int n = str.length(), rank=1;
       int mul = fact(n);
       for(int i=0; i<n; i++){
           count[str.charAt(i)]++;
       }
       for(int i=1; i<256; i++){
           count[i] += count[i-1];
       }
       for(int i=0; i<n; i++){
            mul = mul/(n-i);
            rank = rank + count[str.charAt(i)-1]*mul;
            for(int j=str.charAt(i); j<256; j++){
                count[j]--;
            }
       }
       return rank;
   }

   public static int fact(int n){
       int fa = 1;
       while(n!=0){
           fa *= n;
           n--;
       }
       return fa;
   }
}
