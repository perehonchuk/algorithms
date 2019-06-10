class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int []count = new int[26];
        for (char c: s.toCharArray()) {
            count[((int)c) - 97] = count[((int)c) - 97] + 1;
        }
        for (char c: t.toCharArray()) {
            count[((int)c) - 97] = count[((int)c) - 97] - 1;
            if (count[((int)c) - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}
