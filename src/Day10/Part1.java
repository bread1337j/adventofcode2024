package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {

    public static int check(ArrayList<int[]> map, int x, int y, int n, ArrayList<int[]> seen){
        int sum = 0;
        if (map.get(y)[x] == 9) {
            for (int[] ints : seen) {
                if (ints[0] == x && ints[1] == y) {
                    //System.out.println("X--->(" + x + ", " + y + ") : " + 9);
                    return 0;
                }
            }
                //System.out.println("--->(" + x + ", " + y + ") : " + 9);
                seen.add(new int[]{x, y});
                return 1;

            }
            if(n <= 0){
                    return 0;
            }
            else{
                    int val = map.get(y)[x];
                    //System.out.println("(" + x + ", " + y + ") : " + val);
                    try {
                        if ((map.get(y + 1)[x] - val) == 1) {
                            sum += (check(map, x, y+1, n-1, seen));
                        }
                    }catch(IndexOutOfBoundsException ignored){}
                    try {
                         if ((map.get(y - 1)[x] - val) == 1) {
                            sum += (check(map, x, y-1, n-1, seen));
                         }
                    }catch(IndexOutOfBoundsException ignored){}
                    try {
                        if ((map.get(y)[x+1] - val) == 1) {
                            sum += (check(map, x+1, y, n-1, seen));
                        }
                    }catch(IndexOutOfBoundsException ignored){}
                    try {
                        if ((map.get(y)[x-1] - val) == 1) {
                            sum += (check(map, x-1, y, n-1, seen));
                        }
                    }catch(IndexOutOfBoundsException ignored){}
            }

            return sum;
    }



    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day10/Input.txt"));
            ArrayList<int[]> map = new ArrayList<>();
            while(sc.hasNextLine()){
                    String[] str = sc.nextLine().split("");
                    int[] arr = new int[str.length];
                    for(int i=0; i < str.length; i++){
                            arr[i] = (Integer.parseInt(str[i]));
                    }
                    map.add(arr);
            }
            //System.out.println(map);
            int t = 0;
            for(int y = 0; y<map.size(); y++){

                for(int x=0; x<map.get(0).length; x++){

                    if(map.get(y)[x] == 0){
                            //System.out.println("___________________________________");
                            t+=check(map, x, y, 9, new ArrayList<>());
                    }

                }

            }
            System.out.println(t);




        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
