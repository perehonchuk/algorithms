class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] m = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character, String> mapping = new HashMap<>();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++, i++) {
            mapping.put(c, m[i]);
        }
        Set<String> morseWords = new HashSet<>();
        for (String word: words) {
            StringBuffer buf = new StringBuffer();
            for (char c: word.toCharArray()) {
                buf.append(mapping.get(c));
            }
            morseWords.add(buf.toString());
        }
        return morseWords.size();
    }
}
