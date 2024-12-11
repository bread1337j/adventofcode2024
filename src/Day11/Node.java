package Day11;

public class Node {
    long val;
    Node pointer;
    public Node(long val, Node pointer){
        this.val = val;
        this.pointer = pointer;
    }
    public Node(long val){
        this.val = val;
        this.pointer = null;
    }

    public String toString() {
        return super.toString() + " | " + val + " | " + pointer;
    }
    //getter methods aren't real BTW
}
