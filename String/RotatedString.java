/**
 * RotatedString
 */
public class RotatedString {
    public static void main(String[] args) {
        String str = "abcd";
        String rot = "cdab";

        System.out.println(check(str, rot));
    }

    public static boolean check(String str, String rot){
        if(str.length() != rot.length()){
            return false;
        }
        return (str+str).indexOf(rot) >= 0;
    }
}