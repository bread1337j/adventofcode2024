package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void blink(ArrayList<Long> arr){
            for(int i=0; i<arr.size(); i++){
                    if(arr.get(i).equals(Long.valueOf(0))){
                        arr.set(i, Long.valueOf(1));
                    } else if (("" + arr.get(i)).length()%2 == 0) {
                        String s = "" + arr.get(i);
                        int slen = s.length();
                        arr.set(i, Long.valueOf(s.substring(slen / 2)));
                        arr.add(i, Long.valueOf(s.substring(0, slen / 2)));
                        i++;

                    } else {
                        arr.set(i, arr.get(i) * 2024);
                    }
                    //System.out.println(arr);
            }
    }
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day11/Input.txt"));
            ArrayList<Long> arr = new ArrayList<>();
            while(sc.hasNext()) {
                arr.add(sc.nextLong());
            }
            for(int i=0; i<25; i++) {
                blink(arr);
                System.out.println(arr.size());
            }
            
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
