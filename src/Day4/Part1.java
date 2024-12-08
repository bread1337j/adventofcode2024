package Day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Part1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/Day4/Input.txt"));
            ArrayList<char[]> puzzle = new ArrayList<>();
            while(sc.hasNextLine()){
                puzzle.add(sc.nextLine().toCharArray());
            }
            //System.out.println(puzzle.get(1)[1]);
            int c = 0;
            for(int y=0; y<puzzle.size(); y++) {
                for(int x=0; x<puzzle.get(0).length; x++){
                    if (puzzle.get(y)[x] == 'X') {
                        //horizontal
                        try {
                            if (puzzle.get(y)[x + 1] == 'M') {
                                if (puzzle.get(y)[x + 2] == 'A') {
                                    if (puzzle.get(y)[x + 3] == 'S') {
                                        c += 1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        try {
                            if (puzzle.get(y)[x - 1] == 'M') {
                                if (puzzle.get(y)[x - 2] == 'A') {
                                    if (puzzle.get(y)[x - 3] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        //vertical
                        try{
                            if (puzzle.get(y+1)[x] == 'M') {
                                if (puzzle.get(y+2)[x] == 'A') {
                                    if (puzzle.get(y+3)[x] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        try {
                            if (puzzle.get(y - 1)[x] == 'M') {
                                if (puzzle.get(y - 2)[x] == 'A') {
                                    if (puzzle.get(y - 3)[x] == 'S') {
                                        c += 1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        //diagonal
                        try{
                            if (puzzle.get(y+1)[x+1] == 'M') {
                                if (puzzle.get(y+2)[x+2] == 'A') {
                                    if (puzzle.get(y+3)[x+3] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        try{
                            if (puzzle.get(y+1)[x-1] == 'M') {
                                if (puzzle.get(y+2)[x-2] == 'A') {
                                    if (puzzle.get(y+3)[x-3] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        try{
                            if (puzzle.get(y-1)[x+1] == 'M') {
                                if (puzzle.get(y-2)[x+2] == 'A') {
                                    if (puzzle.get(y-3)[x+3] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                        try{
                            if (puzzle.get(y-1)[x-1] == 'M') {
                                if (puzzle.get(y-2)[x-2] == 'A') {
                                    if (puzzle.get(y-3)[x-3] == 'S') {
                                        c+=1;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e){}
                    }
                }
            }
            System.out.println(c);
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}