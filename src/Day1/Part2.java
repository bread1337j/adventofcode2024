package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        ArrayList<Integer> sigma = new ArrayList<>();
        ArrayList<Integer> alpha = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/Day1/Input.txt"));
            while(sc.hasNext()){
                sigma.add(sc.nextInt());
                alpha.add(sc.nextInt());
            }
            int c = 0;
            for(int i=0; i<sigma.size(); i++){
                int num = 0;
                for(int j=0; j<alpha.size(); j++){
                    if(alpha.get(j).equals(sigma.get(i))){
                        System.out.println('a');
                        num++;
                    }
                }
                c += Math.abs(sigma.get(i))*num;
            }
            System.out.println(c);
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
