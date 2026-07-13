class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Line 1: Three pointers initialize karo
        // i = m - 1  → nums1 ke last VALID element pe point karega
        // j = n - 1  → nums2 ke last element pe point karega  
        // k = m + n - 1 → nums1 ke last position pe point karega (merge ka destination)
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        // Line 2: Jab tak nums2 ke elements bache hain (j >= 0)
        // Kyunki nums2 ke saare elements nums1 mein dalne hain
        while (j >= 0) {
            
            // Line 3: Check karo ki nums1 mein bhi elements bache hain (i >= 0)
            // AUR nums1 ka current element nums2 ke current element se BADA hai
            if (i >= 0 && nums1[i] > nums2[j]) {
                
                // Line 4: nums1[i] bada hai, toh usko nums1[k] pe rakh do
                // Kyunki bada element end mein jayega (sorted order ke liye)
                nums1[k] = nums1[i];
                i--;  // nums1 ka pointer ek step peeche le aao
                
            } else {
                
                // Line 5: Ya toh nums1 khatam ho gaya (i < 0)
                // Ya phir nums2[j] bada ya barabar hai
                // Toh nums2[j] ko nums1[k] pe rakh do
                nums1[k] = nums2[j];
                j--;  // nums2 ka pointer ek step peeche le aao
            }
            
            // Line 6: Destination pointer ko ek step peeche le aao
            // Kyunki ek element place ho gaya, ab next position pe dalna hai
            k--;
        }
        
        // Line 7: Agar loop khatam ho gaya
        // Iska matlab nums2 ke saare elements nums1 mein aa gaye
        // Agar nums1 ke kuch elements bache hain, wo already apni jagah pe hain
        // Kyunki wo pehle se hi sorted the
    }
}