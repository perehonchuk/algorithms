class Solution {
    //2 => 1 + 1  = 1
    //3 => 2 + 1 = 2
    //4 => 3 + 1, 2 + 2 = 4
    //5 => 4 + 1, 3 + 2 = 6
    //1)split n into 2 terms
    //2)for each term lookup cache
    //3)if cache is less then term, choose term
    //4)multiply 2 numbers
    public int integerBreak(int n) {
        int[] cache = new int[58];
        cache[0] = 1;
        cache[1] = 1;
        
        for (int i = 3; i <= n; i++) {
            int m = i % 2 == 0? i / 2: i / 2 + 1;
            int max = 0;
            for (int j = i - 1; j >= m; j--) {
                int g = j >= cache[j - 1]? j : cache[j - 1];
                int h = i - j >= cache[i - j - 1] ? i - j: cache[i - j - 1];
                max = max >= g * h? max: g * h;
            }
            cache[i - 1] = max;
        }
        return cache[n - 1];
    }
}
