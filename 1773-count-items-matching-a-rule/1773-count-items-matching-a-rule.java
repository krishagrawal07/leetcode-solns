class Solution {
    public int countMatches(List<List<String>> items, String rulekey, String rulevalue) {
        //like 1st example hme color dekhna he wo bhi silver
        int key=0,res=0;
        int count=0;
        if(rulekey.equals("type")){
            key=0;

        }
        else if(rulekey.equals("color")){
            key=1;
        }
        else{
            key=2;
        }
        for(List<String>temp:items){
            if(temp.get(key).equals(rulevalue)) count++;
        }
        return count;
    }
}