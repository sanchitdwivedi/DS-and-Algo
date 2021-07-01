class NodeRandom {
    int data;
    NodeRandom next;
    NodeRandom random;

    public NodeRandom(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class CloneRandomLL {
    public static void main(String[] args) {
        NodeRandom first = new NodeRandom(10);
        NodeRandom second = new NodeRandom(5);
        NodeRandom third = new NodeRandom(20);

        first.next = second;
        first.random = third;
        second.next = third;
        second.random = first;
        third.random = second;

        cloneLL(first);

        for(NodeRandom curr=first.next; curr!=null; curr=curr.next.next){
            System.out.println(curr.data + " Random -> " + curr.random.data);
            if(curr.next==null){
                break;
            }
        }
    }

    public static void cloneLL(NodeRandom first){
        for(NodeRandom curr=first; curr!=null; ){
            NodeRandom next = curr.next;
            curr.next = new NodeRandom(curr.data);
            curr.next.next = next;
            curr = next;
        }

        for(NodeRandom curr=first; curr!=null; curr=curr.next.next){
            curr.next.random = (curr.random!=null) ? curr.random.next : null;
        }
    }
}
