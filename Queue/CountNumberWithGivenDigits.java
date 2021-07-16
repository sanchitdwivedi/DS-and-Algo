import java.util.*;

/**
 * CountNumberWithGivenDigits
 */
public class CountNumberWithGivenDigits {
    public static void main(String[] args) {
        int n = 10;
		
		printFirstN(n);
    }

    public static void printFirstN(int n){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("5");
        queue.add("6");
        for(int i=0; i<n; i++){
            String curr = queue.remove();
            System.out.print(curr+" ");
            queue.add(curr+"5");
            queue.add(curr+"6");
        }
    }
}