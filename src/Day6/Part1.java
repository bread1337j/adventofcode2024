package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {
    static int dir = 0;
    static int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static ArrayList<String> memory = new ArrayList<String>(500);
    public static int[] getDir(int dir){
        if(dir<0){
            dir += 4;
            return getDir(dir);
        }
        else if(dir>3){
            dir = dir%4;
            return dirs[dir];
        }else{
            return dirs[dir];
        }
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        try {
            Scanner sc = new Scanner(new File("src/Day6/Input.txt"));
            ArrayList<char[]> maze = new ArrayList<>();
            while(sc.hasNextLine()){
                maze.add(sc.nextLine().toCharArray());
            }
            int gx = 0, gy = 0;
            for(int y=0; y<maze.size(); y++){
                for(int x=0; x<maze.get(0).length; x++){
                    if(maze.get(y)[x] == '^'){
                        gx = x; gy = y;
                    }
                }
            }

            while(true){
                try{
                    int checkx = gx + getDir(dir)[0];
                    int checky = gy + getDir(dir)[1];
                    if(maze.get(checky)[checkx] == '#'){
                        dir--;
                    }else{
                        maze.get(gy)[gx] = 'X';
                        gx = checkx;
                        gy = checky;
                    }
                }catch(IndexOutOfBoundsException e){
                    e.printStackTrace();
                    break;
                }

            }

            int c = 1; //to account for the error when exiting
            for(int y=0; y<maze.size(); y++){
                //System.out.println(Arrays.toString(maze.get(y)));
                for(int x=0; x<maze.get(0).length; x++){
                    if(maze.get(y)[x] == 'X'){
                        c++;
                    }
                }
            }
            System.out.println(c);
            System.out.println("Time taken to execute: " + ((double)(System.nanoTime()-start) / 1000000000.0) + "s");
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
