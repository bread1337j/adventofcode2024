package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day4/Input.txt"));
            ArrayList<char[]> puzzle = new ArrayList<>();
            while(sc.hasNextLine()){
                puzzle.add(sc.nextLine().toCharArray());
            }
            //System.out.println(puzzle.get(1)[1]);
            int c = 0;
            for(int y=1; y<puzzle.size()-1; y++) {
                for(int x=1; x<puzzle.get(0).length-1; x++){
                    if (puzzle.get(y)[x] == 'A') {
                        /*
                        M?S? - M?S?
                             A
                        M?S? - M?S?
                         */

                        if(puzzle.get(y+1)[x-1] == 'M'){
                            if(puzzle.get(y+1)[x+1] == 'M'){
                                if(puzzle.get(y-1)[x-1] == 'S' && puzzle.get(y-1)[x+1] == 'S'){
                                    c++;
                                }
                            }
                            if(puzzle.get(y+1)[x+1] == 'S'){
                                if(puzzle.get(y-1)[x-1] == 'M' && puzzle.get(y-1)[x+1] == 'S'){
                                    c++;
                                }
                            }
                        }

                        if(puzzle.get(y+1)[x-1] == 'S'){
                            if(puzzle.get(y+1)[x+1] == 'M'){
                                if(puzzle.get(y-1)[x-1] == 'S' && puzzle.get(y-1)[x+1] == 'M'){
                                    c++;
                                }
                            }
                            if(puzzle.get(y+1)[x+1] == 'S'){
                                if(puzzle.get(y-1)[x-1] == 'M' && puzzle.get(y-1)[x+1] == 'M'){
                                    c++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(c);






        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
