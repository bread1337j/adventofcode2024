package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class randomchimpevent {
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    static boolean toPrint = false;
    public static boolean checkString(String s){
        if(s.substring(0, 4).equals("mul(")){
            String s2[] = s.substring(4, s.length()).split(","); //Insane levels of trollage going on rn.
            if(s2.length < 2){
                if(toPrint) System.out.println("Array is too small, returning false.");
                return false;
            }
            if (isInteger(s2[0], 10)){

                if(s2[1].length() < 2){
                    if(toPrint) System.out.println("Length less than 2. Literally cannot have both a ) and a number. Returning false");
                    return false;
                }
                if(isInteger(s2[1].substring(0, s2[1].length()-1), 10)){
                    if (s2[1].charAt(s2[1].length()-1) == ')'){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    if(toPrint) System.out.println(s2[1].substring(0, s2[1].length()-1) + " is not an integer, returning false on level 2.");
                    return false;
                }
            }else{
                if(toPrint) System.out.println(s2[0] + " is not an integer, returning false." + Arrays.toString(s2));
                return false;
            }
        }else{
            if(toPrint) System.out.println(s.substring(0, 4) + "is not mul(, returning false.");
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day3/Input.txt"));
            int c = 0;
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                for(int i=0; i<s.length()-6; i++) {
                    for (int j = 0; j < 8; j++) {
                        if(4+j+i <= s.length()) {
                            String bebra = s.substring(i, i + 4 + j);
                            if (checkString(bebra)) {
                                String[] sigma = bebra.split(",");
                                //System.out.println(sigma[0].substring(4));
                                c += Integer.parseInt(sigma[0].substring(4)) * Integer.parseInt(sigma[1].substring(0, sigma[1].length()-1));

                            }
                        }
                    }
                }
            }
            System.out.println(c);
            //checkString("mul(8,5)");
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
