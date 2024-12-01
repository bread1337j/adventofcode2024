package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> sigma = new ArrayList<>();
        ArrayList<Integer> alpha = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/Day1/Input.txt"));
            while(sc.hasNext()){
                sigma.add(sc.nextInt());
                alpha.add(sc.nextInt());
            }
            Collections.sort(sigma);
            Collections.sort(alpha);
            System.out.println(sigma);
            System.out.println(alpha);
            int c = 0;
            for(int i=0; i<sigma.size(); i++){
                c += Math.abs(sigma.get(i) - alpha.get(i));
            }
            System.out.println(c);


        }catch(FileNotFoundException e){e.printStackTrace();}



    }
}
