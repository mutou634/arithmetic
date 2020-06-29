class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(new ArrayList<Integer>() {{ add(1); }});
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}