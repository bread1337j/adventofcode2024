package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Part2 {
    public static int find(ArrayList<occurint> arr, long val){
            for(int i=0; i<arr.size(); i++){
                    if(arr.get(i).val == val){
                            return i;
                    }
            }
            return -1;
    }
    public static void blink(ArrayList<occurint> arr) {
        for(int i=0; i<arr.size(); i++) {
            occurint val = arr.get(i);
            if (val.val == 0) {
                //long time = System.nanoTime();
                int pointer = find(arr, 1);
                if(pointer == -1){
                    arr.add(val);
                }else {
                    arr.remove(i); i--; arr.get(i).val++;
                }
                //System.out.println("0 to 1 time: " + (System.nanoTime() - time));
            } else {
                double len = Math.floor(Math.log10(val.val)) + 1;
                if (len % 2 == 0) {
                    //long time = System.nanoTime();
                    long lp = (long) Math.pow(10, len/2);
                    //long time = System.nanoTime();
                    int pointer = (find(arr, (long)val.val/lp)){

                    }

                    i++;
                    //System.out.println("Split time: " + (System.nanoTime() - time));

                } else {
                    //long time = System.nanoTime();
                    //starter.val *= 2024;
                    //System.out.println("*2024 time: " + (System.nanoTime() - time));
                }

            }
            //System.out.println(val);
            //starter = starter.pointer;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<occurint> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(new occurint(sc.nextLong()));
            }
            System.out.println(arr);


        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
