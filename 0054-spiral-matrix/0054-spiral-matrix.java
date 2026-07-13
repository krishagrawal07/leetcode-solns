class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer>result = new ArrayList<>();
        int n=matrix.length;
        int top=0; // starting row;
        int bottom = n-1; //last row
        int left = 0; //first column
        int right = matrix[0].length-1;  // last column
       
       //loop untill all elements are traversed
        while(top<=bottom && left<=right){

            // Traverse the top row from left to right

        for(int i=left;i<=right;i++){

            result.add(matrix[top][i]);

        }
        top++ ;// move the top boundary downward

    // Traverse the right column from top to bottom
        for(int i = top ; i<=bottom;i++){
            result.add(matrix[i][right]);
        }
        right--; // Move the right boundary leftward

        
        // Traverse the bottom row from right to left (only if rows remain)
        if (top <= bottom) {
            for(int i=right;i>=left;i--){

                result.add(matrix[bottom][i]);

            }
            bottom--; // Move the bottom boundary upward
        }

         // Traverse the left column from bottom to top (only if columns remain)

         if(left<=right){
            for(int i =bottom;i>=top;i--){
                result.add(matrix[i][left]);
            }
            left++; //move the left rightward
         }

        }
        return result;
    }
}