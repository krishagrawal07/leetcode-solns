class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int left=0,right=n-1,water=0;
        int leftmax=height[left],rightmax=height[right];
        while(left<right){
            if(leftmax<rightmax){
                left++;
                leftmax=Math.max(leftmax,height[left]);
                water+=leftmax-height[left];
            }
            else{
                right--;
                rightmax=Math.max(rightmax,height[right]);
                water+=rightmax-height[right];
            }

        }
        return water;
    }
}