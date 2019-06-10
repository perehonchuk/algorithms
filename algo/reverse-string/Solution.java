class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            char tmp = c[i];
            c[i] = c[c.length - i - 1];
            c[c.length - i - 1] = tmp;
        }
        return new String(c);
    }
}
