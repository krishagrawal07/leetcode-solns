class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row= new ArrayList<>();
        if(numRows==0) return result;
        row.add(1);
        result.add(row);
        for(int i =1;i<numRows;i++){
            List<Integer> prevrow = result.get(i - 1);
            List<Integer> currrow=new ArrayList<>();
            currrow.add(1);
            for(int j=1;j<i;j++){
                currrow.add(prevrow.get(j)+prevrow.get(j-1));
            }
            currrow.add(1);
            result.add(new ArrayList<>(currrow));
        }
        return result;
    }
}