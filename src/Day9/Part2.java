package Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static int countOccurences(String[] lordsaveme, String please){
        int c = 0;
        for(String s : lordsaveme){
            if (s.equals(please)){
                c++;
            }
        }
        //System.out.println(c);
        return c;
    }

    public static boolean contains(String[] aaaaaa, String b){
        for(String s : aaaaaa){
            //System.out.println(s);
            if(s.equals(b)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day9/Input.txt"));
            String ermwhatthesigma = sc.nextLine();
            ArrayList<String[]> s = new ArrayList<>();
            //System.out.println(ermwhatthesigma);
            for(int i=0; i<ermwhatthesigma.length()+2; i+=2){
                try {
                    //s += (new String(new char[Integer.parseInt(String.valueOf(ermwhatthesigma.charAt(i)))]).replace("\0", "/" + i / 2 + "|"));
                    //s += (new String(new char[Integer.parseInt(String.valueOf(ermwhatthesigma.charAt(i + 1)))]).replace("\0", "."));
                    String nums = String.valueOf(ermwhatthesigma.charAt(i));
                    ArrayList<String> s2 = new ArrayList<>();
                    for(int j=0; j<Integer.parseInt(nums); j++){
                        s2.add(String.valueOf(i / 2));
                    }
                    String[] s3 = new String[s2.size()];
                    s2.toArray(s3);
                    s.add(s3);


                    String empty = String.valueOf(ermwhatthesigma.charAt(i+1));
                    s2 = new ArrayList<>();
                    for(int j=0; j<Integer.parseInt(empty); j++){
                        s2.add(".");
                    }
                    s3 = new String[s2.size()];
                    s2.toArray(s3);
                    s.add(s3);

                }catch(IndexOutOfBoundsException ignored){}
            }
            //for(String[] s2 : s) {
            //    System.out.print(Arrays.toString(s2));
            //}

            int j = s.size() - 1;
            int i=0;
            for(int iter = 0; iter < 10; iter++) {

                i=0;
                System.out.println("---");
                for (; i < s.size(); i++) {

                    for (String[] s2 : s) {
                        //System.out.print(Arrays.toString(s2));
                    }
                    //System.out.println();
                    if (s.get(i).length > 0 && contains(s.get(i), ".")) {
                        j = s.size() - 1;
                        for (; j >= i; j--) {
                            //System.out.println(s);
                            //System.out.println(Arrays.toString(s.get(i)));
                            //System.out.println(Arrays.toString(s.get(j)));
                            //if(s.get(i)[0].equals("9")){
                            //    System.out.println(Arrays.toString(s.get(i)) + " | " + Arrays.toString(s.get(j)));
                                //System.out.println(!contains(s.get(j), "."));
                                //System.out.println(j > i);
                            //}
                            if(s.get(j).length == 1 && s.get(j)[0].equals("2")){
                                System.out.println(Arrays.toString(s.get(i)) + " | " + Arrays.toString(s.get(j)));
                                System.out.println(!contains(s.get(j), "."));
                                System.out.println(j > i);
                                System.out.println(s.get(j).length <= countOccurences(s.get(i), "."));
                            }


                            if (s.get(j).length > 0 && j > i && s.get(j).length <= countOccurences(s.get(i), ".")) {
                                //System.out.println(Arrays.toString(s.get(i)) + " | " + Arrays.toString(s.get(j)));
                                //System.out.println();
                                boolean toBreak = false;
                                for (int x = 0; x < s.get(j).length; x++) {
                                    if (s.get(i)[x].equals(".")) {
                                        for(int y=0; y<s.get(i).length; y++) {
                                            try {
                                                String temp = s.get(j)[y];
                                                s.get(j)[x] = s.get(i)[x];
                                                s.get(i)[y] = temp;
                                                toBreak = true;
                                            } catch (ArrayIndexOutOfBoundsException ignored) {
                                            }
                                        }
                                    }
                                }
                                if(toBreak) break;

                            }
                        }
                    }
                }
            }
            for (String[] s2 : s) {
                System.out.print(Arrays.toString(s2));
            }


            /*
            long checksum = 0;
            for(int k=0; k<i; k++) {
                try {
                    checksum += k * Long.parseLong(s.get(k));
                }catch(NumberFormatException ignored){}
            }
            System.out.println(checksum);*/

        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
