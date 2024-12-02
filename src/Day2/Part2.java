package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String[] args) {
        boolean e = false;
        int c = 0;
        try {
            Scanner sc = new Scanner(new File("src/Day2/Input.txt"));
            while(sc.hasNextLine()) {
                String[] s = sc.nextLine().split(" ");

                int[] arr = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    arr[i] = Integer.parseInt(s[i]);
                }

                int[] arr2 = arr.clone();
                int[] arr3 = arr.clone();

                Arrays.sort(arr2);
                Arrays.sort(arr3);
                List<Integer> intList = Arrays.stream(arr3)
                        .boxed()
                        .collect(Collectors.toList());
                Collections.reverse(intList);
                for (int i = 0; i < intList.size(); i++) {
                    arr3[i] = intList.get(i).intValue();
                }
                //System.out.println(Arrays.toString(arr));
                //System.out.println(Arrays.toString(arr2));
                //System.out.println(Arrays.toString(arr3));
                boolean normalsort = Arrays.equals(arr, arr2); //Low -> high
                boolean reversesort = Arrays.equals(arr, arr3); //High -> low
                //System.out.println("Normal: " + normalsort + "Reverse: " + reversesort);
                //System.out.println("_____");
                for(int j=-1; j<arr.length; j++){
                    e = false;

                    List<Integer> arr4 = Arrays.stream(arr).boxed().collect(Collectors.toList());

                    if(j>=0) {
                        arr4.remove(j);
                    }
                    List<Integer> arr5 = new ArrayList<>(arr4);
                    List<Integer> arr6 = new ArrayList<>(arr4);
                    Collections.sort(arr5);
                    Collections.sort(arr6);
                    Collections.reverse(arr6);
                    normalsort = arr4.equals(arr5); //Low -> high
                    reversesort = arr4.equals(arr6); //High -> low

                    //System.out.println(arr4);
                    if(normalsort || reversesort){

                        e = true;
                        for(int i=0; i<arr4.size()-1; i++){
                            int diff = Math.abs(arr4.get(i + 1).intValue() - arr4.get(i).intValue());
                            if(diff == 1 || diff == 2 || diff == 3){
                                //System.out.println(arr4.get(i+1) + " - " + arr4.get(i) + " | " + diff);
                            }else{
                                //System.out.println(diff);
                                e = false;
                                break;
                            }
                        }
                        if(e){
                            System.out.println(Arrays.toString(arr));
                            break;
                        }
                    }
                }

                if(e){
                    c+=1;
                }


            }
            System.out.println(c);
        }catch(FileNotFoundException err){err.printStackTrace();}



    }
}
