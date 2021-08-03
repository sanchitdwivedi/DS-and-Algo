import java.util.Comparator;
import java.util.PriorityQueue;

class MyPair{
    Integer diff;
    Integer index;
    MyPair(Integer d, Integer i){
        this.diff = d;
        this.index = i;
    }
    public Integer getDiff() 
    { 
        return diff; 
    } 
    public void setDiff(Integer diff) 
    { 
        this.diff = diff; 
    } 
    public Integer getIndex() 
    { 
        return index; 
    } 
    public void setIndex(Integer index) 
    { 
        this.index = index; 
    } 
}

public class KClosestElements {
    public static void main(String[] args) {
        int arr[] = {30, 40, 32, 33, 36, 37};
        int k = 3;
        int x = 38;

        kClosest(arr, arr.length, k, x);
    }

    public static void kClosest(int arr[], int n, int k, int x){
        PriorityQueue<MyPair> pq = new PriorityQueue<>(new Comparator<MyPair>() 
        { 
            public int compare(MyPair p1, MyPair p2) 
            { 
                return p2.getDiff().compareTo( 
                       p1.getDiff()); 
            } 
        }); 
        for(int i=0; i<k; i++){
            pq.add(new MyPair(Math.abs(arr[i]-x), i));
        }
        for(int i=k; i<n; i++){
            if(pq.peek().diff > Math.abs(arr[i]-x)){
                pq.remove();
                pq.add(new MyPair(Math.abs(arr[i]-x), i));
            }
        }
        while(!pq.isEmpty()){
            System.out.print(arr[pq.remove().index] + " ");
        }
    }
}