/**
 * LongestProperPrefixAndAlsoSuffix => Part 1 of KMP algorithm (Constructing LPS array)
 */
public class LongestProperPrefixAndAlsoSuffix {
    public static void main(String[] args) {
        String s = "aaabaaaac";
        char str[] = s.toCharArray();
        int lps[] = new int[s.length()];
        fillLPS(str, lps);
        for(int i: lps){
            System.out.print(i + " ");
        }
    }

    public static void fillLPS(char str[], int lps[]){
        int n = str.length, len=0;
        int i=1;
        lps[0] = 0;
        while(i<n){
            if(str[i] == str[len]){
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