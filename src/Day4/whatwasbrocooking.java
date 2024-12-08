package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class whatwasbrocooking {
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
                    if (puzzle.get(y)[x] == 'A') {
                        //top right corner
                        try{
                            if(puzzle.get(y+1)[x+1] == 'M'){
                                /*
                                M?S?-M
                                -A-
                                S?-M?S?
                                 */
                                try{
                                    if(puzzle.get(y+1)[x-1] == 'S'){
                                        /*
                                        S-M
                                        -A-
                                        S?-M?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x - 1] == 'S' && puzzle.get(y - 1)[x + 1] == 'M') {
                                                c += 1;

                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}
                                try{
                                    if (puzzle.get(y + 1)[x - 1] == 'M') {
                                        /*
                                        M-M
                                        -A-
                                        S?-S?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x - 1] == 'S' && puzzle.get(y - 1)[x + 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}



                            }
                        }catch(IndexOutOfBoundsException e){}

                        //top left corner
                        try{
                            if(puzzle.get(y+1)[x-1] == 'M'){
                                /*
                                M-M?S?
                                -A-
                                M?S?-S?
                                 */
                                try{
                                    if(puzzle.get(y+1)[x+1] == 'S'){
                                        /*
                                        M-S
                                        -A-
                                        M?-S?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x - 1] == 'M' && puzzle.get(y - 1)[x + 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}
                                try{
                                    if (puzzle.get(y + 1)[x - 1] == 'M') {
                                        /*
                                        M-M
                                        -A-
                                        S?-S?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x - 1] == 'S' && puzzle.get(y - 1)[x + 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}



                            }
                        }catch(IndexOutOfBoundsException e){}


                        //bottom left corner
                        try{
                            if(puzzle.get(y-1)[x-1] == 'M'){
                                /*
                                M?S?-S?
                                -A-
                                M-M?S?
                                 */
                                try{
                                    if(puzzle.get(y+1)[x-1] == 'S'){
                                        /*
                                        S-S?
                                        -A-
                                        M-M?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x + 1] == 'M' && puzzle.get(y + 1)[x + 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}
                                try{
                                    if (puzzle.get(y + 1)[x - 1] == 'M') {
                                        /*
                                        M-S?
                                        -A-
                                        M-S?
                                        */
                                        try {
                                            if (puzzle.get(y - 1)[x + 1] == 'S' && puzzle.get(y + 1)[x + 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}



                            }
                        }catch(IndexOutOfBoundsException e){}

                        //bottom-right corner
                        try{
                            if(puzzle.get(y-1)[x+1] == 'M'){
                                /*
                                S?-M?S?
                                -A-
                                M?S?-M
                                 */
                                try{
                                    if(puzzle.get(y+1)[x+1] == 'S'){
                                        /*
                                        S?-S
                                        -A-
                                        M?-M?
                                        */
                                        try {
                                            if (puzzle.get(y + 1)[x - 1] == 'S' && puzzle.get(y - 1)[x - 1] == 'M') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}
                                try{
                                    if (puzzle.get(y - 1)[x + 1] == 'M') {
                                        /*
                                        S?-M
                                        -A-
                                        S?-M
                                        */
                                        try {
                                            if (puzzle.get(y + 1)[x - 1] == 'S' && puzzle.get(y - 1)[x - 1] == 'S') {
                                                c += 1;
                                            }
                                        }catch(IndexOutOfBoundsException ignored){}
                                    }
                                }catch(IndexOutOfBoundsException ignored){}



                            }
                        }catch(IndexOutOfBoundsException e){}


                        //end of the pain
                    }
                }
            }
            System.out.println(c);






        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
