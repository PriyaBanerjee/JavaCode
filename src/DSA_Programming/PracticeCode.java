package DSA_Programming;

public class PracticeCode {
    public static void main(String[] args){
        int[] arr = {8, 7, 2, 5, 3, 1};
        int[] arr1= { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int[][] arr2 = {{3, 4}, {-7, 3}, {1, 3}};
        int l = 2;
        //int r = 10;
        int r = 6;
        sumofarrayLtoR(arr1,l,r);
        sumofarray(arr1, arr2);
    }


    //given an array N , find sum of elements mentioned from left to right
    //TC : o(1)/o(r-l+1)
    public static void sumofarrayLtoR(int[] a, int l , int r){
        int n = a.length;
        int sum = 0;
        if(r >= n || l < 0 || l>r) {
            System.out.println("Array not under boundary range");
            return;
        }
        for(int i = l ; i<=r;i++){
            //sum = r - l + 1;
            sum += a[i];
        }
        System.out.println("Sum of array from L to r element: "+ sum);
    }

    //if no L and r give then
    public static void sumofarray(int[] a, int[][] queries) {
        int n = a.length;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            if (l < 0 || r >= n || l > r) {
                System.out.println("Invalid: [" + l + "," + r + "]");
                continue;
            }
            int sum =0;
            System.out.println("Valid: [" + l + "," + r + "]");
            for (int k = l; k<= r;k++){
                sum = sum + a[k];

            }
            System.out.println("Sum of valid arrays for 2D: " + sum);
        }
    }



}
