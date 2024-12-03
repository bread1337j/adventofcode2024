package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {

        try {
            int c = 0;
            int toDo = 1;
            Scanner sc = new Scanner(new File("src/Day3/Input.txt"));
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                for(int i=0; i<s.length()-4; i++){
                    for(int j=0; j<16; j++){
                        if(i+j <= s.length()) {
                            String toCheck = s.substring(i, i + j);
                            if (toCheck.matches("mul\\(\\d{1,3},\\d{1,3}\\)")) {
                                String[] sigma = toCheck.split(",");
                                //System.out.println(sigma[0].substring(4));
                                c += toDo * Integer.parseInt(sigma[0].substring(4)) * Integer.parseInt(sigma[1].substring(0, sigma[1].length() - 1));
                            }
                            if (toCheck.equals("do()")){
                                toDo = 1;
                            }
                            if (toCheck.equals("don't()")){
                                toDo = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(c);
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
