package DSA_Programming;

import java.util.Arrays;

public class twoDMatrix {
    public static void main(String[] args){
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] antidiagonalop = antidiagonal(mat);
        System.out.println(Arrays.deepToString(antidiagonalop));
        int[][] allAntiDiagonalop = allAntiDiagonal(mat);
        System.out.println(Arrays.deepToString(allAntiDiagonalop));
        int[][] mat1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 2, 3, 4}};
        int[] colsumop = colsum(mat1);
        System.out.println(Arrays.toString(colsumop));
        int[] rowsumop = rowsum(mat1);
        System.out.println(Arrays.toString(rowsumop));
        int[][] mat2 = {{1,2,3,4},{5,6,7,0},{9,2,0,4}};
        int[][] rowtocolumnZeroop = rowtocolumnZero(mat2);
        System.out.println((Arrays.deepToString(rowtocolumnZeroop)));
        int[] pricipalDiagonalop = pricipalDiagonal(mat);
        System.out.println((Arrays.toString(pricipalDiagonalop)));
        int[][] MaxtrixProductop = MaxtrixProduct(mat,2);
        System.out.println((Arrays.deepToString(MaxtrixProductop)));
        int[][] mat3 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat4 = {{1,2,3},{4,5,6}};
        int[][] transposeop = transpose(mat3);
        int[][] transposeNonsquareop = transposeNonsquare(mat4);
        System.out.println((Arrays.deepToString(transposeop)));
        System.out.println((Arrays.deepToString(transposeNonsquareop)));
    }

    //Print Anti Diagonal
    public static int[][] antidiagonal(int[][] A){
        int n = A.length;
        int r = 0 ;
        int c = n-1;
        int[][] res = new int[1][n];
        while(r< n && c >= 0){
            res[0][r] = A[r][c];
            r++;
            c--;
        }
        return res;
    }

    //Q1. Anti Diagonals
    //Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
    public static int[][] allAntiDiagonal(int[][] A){
        int n = A.length;
        int[][] res = new int[2*n-1][n];
        int row = 0;
        for(int cl = 0 ; cl<n;cl++){
            int r = 0 , c= cl, k=0;
            while(r<n && c>=0 ){
                res[row][k++] = A[r][c];
                r++;
                c--;
            }
            row++;
        }
        for(int rw=1;rw<n;rw++){
            int r = rw, c =n-1,k=0;
            while(r< n && c >= 0){
                res[row][k++] = A[r][c];
                r++;
                c--;
            }
            row++;
        }
        return res;
    }

    //Q2. Column Sum
    //You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
    public static int[] colsum(int[][] A){
        int row = A.length;
        int cols = A[0].length;
        int[] sum = new int[cols] ;
        for(int c = 0 ; c < cols ; c++){
            for(int r=0;r<row;r++){
                sum[c] += A[r][c];
            }
        }
        return sum;
    }

    //Q3. Row Sum
    //You are given a 2D matrix A of integers.
    //Your task is to compute the sum of elements in each row and return a 1D array where each element represents the sum of a corresponding row in the matrix.
    public static int[] rowsum(int[][] A){
        int row = A.length;
        int col = A[0].length;
        int[] sum = new int[row];
        for(int r = 0; r<row;r++){
            for(int c = 0 ; c < col ; c++){
                sum[r] += A[r][c];
            }
        }
        return sum;
    }

    //Q4. Row to Column Zero
    //You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
    public static int[][] rowtocolumnZero(int[][] A){
        int row = A.length;
        int cols = A[0].length;
        // travers through row search 0 if found make flag true and next mark it to -1
        for(int r = 0 ; r < row ;r++){
            boolean flag = false;
            for(int c=0;c<cols;c++){
                if(A[r][c] == 0 ){
                    flag = true;
                }
            }
            if(flag == true){
                for(int c =0 ; c< cols;c++){
                    if(A[r][c] != 0){
                        A[r][c] = -1;
                    }
                }
            }
        }
        // travers through COLUMN search 0 if found make flag true and next mark it to -1
        for(int c = 0 ; c< cols;c++){
            boolean flag = false;
            for(int r = 0 ; r< row;r++){
                if(A[r][c] == 0){
                    flag = true;
                }
            }
            if(flag == true){
                for(int r = 0 ; r< row;r++){
                    A[r][c] = -1;
                }
            }
        }
        // CONVERT ALL -1 TO 0 BY TRAVERSING BY rOW AND COLUMN
        for(int r = 0 ; r< row ;r++){
            for(int c = 0 ; c<cols;c++){
                if(A[r][c] == -1){
                    A[r][c] = 0;
                }
            }
        }
        return A;
    }

    //Q5. Main Diagonal Sum
    //You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
    //Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.
    //Principle Diagonal
    public static int[] pricipalDiagonal(int[][] A){
        int n = A.length;
        int[] sum = new int[n];
        for(int i = 0 ; i < n;i++){
            sum[0] += A[i][i];
        }
        return sum;
    }

    //Q2. Matrix Scalar Product
    public static int[][] MaxtrixProduct(int[][] A, int B) {
        int r = A.length;
        int c =  A[0].length;
        int[][] res = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c;j++){
                res[i][j] = A[i][j] * B;
            }
        }
        return res;
    }

    //29/12/2025
    //Given a 2D integer array A, return the transpose of A.
    //The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
    //Q5. Matrix Transpose
    public static int[][] transpose(int[][] A) { // Square matrix
        int n = A.length;
        for(int r = 0 ; r< n ; r++){
            for(int c = r+1 ; c < n ; c++) {
                if (r != c) {
                    int temp = A[r][c];
                    A[r][c] = A[c][r];
                    A[c][r] = temp;
                }else{
                    A[r][c] = A[r][c];
                }
            }
        }
    return A;
    }

    //Time: O(rows × cols), Space: O(cols × rows)
    public static int[][] transposeNonsquare(int[][] A){
        int rows = A.length;
        int cols = A[0].length;
        int[][] transpose = new int[cols][rows];
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }


}
