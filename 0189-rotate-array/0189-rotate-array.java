class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int n=nums.length;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);


    }
   /* k %= nums.length; isliye kiya kyunki rotation cyclic hota hai.
Example samjho:
Array: [1, 2, 3, 4, 5] (length = 5)
Table
k (given)	Actual rotation needed	k % 5
1	1	1
2	2	2
5	0 (same array)	0
6	1 (5+1 = full round + 1)	1
10	0 (2 full rounds)	0
12	2 (2 full rounds + 2)	2 */


    private void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;

            start++;
            end--;

        }
    }
}