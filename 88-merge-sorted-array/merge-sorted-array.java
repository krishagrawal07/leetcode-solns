class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr3=new int[m+n];
        for(int i=0;i<m;i++){
            arr3[i]=nums1[i];
        }
            for(int i=0;i<n;i++){
                arr3[m+i]=nums2[i];
            }

        Arrays.sort(arr3);
            for(int i=0;i<m+n;i++){
                nums1[i]=arr3[i];
            }
    }
}