import java.util.Arrays;

public class MeetingMaxGuests {
    public static void main(String[] args) {
        int arr[] = {900, 600, 700};
        int dep[] = {1000, 800, 730};

        System.out.println(maxGuest(arr, dep, arr.length));
    }

    public static int maxGuest(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0, j=0, res=0, curr=0;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                i++;
                curr++;
            }
            else{
                j++;
                curr--;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
