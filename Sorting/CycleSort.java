public class CycleSort {
    public static void main(String[] args) {
        int arr[] = {1, 8, 3, 9, 10, 10, 2, 4};
        cycleSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void cycleSort(int arr[], int n){
        for(int cs=0; cs<n-1; cs++){
            int item = arr[cs];
            int pos = cs;
            for(int i=cs+1; i<n; i++){
                if(arr[i] < item){
                    pos++;
                }
            }
            if (pos == cs)
                continue;

            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;

            // put the item to it's right position
            if (pos != cs) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }

            while(pos != cs){
                pos = cs;
                for(int i=cs+1; i<n; i++){
                    if(arr[i] < item){
                        pos++;
                    }
                }
                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;
                // put the item to it's right position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                }
            }

        }
    }
}
