package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2SCRAPPEDAGAIN {
    public static long riftsofbabylon(long x, int count){
        //System.out.println(count);
        if(count == 0){
                return 1;
        }
        if(x == 0){
                return(riftsofbabylon(1, count-1));



        }
        long len = (long)Math.log10(x) + 1;
        if(len%2 == 0){
                //long lp = (long) (Math.floor(Math.pow(10, len/2)));
                return(riftsofbabylon((long) (x / (Math.pow(10, len/2))), count-1) + riftsofbabylon((long) (x % Math.pow(10, len/2)), count-1));
        }





        return riftsofbabylon(x*2024, count-1);
    }


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<Long> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(sc.nextLong());
            }
            long c = 0;
            for(int i=0; i<arr.size(); i++){
                    c+=riftsofbabylon(arr.get(i), 75);
                    System.out.println(i);
            }
            System.out.println(c);
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}