class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int maxarea=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int w=right-left;
            int area = h*w;
            maxarea=Math.max(maxarea,area);

            if(height[left]<=height[right]) left++;
            else right--;
        }
        return maxarea;
    }
}