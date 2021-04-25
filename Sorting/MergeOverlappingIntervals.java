import java.util.*;

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(5, 10));
        list.add(new Interval(3, 15));
        list.add(new Interval(18, 30));
        list.add(new Interval(2, 7));

        int res = mergeIntervals(list, list.size());

        for(int i=0; i<=res; i++){
            System.out.println(list.get(i).start + " " + list.get(i).end);
        }
    }

    public static int mergeIntervals(ArrayList<Interval> list, int n){
        Collections.sort(list, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        int res=0;
        for(int i=1; i<n; i++){
            if(list.get(res).end >= list.get(i).start){
                list.get(res).start = Math.min(list.get(res).start, list.get(i).start);
                list.get(res).end = Math.max(list.get(res).end, list.get(i).end);
            }
            else{
                res++;
                list.add(res, list.get(i));
            }
        }
        return res;
    }
}
