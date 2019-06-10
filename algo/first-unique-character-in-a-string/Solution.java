class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            charCount.compute(c, (k, v) -> v == null? 1 : v + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCount.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
