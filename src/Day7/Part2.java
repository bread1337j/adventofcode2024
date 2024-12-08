package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Part2 {
    public static long check(long result, long[] in){
        if(in.length == 1){
            if(in[0] == result) {
                return result;
            }else{
                return 0;
            }
        }else{
            long[] in2 = new long[in.length-1];
            in2[0] = in[0] + in[1];
            for(int i=2; i<in.length; i++){
                in2[i-1] = in[i];
            }
            //System.out.println(Arrays.toString(in2));
            long bebra = (check(result, in2));
            if(bebra != 0){
                return bebra;
            }
            in2 = new long[in.length-1];
            in2[0] = in[0] * in[1];
            for(int i=2; i<in.length; i++){
                in2[i-1] = in[i];
            }
            long bebra2 = (check(result, in2));
            if(bebra2!=0){
                return bebra2;
            }
            in2 = new long[in.length-1];
            in2[0] = Long.parseLong("" + in[0] + "" + in[1]);
            for(int i=2; i<in.length; i++){
                in2[i-1] = in[i];
            }
            long bebra3 = (check(result, in2));
            if(bebra3!=0){
                return bebra3;
            }

        }
        return 0;
    }



    public static void main(String[] args) {
        try {
            SplittableRandom rand = new SplittableRandom();
            Scanner sc = new Scanner(new File("src/Day7/Input.txt"));
            long sigma = 0;
            while(sc.hasNextLine()){
                String[] s = sc.nextLine().split(": ");
                long result = Long.parseLong(s[0]);
                String[] s2 = s[1].split(" ");
                long[] ops = new long[s2.length];
                for(int i=0; i<s2.length; i++){
                    ops[i] = Long.parseLong(s2[i]);
                }
                sigma += check(result, ops);
            }
            System.out.println(sigma);




        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
