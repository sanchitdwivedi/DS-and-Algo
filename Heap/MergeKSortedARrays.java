import java.util.*;

class Triplet implements Comparable<Triplet> {
    int value;
    int arrayPointer;
    int valuePointer;
    Triplet(int v, int ap, int vp){
        value = v;
        arrayPointer = ap;
        valuePointer = vp;
    }
    @Override
    public int compareTo(Triplet t) {
        if(value <= t.value) return -1;
        else return 1;
    }
    
}

public class MergeKSortedARrays {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > arr=new ArrayList<ArrayList<Integer>>();
	
        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
            a1.add(10); 
            a1.add(20);
            a1.add(30);
            arr.add(a1); 
    
            ArrayList<Integer> a2 = new ArrayList<Integer>(); 
            a2.add(5);
            a2.add(15);
            arr.add(a2); 
    
            ArrayList<Integer> a3 = new ArrayList<Integer>(); 
            a3.add(1); 
            a3.add(9); 
            a3.add(11);
            a3.add(18);
            arr.add(a3);
            
        List<Integer> res = mergeArr(arr); 

        for (int x : res) 
            System.out.print(x + " ");
    }

    // Time Complexity => O(n*k*log(k))
    public static List<Integer> mergeArr(ArrayList<ArrayList<Integer> > arr){
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0; i<arr.size(); i++){
            pq.add(new Triplet(arr.get(i).get(0), i, 0));
        }

        while(!pq.isEmpty()){
            Triplet t = pq.remove();
            int v = t.value;
            int ap = t.arrayPointer;
            int vp = t.valuePointer;

            res.add(v);

            if(vp+1 < arr.get(ap).size()){
                pq.add(new Triplet(arr.get(ap).get(vp+1), ap, vp+1));
            }
        }
        return res;
    }
}
