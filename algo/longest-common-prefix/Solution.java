class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        String origin = strs[0];
        if (strs.length == 1) {
            return origin;
        }
        for (int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (!checkChar(c, i, strs[j])) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    private boolean checkChar(char c, int pos, String s) {
        if (s.length() <= pos) {
            return false;
        }
        return c == s.charAt(pos);
    }
}
