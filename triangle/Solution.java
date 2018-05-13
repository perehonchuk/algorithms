class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                List<Integer> t = triangle.get(i);
                int min = getMin(triangle, i, j);
                t.set(j, t.get(j) + min);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
        
    }

    private int getMin(List<List<Integer>> triangle, int i, int j) {
        if (j == 0) {
            return triangle.get(i - 1).get(0);
        }
        if (j == triangle.get(i).size() - 1) {
            return triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);    
        }
        return triangle.get(i - 1).get(j - 1) < triangle.get(i - 1).get(j) ? 
            triangle.get(i - 1).get(j - 1) : triangle.get(i - 1).get(j);
    }
}
