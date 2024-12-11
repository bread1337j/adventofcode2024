package Day11;

public class occurint {
    public long val; //value
    public int frq; //frequency

    public occurint(long val){
            this.val = val;
            this.frq = 1; //if more than 1, then big issues.
    }
    public String toString(){
            return "{" + val + "," + frq + "}";
    }
}
