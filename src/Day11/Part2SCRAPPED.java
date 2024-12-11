package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2SCRAPPED {
    public static Node arrayToList(ArrayList<Long> a) {
        Node succ = null;
        Node n = null;
        for (int i = a.size()-1; i >= 0; i--) {
            n = new Node(a.get(i), succ );
            succ = n;
        }
        return n;
    }
    public static long nodeSize(Node starter){
        long c = 0;
        while (starter != null){
                c++;
                starter = starter.pointer;
        }
        return c;
    }
    public static String nodeToString(Node starter){
            String s = new String();
            while (starter != null){
                s+= "| " + starter.val + " |";
                starter = starter.pointer;
            }
            return s;
    }
    public static void blink(Node starter) {
        while(starter != null) {
            long val = starter.val;
            if (val == 0) {
                //long time = System.nanoTime();
                starter.val = 1;
                //System.out.println("0 to 1 time: " + (System.nanoTime() - time));
            } else {
                double len = Math.floor(Math.log10(val)) + 1;
                if (len % 2 == 0) {
                    //long time = System.nanoTime();
                    long lp = (long) Math.pow(10, len/2);
                    //long time = System.nanoTime();
                    starter.val = ((val / lp));
                    starter.pointer = new Node(val % lp, starter.pointer);
                    starter = starter.pointer;
                    //System.out.println("Split time: " + (System.nanoTime() - time));

                } else {
                    //long time = System.nanoTime();
                    starter.val *= 2024;
                    //System.out.println("*2024 time: " + (System.nanoTime() - time));
                }

            }
            //System.out.println(val);
            starter = starter.pointer;
        }
    }
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<Long> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(sc.nextLong());
            }
            Node starter = arrayToList(arr);
            System.out.println(starter);
            for(int i=0; i<75; i++) {
                long time = System.nanoTime();
                blink(starter);
                //System.out.println(i + ": " + nodeToString(starter));
                System.out.println(i);
                System.out.println("Time taken: " + ((double)(System.nanoTime()-time) / 1000000000 + "s"));
            }
            //System.out.println(arr);
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
