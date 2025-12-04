package testJava;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

        // Array class
        ArrayClass ac = new ArrayClass();
        int[] A = {2, 3, 4, 5, 6};
        int[][] B = {{0, 2}, {1, 3}, {0, 4}};
        int[] result = ac.searcharray(A, B);
        System.out.println(result);
        int resultsum = ac.sumarray(A);
        System.out.println(resultsum);
        System.out.println(ac.maxarray(A));
        
        ac.reversearray(A);
        System.out.println("Reversed Array: " + Arrays.toString(A));
        
        ac.subarrays(A);
        System.out.println(Arrays.toString(A));
        
        // string class
        StringClass sh = new StringClass();
        String st = "Welcometoscaler";
        String up = "WelComETOScaleR";
        String sim = "aabbcd";
        int a = 2;
        
        System.out.println(sh.vowelsRemove(st));
        System.out.println();
        System.out.println(sh.vowelsReserve(st));
        System.out.println(sh.UpperToLowerCase(up));
        System.out.println(sh.RemoveString(sim,a));
        System.out.println(sh.reverseString(st));
        
        
        
    }

}
