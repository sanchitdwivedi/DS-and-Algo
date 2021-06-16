/**
 *  KMP algorithm
 */
public class PatternSearching {
    public static void main(String[] args) {
        String s = "ababcababaad";
        String pat = "aba";

        kmp(s, pat);
    }

    public static void kmp(String s, String pat){
        int n = s.length();
        int m = pat.length();
        int lps[] = new int[m];
        fillLPS(pat.toCharArray(), lps);

        int i=0, j=0;
        while(i<n){
            if(pat.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                System.out.print(i-j + " ");
                j = lps[j-1];
            }
            else if(i<n && pat.charAt(j)!=s.charAt(i)){
                if(j==0){
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
    }

    public static void fillLPS(char pat[], int lps[]){
        int n = pat.length;
        lps[0] = 0;
        int i=1, len=0;
        while(i<n){
            if(pat[i]==pat[len]){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len==0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    len = lps[len-1];
                }
            }
        }
    }
}
