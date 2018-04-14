class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        for (String word: dict) {
            root.insert(word);
        }
        StringBuilder result = new StringBuilder();
        for (String word: sentence.split(" ")) {
            String replacement = root.findFirst(word);
            result.append(replacement == null? word: replacement);
            result.append(" ");
        }
        return result.toString().trim();
        
    }

    public static class Node {
        Map<Character, Node> nodes = new HashMap<>();
        String word = null;

        public void insert(String w) {
            insert(w, w);
        }

        void insert(String w, String original) {
            if (w.isEmpty()) {
                word = original;
            } else {
                Node node = nodes.computeIfAbsent(w.charAt(0), k -> new Node());
                node.insert(w.substring(1), original);
            }
        }

        public String findFirst(String w) {
            if (w.isEmpty()) {
                return word;
            } else {
                if (word == null) {
                    Node node = nodes.get(w.charAt(0));
                    if (node != null) {
                        return node.findFirst(w.substring(1));
                    }
                }
                return word;
            }

        }
    }
}
