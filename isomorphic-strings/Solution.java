class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverse = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            char sc = sChars[i];
            char tc = tChars[i];
            Character res = mapping.putIfAbsent(sc, tc);
            if (res != null && res != tc) {
                return false;
            }
            res = reverse.putIfAbsent(tc, sc);
            if (res != null && res != sc) {
                return false;
            }
        }
        return true;
    }
}
