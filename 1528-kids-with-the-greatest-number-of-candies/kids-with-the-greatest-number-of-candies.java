class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = candies[0];
        // Find maximum candies
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        // Check each child
        for (int i = 0; i < candies.length; i++) {

            if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;

    }
}