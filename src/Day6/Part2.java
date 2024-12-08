package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
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
            int loops = 0;
            int loop = 1;
            for(int i=0; i < maze.size(); i++){
                System.out.println(i);
                for(int j=0; j<maze.get(0).length; j++){

                    if(maze.get(i)[j] != '#' && maze.get(i)[j] != '^') {
                        loop = 1;

                        /*sc = new Scanner(new File("src/Day6/Input.txt"));
                        maze = new ArrayList<>();
                        while(sc.hasNextLine()){
                            maze.add(sc.nextLine().toCharArray());
                        }*/
                        dir = 0;
                        int gux = gx;
                        int guy = gy;
                        maze.get(i)[j] = 'O';
                        for (int holyhell = 0; holyhell < 10000; holyhell++) {
                            try {
                                int checkx = gux + getDir(dir)[0];
                                int checky = guy + getDir(dir)[1];
                                if (maze.get(checky)[checkx] == '#' || maze.get(checky)[checkx] == 'O' ) {
                                    dir--;
                                } else {
                                    //maze.get(guy)[gux] = 'X';
                                    gux = checkx;
                                    guy = checky;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                //e.printStackTrace();
                                /*System.out.println();
                                for(int i2=0; i2 < maze.size(); i2++){
                                    System.out.println(Arrays.toString(maze.get(i2)));
                                }
                                System.out.println();*/
                                loop = 0;
                                break;
                            }
                        }
                        maze.get(i)[j] = '.';
                        loops += loop;
                    }
                }
            }
            System.out.println(loops);

            /*int c = 1; //to account for the error when exiting
            for(int y=0; y<maze.size(); y++){
                //System.out.println(Arrays.toString(maze.get(y)));
                for(int x=0; x<maze.get(0).length; x++){
                    if(maze.get(y)[x] == 'X'){
                        c++;
                    }
                }
            }*/

            System.out.println("Time taken to execute: " + ((double)(System.nanoTime()-start) / 1000000000.0) + "s");
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
