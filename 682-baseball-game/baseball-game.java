
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int n = list.size();
                list.add(list.get(n - 1) + list.get(n - 2));
            }
            else if (op.equals("D")) {
                int n = list.size();
                list.add(list.get(n - 1) * 2);
            }
            else if (op.equals("C")) {
                list.remove(list.size() - 1);
            }
            else {
                list.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : list) {
            sum += score;
        }

        return sum;
    }
}
