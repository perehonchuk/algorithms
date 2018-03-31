class Solution {
    public int findComplement(int num) {
        if (num >= Integer.MAX_VALUE / 2) {
            return Integer.MAX_VALUE ^ num;
        }
        int n = 1;
        while (n <= num) n*=2;
        return (n - 1) ^ num;
    }
}
