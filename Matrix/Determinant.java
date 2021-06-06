public class Determinant {
    public static void main(String[] args) {
        int arr[][] = {{1, 0, 2, -1},
                        {3, 0, 0, 5},
                        {2, 1, 4, -3},
                        {1, 0, 5, 0}};
        
        System.out.println(findDeterminant(arr, arr.length));
    }

    public static int findDeterminant(int arr[][], int n){
        if(n==1){
            return arr[0][0];
        }
        if(n==2){
            return arr[0][0]*arr[1][1] - arr[0][1]*arr[1][0];
        }
        int det=0;
        for(int i=0; i<n; i++){
            int newarr[][] = getCofactor(arr, i, n);
            det += Math.pow(-1, i) * arr[0][i]*findDeterminant(newarr, n-1);
        }
        return det;
    }

    public static int[][] getCofactor(int arr[][], int index, int n){
        int i=0, j=0;
        int newarr[][] = new int[n-1][n-1];
        for(int row=1; row<n; row++){
            for(int col=0; col<n; col++){
                if(col!=index){
                    newarr[i][j] = arr[row][col];
                    j++;
                    if(j==n-1){
                        j=0;
                        i++;
                    }
                }
            }
        }
        return newarr;
    }
}
