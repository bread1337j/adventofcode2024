package Day11;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2AGAINSCRAPPEDAAA {
    public static int find(ArrayList<occurint> arr, long val){
            for(int i=0; i<arr.size(); i++){
                    if(arr.get(i).val == val){
                            return i;
                    }
            }
            return -1;
    }
    public static long getLen(ArrayList<occurint> arr){
            long len = 0;
            for(int i=0; i<arr.size(); i++){
                    len += arr.get(i).frq;
            }
            return len;
    }
    public static ArrayList<occurint> blink(ArrayList<occurint> arr) {
        ArrayList<occurint> out = new ArrayList<>((int) (arr.size()*1.5));
        for(int i=0; i<arr.size(); i++) {
            System.out.println(i + " / " + (arr.size()-1));
            //System.out.println(arr);
            occurint val = arr.get(i);
            if (val.val == 0) {
                long pointer = find(arr, 1);
                if(pointer == -1){
                    out.add(new occurint(1, val.frq));
                }else{
                    out.add(new occurint(1, val.frq + arr.get((int) pointer).frq));
                }
            } else {
                double len = Math.floor(Math.log10(val.val)) + 1;
                if (len % 2 == 0) {
                    //long time = System.nanoTime();
                    long lp = (long) Math.pow(10, len/2);
                    long num = val.val;

                    int pointer = (find(arr, num/lp));
                    if(pointer == -1){
                        out.add(new occurint(num%lp, val.frq));
                    }else{
                        out.add(new occurint(num%lp, val.frq + arr.get(pointer).frq));
                    }

                    pointer = (find(arr, num%lp));
                    if(pointer == -1){
                        out.add(new occurint(num%lp, val.frq));
                    }else{
                        out.add(new occurint(num%lp, val.frq + arr.get(pointer).frq));
                    }

                        //arr.remove(i);
                        //i--;


                    //i++;
                    //System.out.println("Split time: " + (System.nanoTime() - time));
                } else {
                    //long time = System.nanoTime();
                    long pointer = (find(arr, val.val * 2024));
                    if(pointer == -1){
                        out.add(new occurint(val.val*2024, val.frq));
                    }else{
                        out.add(new occurint(val.val*2024, val.frq + arr.get((int) pointer).frq));
                    }
                    //System.out.println("*2024 time: " + (System.nanoTime() - time));
                }
            }
            System.out.println("------");
            System.out.println(arr);

            System.out.println(out);
            System.out.println("------");
            //starter = starter.pointer;
        }
        return out;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<occurint> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(new occurint(sc.nextLong()));
            }
            for(int i=0; i<6; i++){
                    //System.out.println();
                    //System.out.println();
                    //System.out.println(i);
                    arr = blink(arr);
                    System.out.println(getLen(arr));
            }

        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
