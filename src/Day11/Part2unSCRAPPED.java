package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


class chimp{
    long x;
    int count;
    public chimp(long x, int count){
        this.x = x;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        chimp chimp = (chimp) o;
        return x == chimp.x && count == chimp.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, count);
    }
}

public class Part2unSCRAPPED {

    private static Map<chimp, Long> memo = new HashMap<>();

    public static long riftsofbabylon(long x, int count){
        //System.out.println(count);
        chimp c = new chimp(x, count);
        if(memo.containsKey(c)){
            //System.out.println("real");
                return memo.get(c);
        }
        if(count == 0){
            return 1L;
        }
        if(x == 0){
            long result = riftsofbabylon(1, count-1);
            memo.put(c, result);
            return(result);
        }
        long len = (long)Math.log10(x) + 1;
        if(len%2 == 0){
                //long lp = (long) (Math.floor(Math.pow(10, len/2)));
            long result = (riftsofbabylon((long) (x / (Math.pow(10, len/2))), count-1) + riftsofbabylon((long) (x % Math.pow(10, len/2)), count-1));
            memo.put(c, result);
            return(result);

        }





        long result = riftsofbabylon(x*2024, count-1);
        memo.put(c, result);
        return(result);
    }


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<Long> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(sc.nextLong());
            }
            long c = 0;
            long time = System.nanoTime();
            for(int i=0; i<arr.size(); i++){
                    c+=riftsofbabylon(arr.get(i), 75);
                //System.out.println(i);
            }
            System.out.println(c);
            System.out.println("Time taken: " + (double)(System.nanoTime() - time)/1000000000 + "s");
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}