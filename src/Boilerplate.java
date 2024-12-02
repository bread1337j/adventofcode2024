
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boilerplate {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/.../Input.txt"));
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}
