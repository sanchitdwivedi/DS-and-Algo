public class AnagramSearch {
    public static void main(String[] args) {
        String str = "abcdgda";
        String pat = "gcd";

        System.out.println(isPresent(str, pat));
    }

    public static boolean isPresent(String str, String pat){
        int count_str[] = new int[256];
        int count_pat[] = new int[256];

        for(int i=0; i<pat.length(); i++){
            count_str[str.charAt(i)]++;
            count_pat[pat.charAt(i)]++;
        }

        for(int i=pat.length(); i<str.length(); i++){
            if(areSame(count_pat, count_str)){
                return true;
            }
            count_str[str.charAt(i)]++;
            count_str[str.charAt(i - pat.length())]--;
        }
        return false;
    }

    public static boolean areSame(int count_pat[], int count_str[]){
        for(int i=0; i<256; i++){
            if(count_pat[i] != count_str[i]){
                return false;
            }
        }
        return true;
    }
}
