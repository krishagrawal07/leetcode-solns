class Solution {
    public void rotate(int[][] matrix) {
        //first row last column bann jaygi...
        int n = matrix.length;

        //transpose

        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){ //j i se kyuki upper triangular acccess kro bass,// j=i se upper triangle swap

                int temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //reverse rows so that they become column
        for(int i=0;i<matrix.length;i++){
            int li = 0 ; //left index
            int ri = n-1;     //right index

            while(li<ri){
                int temp =matrix[i][li];
                matrix[i][li]=matrix[i][ri];
                matrix[i][ri] = temp;

                li++;
                ri--;
            }

        }


    }
}