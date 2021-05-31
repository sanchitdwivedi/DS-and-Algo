public class SearchRowAndColSortedMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}};
        int x = 12;
        search(arr, x);
    }

    public static void search(int arr[][], int x){
        int row=0, col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==x){
                System.out.println("Found at (" + row + ", " + col + ")");
                return;
            }
            else if(arr[row][col]>x){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Not found");
    }
}
