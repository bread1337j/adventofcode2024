package Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {
    public static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day9/Input.txt"));
            String ermwhatthesigma = sc.nextLine();
            ArrayList<String> s = new ArrayList<>();
            //System.out.println(ermwhatthesigma);
            for(int i=0; i<ermwhatthesigma.length()+2; i+=2){
                try {
                    //s += (new String(new char[Integer.parseInt(String.valueOf(ermwhatthesigma.charAt(i)))]).replace("\0", "/" + i / 2 + "|"));
                    //s += (new String(new char[Integer.parseInt(String.valueOf(ermwhatthesigma.charAt(i + 1)))]).replace("\0", "."));
                    String nums = String.valueOf(ermwhatthesigma.charAt(i));

                    for(int j=0; j<Integer.parseInt(nums); j++){
                        s.add(String.valueOf(i / 2));
                    }

                    String empty = String.valueOf(ermwhatthesigma.charAt(i+1));
                    //System.out.println(nums);
                    //System.out.println(empty);

                    for(int j=0; j<Integer.parseInt(empty); j++){
                        s.add(".");
                    }

                }catch(IndexOutOfBoundsException ignored){}
            }
            //System.out.println(s);

            int j = s.size() - 1;
            int i=0;
            for(;i<s.size(); i++) {
                if(s.get(i).equals(".")) {
                    for (; j >= 0; j--) {
                        //System.out.println(s);
                        if(!s.get(j).equals(".") && j > i){
                            String temp = s.get(j);
                            s.set(j, s.get(i));
                            s.set(i, temp);
                            break;
                        }
                    }
                }
            }
            System.out.println(s);
            long checksum = 0;
            for(int k=0; k<i; k++) {
                try {
                    checksum += k * Long.parseLong(s.get(k));
                }catch(NumberFormatException ignored){}
            }
            System.out.println(checksum);

        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
