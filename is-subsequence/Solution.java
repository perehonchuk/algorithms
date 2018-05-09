class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = -1;
        Map<Character, List<Integer>> cache = new HashMap<>();
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            cache.computeIfAbsent(c, (k) -> new ArrayList<Integer>());
            cache.get(c).add(j);
        }
        for (int j = 0; j < s.length(); j++) {
            List<Integer> list = cache.get(s.charAt(j));
            if (list == null) {
                return false;
            }
            int newIndex = search(i, list);
            if (newIndex == -1) {
                return false;
            } else {
                i = newIndex;
            }
        }
        return true;
    }

    int search(int index, List<Integer> indexes) {
        int begin = 0;
        int end = indexes.size() - 1;
        while(begin <= end) {
            int i = (end + begin) / 2;
            int e = indexes.get(i);
            if (e > index) {
                if (i - 1 < 0 || indexes.get(i - 1) <= index) {
                    return e;
                }
                end = (end + begin) / 2 - 1;
            } else {
                begin = (end + begin) / 2 + 1;
            }
        }
        return -1;
    }
}
