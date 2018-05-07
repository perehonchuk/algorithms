class Solution {
    public int minSteps(int n) {
        int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29,31};
        int res = 0;
        while(n > 1) {
            boolean set = false;
            for (int i = 0; i < prime.length; i++) {
                if (n % prime[i] == 0) {
                    res += prime[i];
                    n = n / prime[i];
                    set = true;
                    break;
                }
            }
            if (!set) {
                res += n;
                break;
            }
        }
        return res;
    }
}
